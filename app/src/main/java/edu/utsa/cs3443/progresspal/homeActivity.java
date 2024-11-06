package edu.utsa.cs3443.progresspal;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

import edu.utsa.cs3443.progresspal.model.QuoteHandler;
import edu.utsa.cs3443.progresspal.model.Task;
import edu.utsa.cs3443.progresspal.model.TaskTracker;

public class homeActivity extends AppCompatActivity {

    private QuoteHandler quoteHandler;
    private static TaskTracker taskTracker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //initializes the ArrayList of mascot quotes and loads them from the text file
        initQuotes();
        initTaskTracker();

        Button profileButton = findViewById(R.id.profile_button);
        Button pointButton = findViewById(R.id.points_button);
        Button creditButton = findViewById(R.id.credits_button);
        Button homeButton = findViewById(R.id.home_button);
        Button newTaskButton = findViewById(R.id.new_task);
        ImageView mascotView = findViewById((R.id.mascot_quote_button));

        if (profileCustomizationActivity.ImageResID != -1) {
            mascotView.setImageResource(profileCustomizationActivity.ImageResID);
        }

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

        newTaskDynamicSetup(taskTracker.getTasks());

    }

    public static TaskTracker getTaskTracker(){
        return taskTracker;
    }

    private void initQuotes(){
        quoteHandler = new QuoteHandler();
        quoteHandler.loadQuotes(this);
    }

    private void initTaskTracker(){
        taskTracker = new TaskTracker();
        taskTracker.loadTasks(this);
    }

    //not done yet- marc
    private void newTaskDynamicSetup(ArrayList<Task> tasks){
        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.tasks_root_LL);

        for(Task task : tasks){

            //Create a horizontal linear layout for each task
            LinearLayout horizontalLayout = new LinearLayout(this);
            horizontalLayout.setOrientation(LinearLayout.HORIZONTAL);
            horizontalLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
            horizontalLayout.setPadding(10, 50, 10, 50);
            horizontalLayout.setGravity(Gravity.LEFT);
            horizontalLayout.setBackgroundColor(Color.parseColor("#B3E5FC"));

            //Create a Button for the completion of a task
            Button completionButton = new Button(this);
            completionButton.setText("O");
            completionButton.setTextSize(12);
            completionButton.setTextColor(Color.BLACK);
            completionButton.setBackgroundColor(Color.WHITE);
            completionButton.setLayoutParams(new LinearLayout.LayoutParams(200, ViewGroup.LayoutParams.WRAP_CONTENT, 1));

            horizontalLayout.addView(completionButton);

            TextView taskName = new TextView(this);
            taskName.setText(task.getName());
            taskName.setTextSize(20);
            taskName.setTypeface(Typeface.DEFAULT_BOLD);
            taskName.setTextColor(Color.BLACK);
            taskName.setPadding(40,0,0,0);
            taskName.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));

            horizontalLayout.addView(taskName);

            ImageView timeIcon = new ImageView(this);
            
            rootLayout.addView(horizontalLayout);
        }
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