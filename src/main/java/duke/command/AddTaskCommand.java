package duke.command;

import duke.exception.InvalidIndexException;
import duke.storage.Storage;
import duke.taskmanager.TaskManager;
import duke.ui.Ui;

public class AddTaskCommand extends Command {
    private String taskType;
    private String taskDescription;

    public AddTaskCommand(String taskType, String taskDescription){
        this.taskType = taskType;
        this.taskDescription = taskDescription;
    }
    @Override
    public void executeCommand(TaskManager taskManager, Ui ui, Storage storage) throws InvalidIndexException {
        taskManager.addTask(taskType, taskDescription);
    }
}
