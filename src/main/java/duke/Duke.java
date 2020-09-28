package duke;

import java.io.IOException;
import java.lang.String;
import java.util.ArrayList;

import duke.command.Command;
import duke.exception.*;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.taskmanager.TaskManager;
import duke.ui.Ui;

public class Duke {

    private static final String FILE_PATH = "data/duke.txt";
    private TaskManager taskManager;
    private Ui ui;
    private Storage storage;

    public Duke() {
        ui = new Ui();
        storage = new Storage(FILE_PATH);
        ui.printGreeting();

        try {
            storage.checkFileExists(FILE_PATH);
            taskManager = new TaskManager(storage.loadFromFile());
            System.out.println("Load successful");
        } catch (IOException e) {
            System.out.println("Load error");
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
            Ui.printDivider();
            try {
                Command command = parser.parseCommand(line);
                command.executeCommand(taskManager, ui, storage);
                isExit= command.isExit();
            } catch (InvalidCommandException e) {
                System.out.println("e.getErrorMessage()");
            } catch (InvalidIndexException e) {
                System.out.println("e.getErrorMessage()");
            }
            Ui.printDivider();
        } while (!isExit);
    }

    public static void main(String[] args) {
        new Duke().run();
    }
}


