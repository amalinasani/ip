package duke.command;

import duke.storage.Storage;
import duke.taskmanager.TaskManager;
import duke.ui.Ui;

/**
 * Class to handle deletion of a Task from taskList.
 * Inherits from {@link Command}
 *
 * @author Amalina Sani
 * */
public class DeleteTaskCommand extends Command{
    private final int  index;

    /**
     * Constructor for DeleteTaskCommand class
     *
     * @param index The task index
     * */
    public DeleteTaskCommand(int index){
        this.index = index;
    }

    /**
     * Executes command for deleting a task from taskList
     *
     * @param taskManager The task manager to handle task commands
     * @param ui The Ui for interfacing with the user
     * @param storage The Storage for file IO
     */
    @Override
    public void executeCommand(TaskManager taskManager, Ui ui, Storage storage) {
        taskManager.deleteTask(index);
    }
}
