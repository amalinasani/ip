package duke.task;

/**
 * Class to create new task
 *
 * @author Amalina Sani
 */
public class Task {
    protected String description;
    protected boolean isDone;
    protected char taskType;
    protected String date;

    /**
     * Default constructor for Task class
     *
     * @param description The task description
     */
    public Task(String description){
        this.description = description;
        this.isDone = false;
        this.taskType = ' ';
        this.date = "";
    }

    /**
     * Get task completion status
     *
     * @return The task completion status
     */
    public boolean getStatus(){
        return isDone;
    }

    /**
     * Get task status icon (tick or cross)
     *
     * @return The task status icon
     */
    public String getStatusIcon(){
        return (isDone ? "\u2713" : "\u2718");
    }

    /**
     * Get task type (ToDo, Deadline, or Event)
     *
     * @return The task type
     */
    public char getTaskType(){
        return taskType;
    }

    /**
     * Get Deadline or Event date
     *
     * @return The date for Deadline or Event
     */
    public String getDate(){
        return date;
    }

    /**
     * Get task description
     *
     * @return The task description
     */
    public String getDescription(){
        return description;
    }

    /**
     * Sets task status isDone = true
     *
     */
    public void markAsDone(){
        isDone = true;
    }

    /**
     * Returns task status and task description
     *
     * @return The task status and task description
     */
    @Override
    public String toString(){
        return "[" + getStatusIcon() + "] " + getDescription();
    }
}