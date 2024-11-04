package edu.utsa.cs3443.progresspal.model;

import android.app.Activity;

import java.util.ArrayList;

public class QuoteHandler {

    ArrayList<Quote> quotes;

    public QuoteHandler() {
        quotes = new ArrayList<Quote>();
    }

    private void loadQuotes(Activity activity){

    }

    private String getRandomQuote(){
        return null;
    }

    private ArrayList<Quote> getQuotes(){
        return quotes;
    }

    private Quote getQuote(int index){
        return quotes.get(index);
    }

}
