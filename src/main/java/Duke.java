import java.util.Scanner;

public class Duke {
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
        System.out.println("list");
        System.out.println(LINE_HEADER);
        System.out.println("\tlist");
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
}
