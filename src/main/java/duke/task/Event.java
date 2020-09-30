package duke.task;

/**
 * Class to create new Event task
 * Inherits from {@link Task}
 *
 * @author Amalina Sani
 * */
public class Event extends Task {

    /**
     * Constructor for Event class
     *
     * @param description The Event description
     * @param eventDate The Event date
     */
    public Event(String description, String eventDate) {
        super(description);
        this.date = eventDate;
        this.taskType = 'E';
    }

    /**
     * Returns Event task type, status, description, and date
     *
     * @return The Event task type, status, description, and date
     */
    @Override
    public String toString() {
        return "[" + taskType +"]" + super.toString() + "(at: " + date + ")";
    }
}
