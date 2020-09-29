package duke;

import java.io.IOException;
import java.lang.String;

import duke.command.Command;
import duke.exception.*;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.taskmanager.TaskManager;
import duke.ui.Ui;

public class Duke {

    private static final String FILE_PATH = "data/duke.txt";
    private TaskManager taskManager;
    private final Ui ui;
    private final Storage storage;

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

    public static void main(String[] args) {
        new Duke().run();
    }
}


