package duke;

import java.io.IOException;
import java.lang.String;

import duke.command.Command;
import duke.exception.*;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.taskmanager.TaskManager;
import duke.ui.Ui;

/**
 * Main class for Duke
 *
 * @author Amalina Sani
 * */
public class Duke {

    private static final String FILE_PATH = "data/duke.txt";
    private TaskManager taskManager;
    private final Ui ui;
    private final Storage storage;

    /**
     * Constructor for Duke class
     * Catches IOException
     *
     * */
    public Duke() {
        ui = new Ui();
        storage = new Storage(FILE_PATH);
        ui.printGreeting();

        try {
            storage.checkFileExists(FILE_PATH);
            taskManager = new TaskManager(storage.loadFromFile());
            Ui.printLoadSuccessMessage();
        } catch (IOException e) {
            Ui.printLoadErrorMessage();
            taskManager = new TaskManager();
        } finally {
            Ui.printDivider();
        }
    }

    /**
     * Parses user input and handles task operations while program is not terminated
     * */
    public void run() {
        boolean isExit= false;
        Parser parser = new Parser();

        do {
            String line = ui.readCommand();
            try {
                Command command = parser.parseCommand(line);
                command.executeCommand(taskManager, ui, storage);
                isExit= command.isExit();
            } catch (InvalidCommandException e) {
                Ui.printInvalidCommandMessage();
            }  catch (InvalidIndexException e) {
                Ui.printErrorNoNumMessage();
            } catch (InvalidArgumentException e){
                Ui.printErrorNoDescriptionMessage();
            } catch (NullPointerException e){
            }
        } while (!isExit);
    }

    /**
     * Main function for Duke
     *
     * */
    public static void main(String[] args) {
        new Duke().run();
    }
}


