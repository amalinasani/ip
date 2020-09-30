package duke.command;

import duke.storage.Storage;
import duke.taskmanager.TaskManager;
import duke.ui.Ui;

/**
 * Class to handle listing of all tasks in taskList.
 * Inherits from {@link Command}
 *
 * @author Amalina Sani
 * */
public class ListCommand extends Command{

    /**
     * Executes command for listing all tasks in taskList
     *
     * @param taskManager The task manager to handle task commands
     * @param ui The Ui for interfacing with the user
     * @param storage The Storage for file IO
     */
    @Override
    public void executeCommand(TaskManager taskManager, Ui ui, Storage storage){
        taskManager.listAllTasks();
    }
}
