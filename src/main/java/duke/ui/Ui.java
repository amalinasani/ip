package duke.ui;

import java.util.Scanner;

public class Ui {
    public static final String LINE_DIVIDER =
            "\n=====================================================\n";
    public static final String DUKE_INTRODUCTION =
            "\t\t\t\t\tHello from\n";
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


    public static final String ERROR_MESSAGE_IOEXCEPTION = "IOException error has occurred";
    public static final String MESSAGE_SUCCESSFUL_SAVE = "Successfully saved to file!";
    private final Scanner in;

    /**
     * Read user input
     */
    public Ui() {
        in = new Scanner(System.in);
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
        printDivider();
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
}
