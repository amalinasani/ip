package duke.command;

import duke.storage.Storage;
import duke.taskmanager.TaskManager;
import duke.ui.Ui;

/**
 * Class to mark a task as done
 * Inherits from {@link Command}
 *
 * @author Amalina Sani
 * */
public class DoneCommand extends Command {
    private final int index;

    /**
     * Constructor for DoneCommand class
     *
     * @param index The task index
     * */
    public DoneCommand(int index){
        this.index = index;
    }

    /**
     * Executes command for marking a task as done
     *
     * @param taskManager The task manager to handle task commands
     * @param ui The Ui for interfacing with the user
     * @param storage The Storage for file IO
     */
    @Override
    public void executeCommand(TaskManager taskManager, Ui ui, Storage storage) {
        taskManager.markTaskAsDone(index);
    }
}
