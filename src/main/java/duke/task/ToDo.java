package duke.task;

public class ToDo extends Task{

    public ToDo(String description) {
        super(description);
        this.taskType = 'T';
    }

    @Override
    public String toString() {
        return "[" + taskType +"]" + super.toString();
    }
}
