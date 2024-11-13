package edu.utsa.cs3443.progresspal.model;

import android.app.Activity;
import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Stats {
    private int age;
    private int currentStreak;
    private int tasksCompleted;
    private int longestDailyStreak;
    private int mostTasksCompleted;
    private int totalXP;
    private final Activity activity;
    private final String filename;

    public Stats(Activity activity) {
        this.activity = activity;
        filename = "stats.csv";
    }

    public void initializeStats(){
        try{
            System.out.println("Attempting to read from file...");
            InputStream in = activity.openFileInput(filename);
            System.out.println("Success");
            loadStats(in);
        }
        catch(FileNotFoundException e){

            System.out.println("unable to read from file. File does not exist. " + filename);

            try{
                System.out.println("Attempting to create file ...");
                OutputStream out = activity.openFileOutput(filename, Context.MODE_PRIVATE);
            }
            catch(FileNotFoundException e2){
                System.out.println("Unable to create file. " + filename);
            }
        }
    }

    public void loadStats(InputStream in){
        if(in != null){
            Scanner scan = new Scanner(in);

            if(scan.hasNextLine()){
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

    public void saveStats() {

        try{
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
        }
        catch(IOException e){
            System.out.println("Failed to write to file. " + filename);
        }
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
