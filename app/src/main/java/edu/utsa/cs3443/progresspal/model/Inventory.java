package edu.utsa.cs3443.progresspal.model;

import android.app.Activity;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    ArrayList<Hat> hats;
    ArrayList<Staff> staffs;
    ArrayList<Color> colors;
    int totalxp;

    public Inventory() {
        hats = new ArrayList<Hat>();
        staffs = new ArrayList<Staff>();
        colors = new ArrayList<Color>();
        totalxp = 0;
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

    public ArrayList<Color> getColors(ArrayList<Color> colors) {

        return colors;
    }

    public void setColors(ArrayList<Color> colors) {
        this.colors = colors;
    }


    public void loadColorsFromCSV(Activity activity) {
        AssetManager manager = activity.getAssets();
        Scanner scan = null;
        String color = "colorsID.csv";

        try {
            InputStream is = manager.open(color);
            String line = null;
            scan = new Scanner(is);
            scan.nextLine();


            while (scan.hasNextLine()) {

                String Line = scan.nextLine();
                String[] tokens = line.split(",");
                int ID = Integer.parseInt(tokens[0]);

                addColor(new Color(ID, tokens[1], tokens[2], false));


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Color> getColors() {
        return colors;
    }


    public int getTotalxp() {
        return totalxp;
    }

    public void addColor(Color color) {
        colors.add(color);
    }

}

