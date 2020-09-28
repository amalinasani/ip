package duke.taskmanager;

import duke.task.Task;
import duke.task.Deadline;
import duke.task.ToDo;
import duke.task.Event;
import duke.ui.Ui;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TaskManager {
    public final ArrayList<Task> taskList;
    public int taskCount = 0;

    public TaskManager(){
        taskList = new ArrayList<>();
    }

    // Add task to taskList
    public void addTask(String taskType, String details){
        Task taskAdded;
        String[] detailsWords;

        if (taskType.equals("DEADLINE")){
            detailsWords = details.split("/by ");
            taskAdded = new Deadline(detailsWords[0], detailsWords[1]);
        } else if (taskType.equals("EVENT")){
            detailsWords = details.split("/at ");
            taskAdded = new Event(detailsWords[0], detailsWords[1]);
        } else {
            taskAdded = new ToDo(details);
        }
        taskList.add(taskAdded);
        taskCount++;
        Ui.printDivider();
        System.out.println("\tAdded: " + taskAdded
                + "\nNow you have " + taskCount
                + " task(s) in your list!");
        Ui.printDivider();
    }

    // Removes task from taskList
    public void deleteTask(int taskNumber){
        Task task = taskList.get(taskNumber);
        taskList.remove(taskNumber);
        Ui.printDivider();
        System.out.println("\tRemoved: " + task
                + "\nNow you have " + taskList.size()
                + " task(s) in your list");
        Ui.printDivider();
    }

    // Marks task in taskList as done
    public void markTaskAsDone(int taskNumber){
        Task task = taskList.get(taskNumber);
        if (task.getStatus()){
            Ui.printDivider();
            System.out.println(Ui.TASK_MESSAGE_ALREADY_DONE);
        } else {
            task.markAsDone();
            Ui.printDivider();
            System.out.println(Ui.TASK_MESSAGE_MARK_DONE);
        }
        System.out.println("\t\t" + task);
        Ui.printDivider();
    }

    // List all tasks in taskList
    public void listAllTasks(){
        System.out.println("Task List");
        Ui.printDivider();
        for (int i =0; i < taskList.size(); i++){
            System.out.println((i+1) + ". " + taskList.get(i));
        }
        Ui.printDivider();
    }

    public ArrayList<Task> getTasks(){
        return taskList;
    }
}
