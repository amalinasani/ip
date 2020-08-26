import java.util.Scanner;
import java.util.Arrays;
import java.lang.String;

public class Duke {
    public static Task[] toDoList = new Task[100];
    public static int taskCount = 0;

    public static final String LINE_HEADER = "\t---------------------------------------";

    public static void main(String[] args) {
        String inputCommand;
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        greet();

        inputCommand = getCommand();

        do {
            if (inputCommand.equals("list")) {
                listAllTasks();
            } else if (inputCommand.equals("blah")) {
                blah();
            } else if (inputCommand.equals("add")) {
                addToList();
            } else {
                String[] commandWords = inputCommand.split(" ");
                if (commandWords[0].equals("done")){
                    int taskNumber = Integer.parseInt(commandWords[1])-1;
                    markTaskAsDone(taskNumber);
                }
            }
            inputCommand = getCommand();
        } while(!inputCommand.equals("bye"));

        goodbye();
    }

    static String getCommand(){
        String inputCommand;
        Scanner in = new Scanner(System.in);
        inputCommand = in.nextLine();
        return inputCommand;
    }

    static void greet(){
        System.out.println(LINE_HEADER);
        System.out.println("\tHello! I'm Duke\n\tWhat can I do for you?\n");
        System.out.println(LINE_HEADER);
    }

    static void listAllTasks(){
        int taskNumber = 1;

        System.out.println("list");
        System.out.println(LINE_HEADER);
        for (Task task: Arrays.copyOf(toDoList, taskCount)){
            String icon = task.getStatusIcon();
            System.out.println(taskNumber + ". " + "[" + icon + "] " + task.description);
            taskNumber++;
        }

        System.out.println(LINE_HEADER);
    }

    static void blah(){
        System.out.println("blah");
        System.out.println(LINE_HEADER);
        System.out.println("\tblah");
        System.out.println(LINE_HEADER);
    }

    static void goodbye(){
        System.out.println("bye");
        System.out.println(LINE_HEADER);
        System.out.println("\tBye. Hope to see you again soon!\n");
        System.out.println(LINE_HEADER);
    }

    static void addToList(){
        String taskDescription;

        Scanner in = new Scanner(System.in);
        taskDescription = in.nextLine();
        Task t = new Task(taskDescription);

        System.out.println(LINE_HEADER);
        System.out.println("added: " + t.description);

        toDoList[taskCount] = t;
        taskCount++;

        System.out.println(LINE_HEADER);
    }

    static void markTaskAsDone(int taskNumber){
        Task task = toDoList[taskNumber];
        task.markAsDone();
        System.out.println(LINE_HEADER);
        System.out.println("\tNice! I've marked this task as done:");
        System.out.println("\t\t[" + task.getStatusIcon() + "] " + task.description);
        System.out.println(LINE_HEADER);
    }
}


