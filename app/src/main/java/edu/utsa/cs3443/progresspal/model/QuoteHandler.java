package edu.utsa.cs3443.progresspal.model;

import android.app.Activity;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 *The QuoteHandler class keeps control of the quote objects
 * @author Eli Tapia uxb422
 * @author Mathew Robillard gll855
 * @author Marc Jabian ibs065
 * @author Leslie Henley lbu591
 */
public class QuoteHandler {

    ArrayList<Quote> quotes;

    /**
     * The constructor for the QuoteHandler class
     */
    public QuoteHandler() {
        quotes = new ArrayList<Quote>();
    }

    /**
     * loads the quotes from the csv
     * @param activity, the activity responsible for populating the quotes arraylist (Activity)
     */
    public void loadQuotes(Activity activity){
        AssetManager manager = activity.getAssets();
        Scanner scan = null;
        String filename = "mascot_quotes.txt";

        try{
            InputStream file = manager.open(filename);
            scan = new Scanner(file);
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                addQuote(new Quote(line));
                System.out.println("Quote added to the ArrayList");
            }
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * adds a quote to the arraylist
     * @param quote, a quote form the arraylist (Quote)
     */
    public void addQuote(Quote quote){
        quotes.add(quote);
    }

    /**
     * gets the quotes in the arraylist of quotes
     * @return Quote, the arraylist of quotes
     */
    public ArrayList<Quote> getQuotes(){
        return quotes;
    }

    /**
     * gets a quote from the arraylist
     * @param index, the index of quote from the arraylist (int)
     * @return Quote, a quote from the arraylist
     */
    public Quote getQuote(int index){
        return quotes.get(index);
    }

}
