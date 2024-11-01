package edu.utsa.cs3443.progresspal.model;

public class Task {
    private String name;
    private String dueDate;
    private int completionTime;
    private boolean completionStatus;
    private int xp;

    public Task(String name, String dueDate, int completionTime, boolean completionStatus, int xp) {
        this.name = name;
        this.dueDate = dueDate;
        this.completionTime = completionTime;
        this.completionStatus = completionStatus;
        this.xp = xp;
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

    public boolean isCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(boolean completionStatus) {
        this.completionStatus = completionStatus;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}
