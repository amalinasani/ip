package duke;

import java.util.Scanner;
import java.lang.String;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

import duke.exception.DukeException;
import duke.exception.InvalidCommandException;

public class Duke {

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
}


