package duke.command;

import duke.storage.Storage;
import duke.taskmanager.TaskManager;
import duke.ui.Ui;

import java.io.IOException;

/**
 * Class to handle program exit
 * Inherits from {@link Command}
 *
 * @author Amalina Sani
 * */
public class ByeCommand extends Command {

    /**
     * Executes command for exiting program
     *
     * @param taskManager The task manager to handle task commands
     * @param ui The Ui for interfacing with the user
     * @param storage The Storage for file IO
     */
    @Override
    public void executeCommand(TaskManager taskManager, Ui ui, Storage storage) {
        ui.printGoodbye();

        try {
            storage.saveToFile(taskManager.getTasks());
        } catch (IOException e){
            Ui.printLoadErrorMessage();
        }
    }

    /**
     * Sets isExit to be true
     * @return true
     */
    @Override
    public boolean isExit(){
        return true;
    }
}
