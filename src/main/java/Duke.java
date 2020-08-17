public class Duke {
    public static final String LINE_HEADER = "---------------------------------";

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        greet();
        goodbye();
    }

    static void greet(){
        System.out.println(LINE_HEADER);
        System.out.println("Hello! I'm Duke\nWhat can I do for you?\n");
    }

    static void goodbye(){
        System.out.println(LINE_HEADER);
        System.out.println("Bye. Hope to see you again soon!\n");
    }
}
