import java.util.Scanner;
import java.util.Arrays;
import java.lang.String;

public class Duke {
    public static Task[] taskList = new Task[100];
    public static int taskCount = 0;
    public static final String LINE_HEADER = "\n=====================================================\n";

    public static void main(String[] args) {
        String inputCommand;
        printGreeting();

        // Command handler
        do {
            Scanner in = new Scanner(System.in);
            inputCommand = in.nextLine();

            String taskObj = new Scanner(inputCommand).next();

            switch (taskObj){
                case "list":
                    listAllTasks();
                    break;

                case "bye":
                    printGoodbye();
                    break;

                case "done":
                    String[] commandWords = inputCommand.split(" ");
                    int taskNumber = Integer.parseInt(commandWords[1])-1;
                    markTaskAsDone(taskNumber);
                    break;

                case "todo":
                    String taskDetails = inputCommand.substring(4);
                    addTask(new ToDo(taskDetails));
                    break;

                case "deadline":
                    taskDetails = inputCommand.substring(8);
                    String[] detailsWords = taskDetails.split("/by ");
                    addTask(new Deadline(detailsWords[0], detailsWords[1]));
                    break;

                case "event":
                    taskDetails = inputCommand.substring(5);
                    detailsWords = taskDetails.split("/at ");
                    addTask(new Event(detailsWords[0], detailsWords[1]));
                    break;
            }
        } while (!inputCommand.equals("bye"));
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

    // Add task to taskList
    static void addTask(Task task){
        taskList[taskCount] = task;
        taskCount++;
        System.out.println(LINE_HEADER + "\tAdded: " + task + "\nNow you have " + taskCount + " task(s) in your list!" + LINE_HEADER);
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
        System.out.println("list" + LINE_HEADER);
        for (Task task: Arrays.copyOf(taskList, taskCount)){
            System.out.print(taskNumber + ". ");
            System.out.println(task);
            taskNumber++;
        }
        System.out.println(LINE_HEADER);
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
    }
}


