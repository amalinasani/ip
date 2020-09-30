package duke.command;

import duke.storage.Storage;
import duke.taskmanager.TaskManager;
import duke.ui.Ui;

/**
 * Class to handle finding matching Tasks in taskList from a given keyword
 * Inherits from {@link Command}
 *
 * @author Amalina Sani
 * */
public class FindCommand extends Command{
    private final String word;

    /**
     * Constructor for FindCommand class
     *
     * @param word The keyword from user input
     * */
    public FindCommand(String word){
        this.word = word;
    }

    /**
     * Executes command for finding matching tasks in taskList
     *
     * @param taskManager The task manager to handle task commands
     * @param ui The Ui for interfacing with the user
     * @param storage The Storage for file IO
     */
    @Override
    public void executeCommand(TaskManager taskManager, Ui ui, Storage storage) {
        taskManager.findTask(word);
    }
}
