package edu.utsa.cs3443.progresspal.model;

public class Staff {
    private int ID;
    private int xp;
    private boolean unlocked;
    private boolean equipped;

    public Staff(int ID, int xp, boolean unlocked, boolean equipped) {
        this.ID = ID;
        this.xp = xp;
        this.unlocked = unlocked;
        this.equipped = equipped;
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
