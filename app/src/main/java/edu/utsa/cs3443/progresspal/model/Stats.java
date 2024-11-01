package edu.utsa.cs3443.progresspal.model;

public class Stats {
    private int age;
    private int currentStreak;
    private int tasksCompleted;
    private int longestDailyStreak;
    private int mostTasksCompleted;
    private int totalXP;

    public Stats(int age, int currentStreak, int tasksCompleted, int longestDailyStreak, int mostTasksCompleted, int totalXP) {
        this.age = age;
        this.currentStreak = currentStreak;
        this.tasksCompleted = tasksCompleted;
        this.longestDailyStreak = longestDailyStreak;
        this.mostTasksCompleted = mostTasksCompleted;
        this.totalXP = totalXP;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCurrentStreak() {
        return currentStreak;
    }

    public void setCurrentStreak(int currentStreak) {
        this.currentStreak = currentStreak;
    }

    public int getTasksCompleted() {
        return tasksCompleted;
    }

    public void setTasksCompleted(int tasksCompleted) {
        this.tasksCompleted = tasksCompleted;
    }

    public int getLongestDailyStreak() {
        return longestDailyStreak;
    }

    public void setLongestDailyStreak(int longestDailyStreak) {
        this.longestDailyStreak = longestDailyStreak;
    }

    public int getMostTasksCompleted() {
        return mostTasksCompleted;
    }

    public void setMostTasksCompleted(int mostTasksCompleted) {
        this.mostTasksCompleted = mostTasksCompleted;
    }

    public int getTotalXP() {
        return totalXP;
    }

    public void setTotalXP(int totalXP) {
        this.totalXP = totalXP;
    }
}
