package duke.task;

public class Deadline extends Task{

    public Deadline(String description, String byDate) {
        super(description);
        this.date = byDate;
        this.taskType = 'D';
    }

    @Override
    public String toString() {
        return "[" + taskType +"]" + super.toString() + "(by: " + date + ")";
    }
}
