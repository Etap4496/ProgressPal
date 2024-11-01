package edu.utsa.cs3443.progresspal.model;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Hat> hats;
    private ArrayList<Staff> staffs;
    private ArrayList<Color> colors;

    public Inventory(ArrayList<Hat> hats, ArrayList<Staff> staffs, ArrayList<Color> colors) {
        this.hats = hats;
        this.staffs = staffs;
        this.colors = colors;
    }

    public ArrayList<Hat> getHats() {
        return hats;
    }

    public void setHats(ArrayList<Hat> hats) {
        this.hats = hats;
    }

    public ArrayList<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(ArrayList<Staff> staffs) {
        this.staffs = staffs;
    }

    public ArrayList<Color> getColors() {
        return colors;
    }

    public void setColors(ArrayList<Color> colors) {
        this.colors = colors;
    }
}
