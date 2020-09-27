package duke.taskmanager;

import duke.task.Task;
import duke.task.Deadline;
import duke.task.ToDo;
import duke.task.Event;
import duke.ui.UI;

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
        UI.printDivider();
        System.out.println("\tAdded: " + taskAdded
                + "\nNow you have " + taskCount
                + " task(s) in your list!");
        UI.printDivider();
    }

    // Removes task from taskList
    public void deleteTask(int taskNumber){
        Task task = taskList.get(taskNumber);
        taskList.remove(taskNumber);
        UI.printDivider();
        System.out.println("\tRemoved: " + task
                + "\nNow you have " + taskList.size()
                + " task(s) in your list");
        UI.printDivider();
    }

    // Marks task in taskList as done
    public void markTaskAsDone(int taskNumber){
        Task task = taskList.get(taskNumber);
        if (task.getStatus()){
            UI.printDivider();
            System.out.println("\tThis task has already been marked as done.");
        } else {
            task.markAsDone();
            UI.printDivider();
            System.out.println("\tNice! I've marked this task as done:");
        }
        System.out.println("\t\t" + task);
        UI.printDivider();
    }

    // List all tasks in taskList
    public void listAllTasks(){
        System.out.println("Task List");
        UI.printDivider();
        for (int i =0; i < taskList.size(); i++){
            System.out.println((i+1) + ". " + taskList.get(i));
        }
        UI.printDivider();
    }
}
