import java.util.Scanner;
import java.util.Arrays;
import java.lang.String;

public class Duke {
    public static Task[] toDoList = new Task[100];
    public static int taskCount = 0;
    public static final String LINE_HEADER = "▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄";

    public static void main(String[] args) {
        String inputCommand;
        String logo = " _      _       ____  ___ ___   ____ \n"
                + "| |    | |     /    ||   |   | /    |\n"
                + "| |    | |    |  o  || _   _ ||  o  |\n"
                + "| |___ | |___ |     ||  \\_/  ||     |\n"
                + "|     ||     ||  _  ||   |   ||  _  |\n"
                + "|     ||     ||  |  ||   |   ||  |  |\n"
                + "|_____||_____||__|__||___|___||__|__|";
        System.out.println("Hello from\n" + logo);
        greet();

        do {
            inputCommand = getCommand();
            switch (inputCommand){
                case "list":
                    listAllTasks();
                    break;
                case "add":
                    addToList();
                    break;
                case "bye":
                    goodbye();
                    break;
                case "done":
                    String[] commandWords = inputCommand.split(" ");
                    int taskNumber = Integer.parseInt(commandWords[1])-1;
                    markTaskAsDone(taskNumber);
            }
        } while (!inputCommand.equals("bye"));


    }

    static String getCommand(){
        String inputCommand;
        Scanner in = new Scanner(System.in);
        inputCommand = in.nextLine();
        return inputCommand;
    }

    static void greet(){
        System.out.println(LINE_HEADER+ "\n\tHello! I'm your friendly neighbourhood Llama.\n\tWhat can I do for you?\n" + LINE_HEADER);
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

    static void goodbye(){
        System.out.println("bye");

        String logo = "                          ▓▓  ▓▓                                        \n" +
                "                        ▓▓░░▓▓░░▓▓                                      \n" +
                "                      ▓▓▓▓░░░░░░▓▓                                      \n" +
                "                    ▓▓░░░░░░██░░▓▓                                      \n" +
                "                    ▓▓░░░░░░░░░░▓▓                                      \n" +
                "                      ▓▓▓▓░░░░░░▓▓                                      \n" +
                "                          ▓▓░░░░▓▓                                      \n" +
                "                          ▓▓░░░░▓▓                ▓▓                    \n" +
                "                          ▓▓░░░░▓▓              ▓▓░░▓▓                  \n" +
                "                          ▓▓░░░░▓▓              ▓▓░░▓▓                  \n" +
                "                          ▓▓░░░░░░▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░░░▓▓                  \n" +
                "                          ▓▓░░░░░░░░░░░░░░░░░░░░░░▓▓                    \n" +
                "                          ▓▓░░░░░░░░░░░░░░░░░░░░░░▓▓                    \n" +
                "                          ▓▓░░░░░░░░░░░░░░░░░░░░░░▓▓                    \n" +
                "                          ▓▓░░░░░░░░░░░░░░░░░░░░░░▓▓                    \n" +
                "                          ▒▒░░▒▒░░▒▒▒▒░░░░░░░░░░▒▒▓▓                    \n" +
                "                            ▓▓░░░░░░░░░░░░░░░░░░▓▓                      \n" +
                "                            ▓▓▓▓▓▓░░▓▓▓▓▓▓▓▓▓▓░░▓▓                      \n" +
                "                            ▓▓░░▓▓░░▓▓  ▓▓░░▓▓░░▓▓                      \n" +
                "                            ▓▓░░▓▓░░▓▓  ▓▓░░▓▓░░▓▓                      \n" +
                "                            ▓▓░░▓▓░░▓▓  ▓▓░░▓▓░░▓▓                      \n" +
                "                            ▓▓░░▓▓░░▓▓  ▓▓░░▓▓░░▓▓                      \n" +
                "                            ▓▓░░▓▓░░▓▓  ▓▓░░▓▓░░▓▓                      \n" +
                "                              ▒▒  ▓▓      ▓▓  ▓▓  \n";

        System.out.println(LINE_HEADER + "\n\tGoodbye!\n" + logo + LINE_HEADER);
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


