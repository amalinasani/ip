package duke.task;

public class Event extends Task {

    public Event(String description, String eventDate) {
        super(description);
        this.date = eventDate;
        this.taskType = 'E';
    }

    @Override
    public String toString() {
        return "[" + taskType +"]" + super.toString() + "(at: " + date + ")";
    }
}
