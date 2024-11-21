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

public class TaskTracker {

    private final ArrayList<Task> tasks;
    private final Activity activity;
    private final String filename;
    private final Stats stats;
    private Mascot mascot;

    public TaskTracker(Activity activity, Stats stat) {
        this.stats = stat;
        tasks = new ArrayList<>();
        this.activity = activity;
        filename = "tasks4.csv";
        this.mascot = new Mascot("", "");
    }

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

    public void addTasks(Task task){
        tasks.add(task);
    }

    public void deleteTask(Task task){
        stats.setTotalXP(stats.getTotalXP() + task.getXp());
        stats.setTasksCompleted(stats.getTasksCompleted()+1);
        tasks.remove(task);
        stats.saveStats();
        saveTasks();
    }

    public ArrayList<Task> getTasks(){
        return tasks;
    }

    public Mascot getMascot(){
        return mascot;
    }

//tallies up the total xp, called from pointsActivity
    public int getTotalXp() {
        int totalXp = 0;
        for (Task task : tasks) {
            totalXp += task.getXp();
        }
        return totalXp;
    }
}
