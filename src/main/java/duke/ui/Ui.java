package duke.ui;

import duke.task.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    public static final String LINE_DIVIDER =
            "=====================================================";
    public static final String DUKE_INTRODUCTION =
            "\t\t\t\t\tHello from";
    public static final String DUKE_GREETINGS =
            "\tHello! I'm your friendly neighbourhood Llama.\n\tWhat can I do for you?";
    public static final String LOGO_NAME =
            "  ____  ____   _      _       ____  ___ ___   ____ \n" +
             " /    ||    \\ | |    | |     /    ||   |   | /    |\n" +
             "|  o  ||  _  || |    | |    |  o  || _   _ ||  o  |\n" +
             "|     ||  |  || |___ | |___ |     ||  \\_/  ||     |\n" +
             "|  _  ||  |  ||     ||     ||  _  ||   |   ||  _  |\n" +
             "|  |  ||  |  ||     ||     ||  |  ||   |   ||  |  |\n" +
             "|__|__||__|__||_____||_____||__|__||___|___||__|__|";
    public static final String LOGO_BYE =
            "\n ____                ▓▓  ▓▓                                \n" +
            "|    \\            ▓▓░░▓▓░░▓▓                              \n" +
            "|  o  )          ▓▓▓▓░░░░░░▓▓                              \n" +
            "|     |        ▓▓░░░░░░██░░▓▓                              \n" +
            "|  O  |        ▓▓░░░░░░░░░░▓▓                              \n" +
            "|     |          ▓▓▓▓░░░░░░▓▓                              \n" +
            "|_____|              ▓▓░░░░▓▓                              \n" +
            " __ __               ▓▓░░░░▓▓                ▓▓            \n" +
            "|  |  |              ▓▓░░░░▓▓              ▓▓░░▓▓          \n" +
            "|  |  |              ▓▓░░░░▓▓              ▓▓░░▓▓          \n" +
            "|  ~  |              ▓▓░░░░░░▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░░░▓▓          \n" +
            "|___, |              ▓▓░░░░░░░░░░░░░░░░░░░░░░▓▓            \n" +
            "|     |              ▓▓░░░░░░░░░░░░░░░░░░░░░░▓▓            \n" +
            "|____/               ▓▓░░░░░░░░░░░░░░░░░░░░░░▓▓            \n" +
            "   ___               ▓▓░░░░░░░░░░░░░░░░░░░░░░▓▓            \n" +
            "  /  _]              ▒▒░░▒▒░░▒▒▒▒░░░░░░░░░░▒▒▓▓            \n" +
            " /  [_                 ▓▓░░░░░░░░░░░░░░░░░░▓▓              \n" +
            "|    _]                ▓▓▓▓▓▓░░▓▓▓▓▓▓▓▓▓▓░░▓▓              \n" +
            "|   [_                 ▓▓░░▓▓░░▓▓  ▓▓░░▓▓░░▓▓              \n" +
            "|     |                ▓▓░░▓▓░░▓▓  ▓▓░░▓▓░░▓▓              \n" +
            "|_____|                ▓▓░░▓▓░░▓▓  ▓▓░░▓▓░░▓▓              \n" +
            "                         ▒▒  ▓▓      ▓▓  ▓▓  ";

    public static final String ERROR_MESSAGE_IOEXCEPTION = "\tLoad Error";
    public static final String ERROR_MESSAGE_NO_DESC = "\tYou forgot the description!";
    public static final String ERROR_MESSAGE_NO_DATE = "\tYou forgot the date!";
    public static final String ERROR_MESSAGE_INVALID_COMMAND = "\tSorry, I don't understand :(";
    public static final String ERROR_MESSAGE_NO_NUM = "\tWhich task?";
    public static final String ERROR_MESSAGE_NO_TASK = "\tYou don't have that task!";
    public static final String STORAGE_MESSAGE_SUCCESSFUL_SAVE = "\tSuccessfully saved to file!";
    public static final String STORAGE_MESSAGE_SUCCESSFUL_LOAD = "\tLoaded file successfully!";
    public static final String TASK_MESSAGE_ALREADY_DONE = "\tThis task has already been marked as done.";
    public static final String TASK_MESSAGE_MARK_DONE = "\tNice! I've marked this task as done:";
    public static final String TASK_MESSAGE_MATCHED_TASK = "\tThese are the matching tasks from your list!";
    public static final String TASK_MESSAGE_NO_MATCHES = "\tYou have no matching tasks.";
    public static final String TASK_MESSAGE_LIST = "\tTASK LIST";

    private final Scanner in;
    public Ui() {
        in = new Scanner(System.in);
    }

    /**
     * Read user input
     */
    public String readCommand(){
        return in.nextLine();
    }

    /**
     * Prints line divider
     */
    public static void printDivider(){
        System.out.println(LINE_DIVIDER);
    }

    /**
     * Prints greetings and logo
     */
    public void printGreeting(){
        printDivider();
        System.out.println(DUKE_INTRODUCTION);
        System.out.println(LOGO_NAME);
        System.out.println(DUKE_GREETINGS);
        printDivider();
    }

    /**
     * Prints goodbye message
     */
    public void printGoodbye(){
        printDivider();
        System.out.println(LOGO_BYE);
        printDivider();
    }

    /**
     * Prints add task message
     */
    public static void printAddTaskMessage(Task taskAdded, int taskCount){
        printDivider();
        System.out.println("\tAdded: " + taskAdded
                + "\nNow you have " + taskCount
                + " task(s) in your list!");
        printDivider();
    }

    /**
     * Prints delete task message
     */
    public static void printDeleteTaskMessage(Task taskRemoved, int taskCount){
        printDivider();
        System.out.println("\tRemoved: " + taskRemoved
                + "\nNow you have " + taskCount
                + " task(s) in your list");
        printDivider();
    }

    /**
     * Prints task already done message
     */
    public static void printTaskAlreadyDoneMessage(Task taskDone) {
        printDivider();
        System.out.println(TASK_MESSAGE_ALREADY_DONE);
        System.out.println("\t\t" + taskDone);
    }

    /**
     * Prints task marked as done message
     */
    public static void printTaskMarkedDoneMessage(Task taskDone) {
        printDivider();
        System.out.println(TASK_MESSAGE_MARK_DONE);
        System.out.println("\t\t" + taskDone);
        printDivider();
    }

    /**
     * Prints task list
     */
    public static void printTaskList(ArrayList<Task> taskList){
        System.out.println(TASK_MESSAGE_LIST);
        printDivider();
        for (int i =0; i < taskList.size(); i++){
            System.out.println((i+1) + ". " + taskList.get(i));
        }
        printDivider();
    }

    /**
     * Prints invalid command error message
     */
    public static void printInvalidCommandMessage(){
        printDivider();
        System.out.println(ERROR_MESSAGE_INVALID_COMMAND);
        printDivider();
    }

    /**
     * Prints no date error message
     */
    public static void printErrorNoDateMessage(){
        printDivider();
        System.out.println(ERROR_MESSAGE_NO_DATE);
        printDivider();
    }

    /**
     * Prints no description error message
     */
    public static void printErrorNoDescriptionMessage(){
        printDivider();
        System.out.println(ERROR_MESSAGE_NO_DESC);
        printDivider();
    }

    /**
     * Prints no number error message
     */
    public static void printErrorNoNumMessage(){
        printDivider();
        System.out.println(ERROR_MESSAGE_NO_NUM);
        printDivider();
    }

    /**
     * Prints no task error message
     */
    public static void printErrorNoTaskMessage(){
        printDivider();
        System.out.println(ERROR_MESSAGE_NO_TASK);
        printDivider();
    }

    /**
     * Prints load error message
     */
    public static void printLoadErrorMessage(){
        System.out.println(ERROR_MESSAGE_IOEXCEPTION);
    }

    /**
     * Prints load success message
     */
    public static void printLoadSuccessMessage(){
        System.out.println(STORAGE_MESSAGE_SUCCESSFUL_LOAD);
    }

    /**
     * Prints successful save message
     */
    public static void printSaveSuccessMessage(){
        System.out.println(STORAGE_MESSAGE_SUCCESSFUL_SAVE);
    }

    /**
     * Prints matched tasks message
     */
    public static void printMatchedTaskMessage(){
        System.out.println(TASK_MESSAGE_MATCHED_TASK);
    }

    /**
     * Prints no matched tasks message
     */
    public static void printNoMatchedTaskMessage(){
        printDivider();
        System.out.println(TASK_MESSAGE_NO_MATCHES);
        printDivider();
    }
}
