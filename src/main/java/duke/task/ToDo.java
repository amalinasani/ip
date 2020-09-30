package duke.task;

/**
 * Class to create new ToDo task
 * Inherits from {@link Task}
 *
 * @author Amalina Sani
 * */
public class ToDo extends Task{

    /**
     * Constructor for ToDo class
     *
     * @param description The Todo description
     */
    public ToDo(String description) {
        super(description);
        this.taskType = 'T';
    }

    /**
     * Returns ToDo task type, status, and description
     *
     * @return The ToDo task type, status, and description
     */
    @Override
    public String toString() {
        return "[" + taskType +"]" + super.toString();
    }
}
