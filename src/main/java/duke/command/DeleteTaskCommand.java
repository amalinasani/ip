package duke.command;

import duke.storage.Storage;
import duke.taskmanager.TaskManager;
import duke.ui.Ui;

public class DeleteTaskCommand extends Command{
    private final int  index;

    public DeleteTaskCommand(int index){
        this.index = index-1;
    }

    @Override
    public void executeCommand(TaskManager taskManager, Ui ui, Storage storage) {
        taskManager.deleteTask(index);
    }
}
