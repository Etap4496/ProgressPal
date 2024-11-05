package edu.utsa.cs3443.progresspal.model;

import android.app.Activity;
import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    private ArrayList<Hat> hats;
    private ArrayList<Staff> staffs;
    private ArrayList<Color> colors;
    private int totalxp;

    public Inventory() {
        hats = new ArrayList<>();
        staffs = new ArrayList<>();
        colors = new ArrayList<>();
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

    public ArrayList<Color> getColors() {
        return colors;
    }

    public void setColors(ArrayList<Color> colors) {
        this.colors = colors;
    }


    public void loadColorsFromCSV(Activity activity) {
        AssetManager manager = activity.getAssets();
        String colorFile = "colorsID.csv";

        try (InputStream is = manager.open(colorFile); Scanner scanner = new Scanner(is)) {
            // Skip header line
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(",");


                if (tokens.length >= 3) {
                    try {
                        int ID = Integer.parseInt(tokens[0].trim());
                        String name = tokens[1].trim();
                        String hexCode = tokens[2].trim();
                        Color color = new Color(ID, name, hexCode, false);
                        addColor(color);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid ID format in line: " + line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getTotalxp() {
        return totalxp;
    }

    public void addColor(Color color) {
        colors.add(color);
    }
}