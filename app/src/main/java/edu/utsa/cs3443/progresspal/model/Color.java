package edu.utsa.cs3443.progresspal.model;

import android.content.Context;

import androidx.annotation.NonNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Color {
    private int ID;
    private boolean equipped;
    private String filename;
    private String name;

    public Color(int ID, String name, String filename, boolean equipped) {
        this.ID = ID;
        this.name = name;
        this.filename = filename.toLowerCase();
        this.equipped = equipped;
    }

    // Getter and Setter for ID
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    // Getter and Setter for equipped
    public boolean isEquipped() {
        return equipped;
    }
    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }

    // Getter and Setter for filename
    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename.toLowerCase();
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Color{" +
                "ID=" + ID +
                ", equipped=" + equipped +
                ", filename='" + filename + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}