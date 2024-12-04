package edu.utsa.cs3443.progresspal.model;
/**
 *The Quote class handles the motivational quotes displayed upon clicking the mascot
 * @author Eli Tapia uxb422
 * @author Mathew Robillard gll855
 * @author Marc Jabian ibs065
 * @author Leslie Henley lbu591
 */
public class Quote {
    private String text;

    /**
     * the constuctor for the quote object
     * @param text, the motivational quote (String)
     */
    public Quote(String text) {
        this.text = text;
    }

    /**
     * gets the texts from the csv
     * @return String, the motivational quote
     */
    public String getText() {
        return text;
    }

    /**
     * sets the text for the quote
     * @param text, the motivational quote (String)
     */
    public void setText(String text) {
        this.text = text;
    }

}
