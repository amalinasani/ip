package duke.command;

import duke.storage.Storage;
import duke.taskmanager.TaskManager;
import duke.ui.Ui;

import java.io.IOException;

public class ByeCommand extends Command {
    @Override
    public void executeCommand(TaskManager taskManager, Ui ui, Storage storage) {
        ui.printGoodbye();

        try {
            storage.saveToFile(taskManager.getTasks());
        } catch (IOException e){
            Ui.printLoadErrorMessage();
        }
    }

    @Override
    public boolean isExit(){
        return true;
    }
}
