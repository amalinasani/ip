package duke.command;

import duke.storage.Storage;
import duke.taskmanager.TaskManager;
import duke.ui.Ui;

public class FindCommand extends Command{
    private final String word;

    public FindCommand(String word){
        this.word = word;
    }

    @Override
    public void executeCommand(TaskManager taskManager, Ui ui, Storage storage) {
        taskManager.findTask(word);
    }
}
