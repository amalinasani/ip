package duke.command;

import duke.storage.Storage;
import duke.taskmanager.TaskManager;
import duke.ui.Ui;

/**
 * Class to provide list of available commands
 * Inherits from {@link Command}
 *
 * @author Amalina Sani
 * */
public class HelpCommand extends Command{
    /**
     * Executes command for providing list of available commands
     *
     * @param taskManager The task manager to handle task commands
     * @param ui The Ui for interfacing with the user
     * @param storage The Storage for file IO
     */
    @Override
    public void executeCommand(TaskManager taskManager, Ui ui, Storage storage) {
        Ui.printHelp();
    }
}
