package edu.utsa.cs3443.progresspal.model;

import java.util.Locale;

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

    private void setFilename(String filename){
        this.filename = filename;
    }

    private String getFilename(){
        return filename;
    }

    private void setName(){
        this.name = name;
    }

    private String getName(){
        return name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean isEquipped() {
        return equipped;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }
}
