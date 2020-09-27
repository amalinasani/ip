package duke;

import java.util.Scanner;
import java.lang.String;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import duke.task.Task;
import duke.task.Deadline;
import duke.task.ToDo;
import duke.task.Event;
import duke.util.DukeException;
import duke.util.InvalidCommandException;

public class Duke {
    public static ArrayList<Task> taskList = new ArrayList<>();
    public static int taskCount = 0;

    public static boolean isExit = false;

    static Scanner in = new Scanner(System.in);
    public static String userInput;

    public static void main(String[] args) {
        printGreeting();
        do {
            try {
                handleUserInput();
            } catch (DukeException e){
                System.out.println("I don't know what that means (u(エ)u)ゞ");
            }
        } while (!isExit);
    }

    // Handles user input
    public static void handleUserInput () throws DukeException{
        userInput = in.nextLine();
        String[] splitUserInput = userInput.split(" ", 2);
        String inputCommand = splitUserInput[0];

        switch (inputCommand.toUpperCase()) {
            case "LIST":
                listAllTasks();
                break;

            case "BYE":
                printGoodbye();
                break;

            case "DELETE":
                try {
                    int taskNumber = Integer.parseInt(splitUserInput[1]) - 1;
                    deleteTask(taskNumber);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Which task?");
                }
                break;

            case "SAVE":
                saveToFile();
                break;

            case "DONE":
                try {
                    int taskNumber = Integer.parseInt(splitUserInput[1]) - 1;
                    markTaskAsDone(taskNumber);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Which task?");
                }
                break;
            case "TODO":
                // Fallthrough
            case "DEADLINE":
                // Fallthrough
            case "EVENT":
                try {
                    addTask(inputCommand.toUpperCase(), splitUserInput[1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("You've forgotten to add a description!");
                }
                break;

            default:
                throw new InvalidCommandException();
        }
    }

    // Add task to taskList
    static void addTask(String taskType, String details){
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
        System.out.println(LINE_HEADER + "\tAdded: " + taskAdded
                            + "\nNow you have " + taskCount
                            + " task(s) in your list!" + LINE_HEADER);

    }

    // Removes task from taskList
    static void deleteTask(int taskNumber){
        Task task = taskList.get(taskNumber);
        taskList.remove(taskNumber);
        System.out.println(LINE_HEADER + "\tRemoved: " + task
                            + "\nNow you have " + taskList.size()
                            + " task(s) in your list!" + LINE_HEADER);
    }

    // Marks task in taskList as done
    static void markTaskAsDone(int taskNumber){
        Task task = taskList.get(taskNumber);
        if (task.getStatus()){
            System.out.println(LINE_HEADER + "\tThis task has already been marked as done.");
        } else {
            task.markAsDone();
            System.out.println(LINE_HEADER + "\tNice! I've marked this task as done:");
        }
        System.out.println("\t\t" + task  + LINE_HEADER);
    }

    // List all tasks in taskList
    static void listAllTasks(){
        System.out.println("Task List" + LINE_HEADER);

        for (int i =0; i < taskList.size(); i++){
            System.out.print((i+1) + ". ");
            System.out.println(taskList.get(i));
        }

        System.out.println(LINE_HEADER);
    }

    // Save to file
    static void saveToFile(){
        final String FILE_DIR = "data";
        final String FILE_PATH = "data/data.txt";

        FileWriter writer;
        File fileDir = new File(FILE_DIR);

        if (!fileDir.exists()){
            fileDir.mkdir();
        }

        try {
            writer = new FileWriter(FILE_PATH);
            for (Task task : taskList) {
                writer.write(task.getTaskType() + " | " + task.getStatus() + " | "
                        + task.getDescription() + " | " + task.getDate() + System.lineSeparator());
            }
            writer.close();
            System.out.println("Successfully saved to file!");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}


