package edu.utsa.cs3443.progresspal.model;

public class Color {
    private int ID;
    private boolean equipped;

    public Color(int ID, boolean equipped) {
        this.ID = ID;
        this.equipped = equipped;
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
