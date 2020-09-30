package duke.command;

import duke.storage.Storage;
import duke.taskmanager.TaskManager;
import duke.ui.Ui;

import java.io.IOException;

/**
 * Class to handle saving taskList to file
 * Inherits from {@link Command}
 *
 * @author Amalina Sani
 * */
public class SaveCommand extends Command{

    /**
     * Executes command for saving tasks in taskList to .txt file
     * Catches file IOException
     *
     * @param taskManager The task manager to handle task commands
     * @param ui The Ui for interfacing with the user
     * @param storage The Storage for file IO
     */
    @Override
    public void executeCommand(TaskManager taskManager, Ui ui, Storage storage) {
        try {
            storage.saveToFile(taskManager.getTasks());
        } catch (IOException e){
            Ui.printLoadErrorMessage();
        }
    }
}
