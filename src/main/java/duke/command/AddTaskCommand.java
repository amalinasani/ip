package duke.command;

import duke.storage.Storage;
import duke.taskmanager.TaskManager;
import duke.ui.Ui;

/**
 * Class to handle creation and addition of a new Todo, Event or DeadLine task to TaskList.
 * Inherits from {@link Command}
 *
 * @author Amalina Sani
 * */
public class AddTaskCommand extends Command {
    private final String taskType;
    private final String taskDescription;

    /**
     * Constructor for AddTaskCommand class
     *
     * @param taskType The task type (Todo, Deadline, or Event)
     * @param taskDescription The task description
     * */
    public AddTaskCommand(String taskType, String taskDescription){
        this.taskType = taskType;
        this.taskDescription = taskDescription;
    }

    /**
     * Executes command for adding a new Task into task list
     *
     * @param taskManager The task manager to handle task commands
     * @param ui The Ui for interfacing with the user
     * @param storage The Storage for file IO
     */
    @Override
    public void executeCommand(TaskManager taskManager, Ui ui, Storage storage){
        taskManager.addTask(taskType, taskDescription);
    }
}
