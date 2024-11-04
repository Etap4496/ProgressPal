package edu.utsa.cs3443.progresspal.model;

public class Hat {
    private int ID;
    private int xp;
    private boolean unlocked;
    private boolean equipped;
    private String filename;
    private String name;

    public Hat(int ID, String name, int xp, String filename, boolean unlocked, boolean equipped) {
        this.ID = ID;
        this.name = name;
        this.xp = xp;
        this.filename = filename.toLowerCase();
        this.unlocked = unlocked;
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

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    public boolean isEquipped() {
        return equipped;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }
}
