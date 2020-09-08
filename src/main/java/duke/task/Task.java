package duke.task;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description){
        this.description = description;
        this.isDone = false;
    }

    public boolean getStatus(){
        return isDone;
    }

    public String getStatusIcon(){
        return (isDone ? "\u2713" : "\u2718");
    }

    public void markAsDone(){
        isDone = true;
    }

    @Override
    public String toString(){
        return "[" + getStatusIcon() + "] " + description;
    }
}