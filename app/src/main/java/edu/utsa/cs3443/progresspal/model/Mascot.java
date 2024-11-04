package edu.utsa.cs3443.progresspal.model;

public class Mascot {
    private String name;
    private String DOB;
    private Inventory inventory;

    public Mascot(String name, String DOB) {
        this.name = name;
        this.DOB = DOB;
        inventory = new Inventory();
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
