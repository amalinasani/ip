package duke.command;

import duke.storage.Storage;
import duke.taskmanager.TaskManager;
import duke.ui.Ui;

public class AddTaskCommand extends Command {
    private final String taskType;
    private final String taskDescription;

    public AddTaskCommand(String taskType, String taskDescription){
        this.taskType = taskType;
        this.taskDescription = taskDescription;
    }
    @Override
    public void executeCommand(TaskManager taskManager, Ui ui, Storage storage){
        taskManager.addTask(taskType, taskDescription);
    }
}
