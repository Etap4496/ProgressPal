package edu.utsa.cs3443.progresspal.model;

import android.app.Activity;
import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents the TaskTracker object which contains the ArrayList of
 * tasks, the mascot, the stats, and it also utilizes file I/O functions to read and
 * write sensitive data from csv files
 * @author Eli Tapia uxb422
 * @author Mathew Robillard gll855
 * @author Marc Jabian ibs065
 * @author Leslie Henley lbu591
 */
public class TaskTracker {

    private final ArrayList<Task> tasks;
    private final Activity activity;
    private final String filename;
    private final Stats stats;
    private Mascot mascot;

    /**
     * Constructor for the TaskTracker object
     * @param activity Activity class
     * @param stat Stats object
     */
    public TaskTracker(Activity activity, Stats stat) {
        this.stats = stat;
        tasks = new ArrayList<>();
        this.activity = activity;
        filename = "tasks4.csv";
        this.mascot = new Mascot("", "");
    }

    /**
     * Initializes the tasks using the loadTasks method
     */
    public void initializeTasks(){

        try{

            System.out.println("Attempting to read from file...");
            InputStream in = activity.openFileInput(filename);
            System.out.println("Success");
            loadTasks(in);
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

    /**
     * Initializes the name of the mascot using the loadName method
     * @return
     */
    public String initializeName() {
        try{
            System.out.println("Attempting to read from file...");
            InputStream in = activity.openFileInput(mascot.getFileName());
            System.out.println("Success");
            return loadName(in);
        }
        catch(FileNotFoundException e){

            System.out.println("unable to read from file. File does not exist. " + mascot.getFileName());

            try{
                System.out.println("Attempting to create file ...");
                OutputStream out = activity.openFileOutput(mascot.getFileName(), Context.MODE_PRIVATE);
            }
            catch(FileNotFoundException e2){
                System.out.println("Unable to create file. " + mascot.getFileName());
            }
        }
        return null;
    }

    /**
     *
     * @param in InputStream to read from
     */
    public void loadTasks(InputStream in){

        if(in != null){
            Scanner scan = new Scanner(in);
            String taskInfo = "";
            String[] tokens;

            while(scan.hasNextLine()){
                taskInfo = scan.nextLine();
                tokens  = taskInfo.split(",");
                int completionTime = Integer.parseInt(tokens[2]);
                addTasks(new Task(tokens[0], tokens[1], completionTime));
            }
        }
    }

    /**
     *
     * @param in InputStream to read from
     * @return returns the name of the mascot
     */
    public String loadName(InputStream in){

        if(in != null){
            Scanner scan = new Scanner(in);
            String mascotName;

            while(scan.hasNextLine()){
                mascotName = scan.nextLine();
                mascot.setName(mascotName);
            }
        }

        return mascot.getName();
    }

    /**
     * Updates the tasks to the csv file of tasks
     */
    public void saveTasks() {

        try{
            System.out.println("Attempting to save to a file");
            OutputStream out = activity.openFileOutput(filename, Context.MODE_PRIVATE);

            if(tasks != null) {
                for (Task task : tasks) {
                    out.write(task.getName().getBytes(StandardCharsets.UTF_8));
                    out.write(",".getBytes(StandardCharsets.UTF_8));
                    out.write(task.getDueDate().getBytes(StandardCharsets.UTF_8));
                    out.write(",".getBytes(StandardCharsets.UTF_8));
                    out.write(String.valueOf(task.getCompletionTime()).getBytes(StandardCharsets.UTF_8));
                    out.write("\n".getBytes(StandardCharsets.UTF_8));
                }
            }

            out.close();
        }
        catch(IOException e){
            System.out.println("Failed to write to file. " + filename);
        }
    }

    /**
     * Saves the name of the mascot to the csv file
     * @param name Name of mascot
     */
    public void saveName(String name) {

        try{
            System.out.println("Attempting to save to a file");
            OutputStream out = activity.openFileOutput(mascot.getFileName(), Context.MODE_PRIVATE);

            if(mascot != null) {
                    out.write(name.getBytes(StandardCharsets.UTF_8));
            }
            out.close();
            System.out.println("Name saved to csv file!");
        }
        catch(IOException e){
            System.out.println("Failed to write to file. " + mascot.getFileName());
        }
    }

    /**
     * Adds a task to the ArrayList of tasks
     * @param task Task object
     */
    public void addTasks(Task task){
        tasks.add(task);
    }

    /**
     * Deletes a task from the ArrayList and updates the csv file of tasks
     * @param task Task object
     */
    public void deleteTask(Task task){
        stats.setTotalXP(stats.getTotalXP() + task.getXp());
        stats.setTasksCompleted(stats.getTasksCompleted()+1);
        tasks.remove(task);
        stats.saveStats();
        saveTasks();
    }

    /**
     * Gets the Tasks
     * @return returns ArrayList of type Task
     */
    public ArrayList<Task> getTasks(){
        return tasks;
    }

    /**
     * Gets the mascot
     * @return gets the mascot
     */
    public Mascot getMascot(){
        return mascot;
    }

    /**
     * Gets the total xp from
     * @return returns the total xp
     */
    //tallies up the total xp, called from pointsActivity
    public int getTotalXp() {
        int totalXp = 0;
        for (Task task : tasks) {
            totalXp += task.getXp();
        }
        return totalXp;
    }
}
