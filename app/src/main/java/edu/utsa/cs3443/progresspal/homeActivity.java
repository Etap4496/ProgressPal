package edu.utsa.cs3443.progresspal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

import edu.utsa.cs3443.progresspal.model.QuoteHandler;

public class homeActivity extends AppCompatActivity {

    private QuoteHandler quoteHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initQuotes();

        Button profileButton = findViewById(R.id.profile_button);
        Button pointButton = findViewById(R.id.points_button);
        Button creditButton = findViewById(R.id.credits_button);
        Button homeButton = findViewById(R.id.home_button);
        Button newTaskButton = findViewById(R.id.new_task);

        ImageButton mascotQuoteButton = findViewById(R.id.mascot_quote_button);
        TextView mascotQuoteText = findViewById(R.id.mascot_quote);

        //when mascotQuoteButton is clicked the quote textView will display the next quote in the ArrayList of Quotes
        mascotQuoteButton.setOnClickListener(new View.OnClickListener() {
            int i = 0;
            @Override
            public void onClick(View view) {
                if(i == quoteHandler.getQuotes().size()){
                    i = 0;
                }
                mascotQuoteText.setText(quoteHandler.getQuote(i).getText());
                i++;
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchProfile();
            }
        });

        pointButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchPoint();
            }
        });

        creditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchCredit();
            }
        });

        newTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNewTask();
            }
        });

    }

    private void initQuotes(){
        quoteHandler = new QuoteHandler();
        quoteHandler.loadQuotes(this);
    }

    private void newTaskDynamicSetup(){

    }

    private void launchProfile(){
        Intent intentProfile = new Intent(this, profileActivity.class);
        startActivity(intentProfile);
    }
    private void launchPoint(){
        Intent intentPoint = new Intent(this, pointsActivity.class);
        startActivity(intentPoint);
    }
    private void launchCredit(){
        Intent intentCredit = new Intent(this, creditsActivity.class);
        startActivity(intentCredit);
    }
    private void launchNewTask(){
        Intent intentTask = new Intent(this, newTaskActivity.class);
        startActivity(intentTask);
    }

}