import java.util.Scanner;
import java.util.Arrays;
import java.lang.String;

public class Duke {
    public static Task[] taskList = new Task[100];
    public static int taskCount = 0;

    public static final String LINE_HEADER =
            "\n=====================================================\n";

    public static boolean isExit = false;

    static Scanner in = new Scanner(System.in);
    public static String userInput;

    public static void main(String[] args) {
        printGreeting();
        do {
            try {
                handleUserInput();
            } catch (InvalidCommandException e){
                System.out.println("Invalid Command");
            }
        } while (!isExit);
    }

    // Handles user input
    public static void handleUserInput () throws InvalidCommandException{
        userInput = in.nextLine();
        String[] splitUserInput = userInput.split(" ", 2);
        String inputCommand = splitUserInput[0];
        String details = "";

        try {
            details = splitUserInput[1];
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("No description.");
        }


        switch (inputCommand.toUpperCase()) {
            case "LIST":
                listAllTasks();
                break;

            case "BYE":
                printGoodbye();
                break;

            case "DONE":
                int taskNumber = Integer.parseInt(details) - 1;
                markTaskAsDone(taskNumber);
                break;

            case "TODO":
                // Fallthrough
            case "DEADLINE":
                // Fallthrough
            case "EVENT":
                addTask(inputCommand.toUpperCase(), details);
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
        taskList[taskCount] = taskAdded;
        taskCount++;
        System.out.println(LINE_HEADER + "\tAdded: " + taskAdded + "\nNow you have " + taskCount + " task(s) in your list!" + LINE_HEADER);
    }

    // Marks task in taskList as done
    static void markTaskAsDone(int taskNumber){
        Task task = taskList[taskNumber];
        if (task.isDone){
            System.out.println(LINE_HEADER + "\tThis task has already been marked as done.");
        } else {
            task.markAsDone();
            System.out.println(LINE_HEADER + "\tNice! I've marked this task as done:");
        }
        System.out.println("\t\t" + task  + LINE_HEADER);
    }

    // List all tasks in taskList
    static void listAllTasks(){
        int taskNumber = 1;
        System.out.println("Task List" + LINE_HEADER);
        for (Task task: Arrays.copyOf(taskList, taskCount)){
            System.out.print(taskNumber + ". ");
            System.out.println(task);
            taskNumber++;
        }
        System.out.println(LINE_HEADER);
    }

    // Prints greeting and logo
    static void printGreeting(){
        String logo =     "  ____  ____   _      _       ____  ___ ___   ____ \n"
                + " /    ||    \\ | |    | |     /    ||   |   | /    |\n"
                + "|  o  ||  _  || |    | |    |  o  || _   _ ||  o  |\n"
                + "|     ||  |  || |___ | |___ |     ||  \\_/  ||     |\n"
                + "|  _  ||  |  ||     ||     ||  _  ||   |   ||  _  |\n"
                + "|  |  ||  |  ||     ||     ||  |  ||   |   ||  |  |\n"
                + "|__|__||__|__||_____||_____||__|__||___|___||__|__|";
        System.out.println(LINE_HEADER + "\t\t\t\t\tHello from\n" + logo);
        System.out.println(LINE_HEADER+ "\tHello! I'm your friendly neighbourhood Llama.\n\tWhat can I do for you?" + LINE_HEADER);
    }

    static void printGoodbye(){
        String logo =
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

        System.out.println(LINE_HEADER + logo + LINE_HEADER);
        isExit = true;
    }
}


