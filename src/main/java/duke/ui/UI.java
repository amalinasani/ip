package duke.manager.ui;

public class UI {
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

    public static void printDivider(){
        System.out.println(LINE_DIVIDER);
    }

    // Prints greeting and logo
    public static void printGreeting(){
        printDivider();
        System.out.println(DUKE_INTRODUCTION);
        System.out.println(LOGO_NAME);
        printDivider();
        System.out.println(DUKE_GREETINGS);
        printDivider();
    }

    public static void printGoodbye(){
        printDivider();
        System.out.println(LOGO_BYE);
        printDivider();
        isExit = true;
    }
}
