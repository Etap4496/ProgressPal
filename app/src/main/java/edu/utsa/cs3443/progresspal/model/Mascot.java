package edu.utsa.cs3443.progresspal.model;

import android.app.Activity;

public class Mascot {

    private String name;
    private String DOB;
    private Inventory inventory;
    private final String mascotFile;
    private Activity activity;

    public Mascot(String name, String DOB) {
        this.name = name;
        this.DOB = DOB;
        inventory = new Inventory();
        this.activity = activity;
        this.mascotFile = "mascot.csv";
    }

    public String getFileName(){
        return mascotFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
