package edu.utsa.cs3443.progresspal.model;

import android.app.Activity;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class QuoteHandler {

    ArrayList<Quote> quotes;

    public QuoteHandler() {
        quotes = new ArrayList<Quote>();
    }

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

    public void addQuote(Quote quote){
        quotes.add(quote);
    }

    public String getRandomQuote(){
        return null;
    }

    public ArrayList<Quote> getQuotes(){
        return quotes;
    }

    public Quote getQuote(int index){
        return quotes.get(index);
    }

}
