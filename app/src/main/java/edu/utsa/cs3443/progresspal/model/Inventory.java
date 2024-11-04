package edu.utsa.cs3443.progresspal.model;

import java.util.ArrayList;

public class Inventory {
    ArrayList<Hat> hats;
    ArrayList<Staff> staffs;
    ArrayList<Color> colors;

    public Inventory() {
        hats = new ArrayList<Hat>();
        staffs = new ArrayList<Staff>();
        colors = new ArrayList<Color>();
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
