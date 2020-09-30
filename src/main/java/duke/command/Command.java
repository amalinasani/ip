package duke.command;
import duke.storage.Storage;
import duke.ui.Ui;
import duke.taskmanager.TaskManager;

/**
 * Abstract class for AddTask, Bye, DeleteTask, Done, Find, List, Save command classes
 *
 * @author Amalina Sani
 * */
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
    public static final String COMMAND_HELP = "HELP";
    /**
     * Executes command
     *
     * @param taskManager The task manager to handle task commands
     * @param ui The Ui for interfacing with the user
     * @param storage The Storage for file IO
     */
    public abstract void executeCommand(TaskManager taskManager, Ui ui, Storage storage);

    /**
     * Sets isExit to be false
     *
     * @return false
     */
    public boolean isExit(){
        return false;
    }
}
