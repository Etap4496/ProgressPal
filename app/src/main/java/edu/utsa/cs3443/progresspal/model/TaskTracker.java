package edu.utsa.cs3443.progresspal.model;

import android.app.Activity;

import java.util.ArrayList;

public class TaskTracker {

    ArrayList<Task> tasks;

    public TaskTracker() {
        tasks = new ArrayList<Task>();
    }

    private void loadTasks(Activity activity){

    }

    private void addTasks(Task task){
        tasks.add(task);
    }

    private void createTask(){

    }

    private void deleteTask(){

    }


}
