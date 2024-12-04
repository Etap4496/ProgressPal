package edu.utsa.cs3443.progresspal.model;

import android.app.Activity;

/**
 * The mascot class represents the mascot object
 * @author Eli Tapia uxb422
 * @author Mathew Robillard gll855
 * @author Marc Jabian ibs065
 * @author Leslie Henley lbu591
 */
public class Mascot {

    private String name;
    private String DOB;
    private final String mascotFile;
    private Activity activity;

    /**
     * The constructor for the mascot object
     * @param name, the name of the mascot (String)
     * @param DOB, the Date of Birth of the mascot (String)
     */
    public Mascot(String name, String DOB) {
        this.name = name;
        this.DOB = DOB;
        this.activity = activity;
        this.mascotFile = "mascot.csv";
    }

    /**
     * gets the file the mascot is in
     * @return String, the name of the file the mascot is in
     */
    public String getFileName(){
        return mascotFile;
    }

    /**
     * gets the name of the mascot
     * @return String, the name of the mascot
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the mascot
     * @param name, the name of the mascot (String)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets the DOB of the mascot
     * @return String, the date the mascot was created
     */
    public String getDOB() {
        return DOB;
    }

    /**
     * sets the DOB of the mascot
     * @param DOB, the date the mascot was created (String)
     */
    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

}
