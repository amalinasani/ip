import java.util.Scanner;
import java.util.Arrays;
import java.lang.String;

public class Duke {
    public static Task[] toDoList = new Task[100];
    public static int taskCount = 0;
    public static final String LINE_HEADER = "\n▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄\n";

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
        printGreeting();

        do {
            inputCommand = getCommand();
            Scanner taskObj = new Scanner(inputCommand);

            switch (taskObj.next()){
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

    static String getCommand(){
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    static void printGreeting(){
        System.out.println(LINE_HEADER+ "\tHello! I'm your friendly neighbourhood Llama.\n\tWhat can I do for you?" + LINE_HEADER);
    }

    static void listAllTasks(){
        int taskNumber = 1;

        System.out.println("list" + LINE_HEADER);
        for (Task task: Arrays.copyOf(toDoList, taskCount)){
            System.out.print(taskNumber + ". ");
            System.out.println(task);
            taskNumber++;
        }
        System.out.println(LINE_HEADER);
    }

    static void printGoodbye(){
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
                "                              ▒▒  ▓▓      ▓▓  ▓▓  ";

        System.out.println(LINE_HEADER + "\tGoodbye!\n" + logo + LINE_HEADER);
    }

    static void addTask(Task task){
        toDoList[taskCount] = task;
        taskCount++;
        System.out.println(LINE_HEADER + "added: " + task + LINE_HEADER);
    }

    static void markTaskAsDone(int taskNumber){
        Task task = toDoList[taskNumber];
        if (task.isDone){
            System.out.println(LINE_HEADER + "\tThis task has already been marked as done.");
            System.out.println("\t\t[" + task.getStatusIcon() + "] " + task.description + LINE_HEADER);
        } else {
            task.markAsDone();
            System.out.println(LINE_HEADER + "\tNice! I've marked this task as done:");
            System.out.println("\t\t" + task  + LINE_HEADER);
        }
    }
}


