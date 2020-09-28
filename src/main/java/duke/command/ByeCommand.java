package duke.command;

import duke.exception.InvalidIndexException;
import duke.storage.Storage;
import duke.taskmanager.TaskManager;
import duke.ui.Ui;

import java.io.IOException;

public class ByeCommand extends Command {
    @Override
    public void executeCommand(TaskManager taskManager, Ui ui, Storage storage) throws InvalidIndexException {
        ui.printGoodbye();
        try {
            storage.saveToFile(taskManager.getTasks());
        } catch (IOException e){
            System.out.println(Ui.ERROR_MESSAGE_IOEXCEPTION);
        }
    }

    @Override
    public boolean isExit(){
        return true;
    }
}
