package duke.command;

import duke.exception.InvalidIndexException;
import duke.storage.Storage;
import duke.taskmanager.TaskManager;
import duke.ui.Ui;

import java.io.IOException;

public class SaveCommand extends Command{
    @Override
    public void executeCommand(TaskManager taskManager, Ui ui, Storage storage) throws InvalidIndexException {
        try {
            storage.saveToFile(taskManager.getTasks());
        } catch (IOException e){
            System.out.println(Ui.ERROR_MESSAGE_IOEXCEPTION);
        }
    }
}
