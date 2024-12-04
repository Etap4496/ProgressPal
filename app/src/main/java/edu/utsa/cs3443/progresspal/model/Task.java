package edu.utsa.cs3443.progresspal.model;

/**
 * The Task class represents a Task object.
 * Each task object has a name, due date, completion time, and xp
 *
 * @author Eli Tapia uxb422
 * @author Mathew Robillard gll855
 * @author Marc Jabian ibs065
 * @author Leslie Henley lbu591
 */
public class Task {
    private String name;
    private String dueDate;
    private int completionTime;
    private int xp;

    /**
     * The constructor for the Task object.
     * @param name
     * @param dueDate
     * @param completionTime
     */
    public Task(String name, String dueDate, int completionTime) {
        this.name = name;
        this.dueDate = dueDate;
        this.completionTime = completionTime;
        this.xp = completionTime * 50;
    }

    /**
     * Gets the name of the Task object
     * @return name, the name of the Task
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Task object
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the due date of the Task object
     * @return dueDate, the due date of the Task object
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * Sets the due date of the Task object
     * @param dueDate
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Gets the completion time of the Task object
     * @return completionTime, the completion time of the Task object
     */
    public int getCompletionTime() {
        return completionTime;
    }

    /**
     * Sets the completion time of the Task object
     * @param completionTime
     */
    public void setCompletionTime(int completionTime) {
        this.completionTime = completionTime;
    }

    /**
     * Gets the XP of the Task object
     * @return xp, the XP of the Task object
     */
    public int getXp() {
        return xp;
    }

    /**
     * Sets the XP of the Task object
     * @param xp
     */
    public void setXp(int xp) {
        this.xp = xp;
    }

    /**
     * Gets the string value of the completion time of the Task object
     * @return String, the string value of the completion time of the Task object
     */
    public String getCompletionTimeString(){
        return String.valueOf(completionTime) + " hrs";
    }

    /**
     * Gets the string value of the XP of the Task object
     * @return String, the string value of the XP of the Task object
     */
    public String getXpString(){
        return String.valueOf(xp) + " xp";
    }
}
