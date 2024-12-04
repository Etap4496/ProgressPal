package edu.utsa.cs3443.progresspal.model;

import android.app.Activity;
import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * /**
 * The Stats class handles the statistics of a user, including age, streaks, task completion,
 * and experience points. It reads from and writes to a CSV file to persist user data.
 * @author Eli Tapia uxb422
 * @author Mathew Robillard gll855
 * @author Marc Jabian ibs065
 * @author Leslie Henley lbu591
 */
public class Stats {
    private int age;
    private int currentStreak;
    private int tasksCompleted;
    private int longestDailyStreak;
    private int mostTasksCompleted;
    private int totalXP;
    private final Activity activity;
    private final String filename;

    /**
     * Constructs a Stats object associated with a given Activity.
     * @param activity The Activity context used for file operations.
     */
    public Stats(Activity activity) {
        this.activity = activity;
        filename = "stats.csv";
    }

    /**
     * Initializes the stats by attempting to read them from a file.
     * If the file does not exist, it creates a new file.
     */
    public void initializeStats() {
        try {
            System.out.println("Attempting to read from file...");
            InputStream in = activity.openFileInput(filename);
            System.out.println("Success");
            loadStats(in);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to read from file. File does not exist. " + filename);
            try {
                System.out.println("Attempting to create file...");
                OutputStream out = activity.openFileOutput(filename, Context.MODE_PRIVATE);
            } catch (FileNotFoundException e2) {
                System.out.println("Unable to create file. " + filename);
            }
        }
    }

    /**
     * Loads stats from the provided input stream.
     * @param in The InputStream to read the stats data from.
     */
    public void loadStats(InputStream in) {
        if (in != null) {
            Scanner scan = new Scanner(in);

            if (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] tokens = line.split(",");
                setAge(Integer.parseInt(tokens[0]));
                setCurrentStreak(Integer.parseInt(tokens[1]));
                setTasksCompleted(Integer.parseInt(tokens[2]));
                setLongestDailyStreak(Integer.parseInt(tokens[3]));
                setMostTasksCompleted(Integer.parseInt(tokens[4]));
                setTotalXP(Integer.parseInt(tokens[5]));
            }
        }
    }

    /**
     * Saves the current stats to the associated file.
     */
    public void saveStats() {
        try {
            System.out.println("Attempting to save to a file");
            OutputStream out = activity.openFileOutput(filename, Context.MODE_PRIVATE);

            out.write(Integer.toString(age).getBytes(StandardCharsets.UTF_8));
            out.write(",".getBytes(StandardCharsets.UTF_8));
            out.write(Integer.toString(currentStreak).getBytes(StandardCharsets.UTF_8));
            out.write(",".getBytes(StandardCharsets.UTF_8));
            out.write(Integer.toString(tasksCompleted).getBytes(StandardCharsets.UTF_8));
            out.write(",".getBytes(StandardCharsets.UTF_8));
            out.write(Integer.toString(longestDailyStreak).getBytes(StandardCharsets.UTF_8));
            out.write(",".getBytes(StandardCharsets.UTF_8));
            out.write(Integer.toString(mostTasksCompleted).getBytes(StandardCharsets.UTF_8));
            out.write(",".getBytes(StandardCharsets.UTF_8));
            out.write(Integer.toString(totalXP).getBytes(StandardCharsets.UTF_8));
            out.write("\n".getBytes(StandardCharsets.UTF_8));

            out.close();
        } catch (IOException e) {
            System.out.println("Failed to write to file. " + filename);
        }
    }

    /**
     * Gets the user's age.
     * @return The age of the user.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the user's age.
     * @param age The age of the user.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the current streak of the user.
     * @return The current streak.
     */
    public int getCurrentStreak() {
        return currentStreak;
    }

    /**
     * Sets the current streak of the user.
     * @param currentStreak The current streak.
     */
    public void setCurrentStreak(int currentStreak) {
        this.currentStreak = currentStreak;
    }

    /**
     * Gets the total number of tasks completed by the user.
     * @return The total number of tasks completed.
     */
    public int getTasksCompleted() {
        return tasksCompleted;
    }

    /**
     * Sets the total number of tasks completed by the user.
     * @param tasksCompleted The total number of tasks completed.
     */
    public void setTasksCompleted(int tasksCompleted) {
        this.tasksCompleted = tasksCompleted;
    }

    /**
     * Gets the user's longest daily streak.
     * @return The longest daily streak.
     */
    public int getLongestDailyStreak() {
        return longestDailyStreak;
    }

    /**
     * Sets the user's longest daily streak.
     * @param longestDailyStreak The longest daily streak.
     */
    public void setLongestDailyStreak(int longestDailyStreak) {
        this.longestDailyStreak = longestDailyStreak;
    }

    /**
     * Gets the user's most tasks completed in a single day.
     * @return The most tasks completed in a day.
     */
    public int getMostTasksCompleted() {
        return mostTasksCompleted;
    }

    /**
     * Sets the user's most tasks completed in a single day.
     * @param mostTasksCompleted The most tasks completed in a day.
     */
    public void setMostTasksCompleted(int mostTasksCompleted) {
        this.mostTasksCompleted = mostTasksCompleted;
    }

    /**
     * Gets the total experience points of the user.
     * @return The total experience points.
     */
    public int getTotalXP() {
        return totalXP;
    }

    /**
     * Sets the total experience points of the user.
     * @param totalXP The total experience points.
     */
    public void setTotalXP(int totalXP) {
        this.totalXP = totalXP;
    }
}