package duke.taskmanager;

import duke.task.Task;
import duke.task.Deadline;
import duke.task.ToDo;
import duke.task.Event;
import duke.ui.Ui;

import java.util.ArrayList;

public class TaskManager {
    private final ArrayList<Task> taskList;

    public TaskManager(){
        taskList = new ArrayList<>();
    }

    public TaskManager(ArrayList<Task> taskList){
        this.taskList = taskList;
    }

    /**
     * Add task to taskList
     */
    public void addTask(String taskType, String details){
        Task taskAdded;
        String[] detailsWords;

        try {
            if (taskType.equals("DEADLINE")) {
                detailsWords = details.split("/by ");
                taskAdded = new Deadline(detailsWords[0], detailsWords[1]);

            } else if (taskType.equals("EVENT")) {
                detailsWords = details.split("/at ");
                taskAdded = new Event(detailsWords[0], detailsWords[1]);

            } else {
                taskAdded = new ToDo(details);
            }

            taskList.add(taskAdded);
            Ui.printAddTaskMessage(taskAdded, taskList.size());

        } catch (IndexOutOfBoundsException e){
            Ui.printErrorNoDateMessage();
        }
    }

    /**
     * Delete task from taskList
     */
    public void deleteTask(int taskNumber){
        try {
            Task taskRemoved = taskList.get(taskNumber);
            taskList.remove(taskNumber);
            Ui.printDeleteTaskMessage(taskRemoved, taskList.size());

        } catch (IndexOutOfBoundsException e) {
            Ui.printErrorNoTaskMessage();
        }
    }

    /**
     * Mark task in taskList as done
     */
    public void markTaskAsDone(int taskNumber){
        try {
            Task task = taskList.get(taskNumber);
            if (task.getStatus()) {
                Ui.printTaskAlreadyDoneMessage(task);

            } else {
                task.markAsDone();
                Ui.printTaskMarkedDoneMessage(task);
            }
        } catch (IndexOutOfBoundsException e) {
            Ui.printErrorNoTaskMessage();
        }
    }

    /**
     * List all tasks in taskList
     */
    public void listAllTasks(){
        Ui.printTaskList(taskList);
    }

    /**
     * Get taskList as array list
     */
    public ArrayList<Task> getTasks(){
        return taskList;
    }

    /**
     * Find matching tasks in task list
     */
    public void findTask(String word) {
        ArrayList<Task> matchedTaskList = new ArrayList<>();
        for (Task task : taskList) {
            String taskDetails = task.getDescription().toUpperCase();
            if (taskDetails.contains(word)) {
                matchedTaskList.add(task);
            }
        }

        if (matchedTaskList.size() == 0) {
            Ui.printNoMatchedTaskMessage();
        } else {
            Ui.printMatchedTaskMessage();
            Ui.printTaskList(matchedTaskList);
        }
    }
}
