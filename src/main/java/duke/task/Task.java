package duke.task;

public class Task {
    protected String description;
    protected boolean isDone;
    protected char taskType;
    protected String date;

    public Task(String description){
        this.description = description;
        this.isDone = false;
        this.taskType = ' ';
        this.date = "";
    }

    public boolean getStatus(){
        return isDone;
    }

    public String getStatusIcon(){
        return (isDone ? "\u2713" : "\u2718");
    }

    public char getTaskType(){
        return taskType;
    }

    public String getDate(){
        return date;
    }

    public String getDescription(){
        return description;
    }

    public void markAsDone(){
        isDone = true;
    }

    @Override
    public String toString(){
        return "[" + getStatusIcon() + "] " + description;
    }
}