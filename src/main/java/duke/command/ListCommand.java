package duke.command;

import duke.storage.Storage;
import duke.taskmanager.TaskManager;
import duke.ui.Ui;

public class ListCommand extends Command{

    @Override
    public void executeCommand(TaskManager taskManager, Ui ui, Storage storage){
        taskManager.listAllTasks();
    }
}
