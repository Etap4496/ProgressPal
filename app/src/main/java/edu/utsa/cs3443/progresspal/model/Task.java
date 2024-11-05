package edu.utsa.cs3443.progresspal.model;

public class Task {
    private String name;
    private String dueDate;
    private int completionTime;
    private boolean completionStatus;
    private int xp;

    public Task(String name, String dueDate, int completionTime) {
        this.name = name;
        this.dueDate = dueDate;
        this.completionTime = completionTime;
        this.xp = completionTime * 50;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(int completionTime) {
        this.completionTime = completionTime;
    }


    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}
