package duke.task;

/**
 * Class to create new Deadline task
 * Inherits from {@link Task}
 *
 * @author Amalina Sani
 * */
public class Deadline extends Task{

    /**
     * Constructor for Deadline class
     *
     * @param description The Deadline description
     * @param byDate The Deadline date
     */
    public Deadline(String description, String byDate) {
        super(description);
        this.date = byDate;
        this.taskType = 'D';
    }

    /**
     * Returns Deadline task type, status, description, and date
     *
     * @return Deadline task type, status, description, and date
     */
    @Override
    public String toString() {
        return "[" + taskType +"]" + super.toString() + "(by: " + date + ")";
    }
}
