package duke.command;

import duke.exception.InvalidIndexException;
import duke.storage.Storage;
import duke.taskmanager.TaskManager;
import duke.ui.Ui;

public class DeleteTaskCommand extends Command{
    private int index;

    public DeleteTaskCommand(int index){
        this.index = index;
    }

    @Override
    public void executeCommand(TaskManager taskManager, Ui ui, Storage storage) throws InvalidIndexException {
        taskManager.deleteTask(index);
    }
}
