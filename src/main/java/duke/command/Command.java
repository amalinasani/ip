package duke.command;
import duke.storage.Storage;
import duke.ui.Ui;
import duke.taskmanager.TaskManager;

public abstract class Command {
    public static final String COMMAND_LIST = "LIST";
    public static final String COMMAND_BYE = "BYE";
    public static final String COMMAND_DELETE = "DELETE";
    public static final String COMMAND_SAVE = "SAVE";
    public static final String COMMAND_DONE = "DONE";
    public static final String COMMAND_TODO = "TODO";
    public static final String COMMAND_DEADLINE = "DEADLINE";
    public static final String COMMAND_EVENT = "EVENT";
    public static final String COMMAND_FIND = "FIND";

    public abstract void executeCommand(TaskManager taskManager, Ui ui, Storage storage);
    public boolean isExit(){
        return false;
    }
}
