package duke.command;

import duke.exception.InvalidIndexException;
import duke.storage.Storage;
import duke.taskmanager.TaskManager;
import duke.ui.Ui;

public class AddTaskCommand extends Command {
   private String taskType;
   private String taskDetails;

   public AddTaskCommand(String taskType, String taskDetails){
       this.taskType = taskType;
       this.taskDetails = taskDetails;
   }
    @Override
    public void executeCommand(TaskManager taskManager, Ui ui, Storage storage) throws InvalidIndexException {
        taskManager.addTask(taskType, taskDetails);
    }
}
