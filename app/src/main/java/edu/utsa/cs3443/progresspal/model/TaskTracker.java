package edu.utsa.cs3443.progresspal.model;

import android.app.Activity;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskTracker {

    ArrayList<Task> tasks;

    public TaskTracker() {
        tasks = new ArrayList<Task>();
    }

    public void loadTasks(Activity activity){
        AssetManager manager = activity.getAssets();

        try{
            InputStream file = manager.open("tasks.csv");
            Scanner scan = new Scanner(file);

            scan.nextLine();
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                String[] tokens = line.split(",");
                String name = tokens[0];
                String dueDate = tokens[1];
                int time = Integer.parseInt(tokens[2]);
                boolean status = Boolean.parseBoolean(tokens[3]);
                int xp = time * 50;

                addTasks(new Task(name, dueDate, time, status, xp));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addTasks(Task task){
        tasks.add(task);
    }

    public void createTask(){

    }

    public void deleteTask(){

    }


}
