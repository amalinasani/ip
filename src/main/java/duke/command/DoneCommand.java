package duke.command;

import duke.storage.Storage;
import duke.taskmanager.TaskManager;
import duke.ui.Ui;

public class DoneCommand extends Command {
    private final int index;

    public DoneCommand(int index){
        this.index = index;
    }

    @Override
    public void executeCommand(TaskManager taskManager, Ui ui, Storage storage) {
        taskManager.markTaskAsDone(index);
    }
}
