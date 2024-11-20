package edu.utsa.cs3443.progresspal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.media.MediaPlayer;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import edu.utsa.cs3443.progresspal.model.QuoteHandler;
import edu.utsa.cs3443.progresspal.model.Stats;
import edu.utsa.cs3443.progresspal.model.Task;
import edu.utsa.cs3443.progresspal.model.TaskTracker;

public class homeActivity extends AppCompatActivity {

    private QuoteHandler quoteHandler;
    private static TaskTracker taskTracker;
    private static Stats stats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Retrieve saved selections from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MascotPrefs", MODE_PRIVATE);
        int mascotImageResID = sharedPreferences.getInt("mascotColor", R.drawable.red_lizard); // Default to red lizard
        int hatImageResID = sharedPreferences.getInt("hat", -1);
        int staffImageResID = sharedPreferences.getInt("staff", -1);
        int noHat= sharedPreferences.getInt("noHat", -2);
        int noStaff = sharedPreferences.getInt("noStaff", -2);
        // Update UI elements
        ImageView mascotImageView = findViewById(R.id.mascot_quote_button);
        ImageView hatImageView = findViewById(R.id.hat_image);
        ImageView staffImageView = findViewById(R.id.staff_image);

        // Set the mascot image
        mascotImageView.setImageResource(mascotImageResID);


        /*if (noHat != -2){
            hatImageView.setImageDrawable(null);
        }
        if (noStaff != -2){
            staffImageView.setImageDrawable(null);
        }*/
        // Set the hat image if a hat is selected
        if (hatImageResID != -1) {
            hatImageView.setImageResource(hatImageResID);
            hatImageView.setVisibility(View.VISIBLE); // Ensure visibility
        } else {
            hatImageView.setVisibility(View.GONE); // Hide if no hat is selected
        }

        // Set the staff image if a staff is selected
        if (staffImageResID != -1) {
            staffImageView.setImageResource(staffImageResID);
            staffImageView.setVisibility(View.VISIBLE); // Ensure visibility
        } else {
            staffImageView.setVisibility(View.GONE); // Hide if no staff is selected
        }
        //initializes the ArrayList of mascot quotes and loads them from the text file
        initQuotes();
        initTaskTracker();
        initStats();
        taskTracker.initializeTasks();
        stats.initializeStats();

        ImageButton profileButton = findViewById(R.id.profile_button);
        ImageButton pointButton = findViewById(R.id.points_button);
        ImageButton creditButton = findViewById(R.id.credits_button);
        ImageButton homeButton = findViewById(R.id.home_button);
        Button newTaskButton = findViewById(R.id.new_task);
        ImageView mascotView = findViewById((R.id.mascot_quote_button));
        ImageView hatView = findViewById((R.id.hat_image));
        ImageView staffView = findViewById((R.id.staff_image));

        if (profileCustomizationActivity.ImageResID != -1) {
            mascotView.setImageResource(profileCustomizationActivity.ImageResID);
        }
        if (profileCustomizationActivity.hatImageResID != -1) {
            hatView.setImageResource(profileCustomizationActivity.hatImageResID);
        }
        if (profileCustomizationActivity.staffImageResID != -1) {
            staffView.setImageResource(profileCustomizationActivity.staffImageResID);
        }
        /*if (profileCustomizationActivity.noHatImageResID != -2) {
            hatView.setImageResource(profileCustomizationActivity.noHatImageResID);
            hatView.setImageDrawable(null);
        }
        if (profileCustomizationActivity.noStaffImageResID != -2) {
            staffView.setImageResource(profileCustomizationActivity.noStaffImageResID);
            staffView.setImageDrawable(null);
        }*/

        ImageButton mascotQuoteButton = findViewById(R.id.mascot_quote_button);
        TextView mascotQuoteText = findViewById(R.id.mascot_quote);

        //when mascotQuoteButton is clicked the quote textView will display the next quote in the ArrayList of Quotes
        mascotQuoteButton.setOnClickListener(new View.OnClickListener() {
            int i = 0;
            MediaPlayer mediaPlayer = null;
            @Override
            public void onClick(View view) {
                if (mediaPlayer != null) {
                    mediaPlayer.release();
                }

                mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.squeak);
                mediaPlayer.setVolume(1.0f, 1.0f);
                mediaPlayer.start();

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

    public static Stats getStats() {
        return stats;
    }

    private void initQuotes(){
        quoteHandler = new QuoteHandler();
        quoteHandler.loadQuotes(this);
    }

    private void initTaskTracker(){
        taskTracker = new TaskTracker(this, stats);
    }

    private void initStats(){
        stats = new Stats(this);
    }

    private void newTaskDynamicSetup(ArrayList<Task> tasks){
        LinearLayout rootLayout = findViewById(R.id.tasks_root_LL);

        for(Task task : tasks){

            //Create a horizontal linear layout for each task
            LinearLayout horizontalLayout = new LinearLayout(this);
            horizontalLayout.setOrientation(LinearLayout.HORIZONTAL);
            horizontalLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
            horizontalLayout.setPadding(75, 50, 50, 75);
            horizontalLayout.setBackgroundColor(Color.parseColor("#B3E5FC"));

            //Create a check box for the completion of a task
            CheckBox completionBox = new CheckBox(this);
            completionBox.setWidth(100);
            completionBox.setHeight(100);
            completionBox.setPadding(0,0,0,0);
            completionBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        taskTracker.deleteTask(task);
                        rootLayout.removeView(horizontalLayout);
                    }
                    else{
                        horizontalLayout.setBackgroundColor(Color.parseColor("#B3E5FC"));
                    }
                }
            });

            horizontalLayout.addView(completionBox);

            LinearLayout taskAndDueDateLayout = new LinearLayout(this);
            taskAndDueDateLayout.setOrientation(LinearLayout.VERTICAL);
            taskAndDueDateLayout.setLayoutParams(new LinearLayout.LayoutParams(400, ViewGroup.LayoutParams.WRAP_CONTENT,1));

            horizontalLayout.addView(taskAndDueDateLayout);

            TextView taskName = new TextView(this);
            taskName.setText(task.getName());
            taskName.setTextSize(15);
            taskName.setTypeface(Typeface.DEFAULT_BOLD);
            taskName.setTextColor(Color.BLACK);
            taskName.setPadding(0,0,100,0);
            taskName.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,1));

            taskAndDueDateLayout.addView(taskName);

            TextView dueDate = new TextView(this);
            dueDate.setText(task.getDueDate());
            dueDate.setTextSize(12);
            dueDate.setTextColor(Color.BLACK);
            dueDate.setPadding(0,0,100,0);
            dueDate.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,1));

            taskAndDueDateLayout.addView(dueDate);

            //create a vertical linear layout to store the time icon on top and the estimated completion time on the bottom
            LinearLayout timeLayout = new LinearLayout(this);
            timeLayout.setOrientation(LinearLayout.VERTICAL);
            timeLayout.setLayoutParams(new LinearLayout.LayoutParams(300, ViewGroup.LayoutParams.WRAP_CONTENT,1));

            horizontalLayout.addView(timeLayout);

            ImageView timeIcon = new ImageView(this);
            int imageResource1 = getResources().getIdentifier("time_icon", "drawable", getPackageName());
            timeIcon.setImageResource(imageResource1);
            timeIcon.setLayoutParams(new LinearLayout.LayoutParams(100, 100));
            timeIcon.setPadding(0, 0, 0, 0);

            timeLayout.addView(timeIcon);

            TextView estimatedTimeText = new TextView(this);
            estimatedTimeText.setText(task.getCompletionTimeString());
            estimatedTimeText.setTextSize(12);
            estimatedTimeText.setGravity(Gravity.LEFT);

            timeLayout.addView(estimatedTimeText);

            LinearLayout xpLayout = new LinearLayout(this);
            xpLayout.setOrientation(LinearLayout.VERTICAL);
            xpLayout.setLayoutParams(new LinearLayout.LayoutParams(200, ViewGroup.LayoutParams.WRAP_CONTENT,1));

            horizontalLayout.addView(xpLayout);

            ImageView xpIcon = new ImageView(this);
            int imageResource2 = getResources().getIdentifier("energy_icon", "drawable", getPackageName());
            xpIcon.setImageResource(imageResource2);
            xpIcon.setForegroundGravity(Gravity.CENTER);
            xpIcon.setLayoutParams(new LinearLayout.LayoutParams(150, 150));
            xpIcon.setPadding(0, 0, 0, 0);

            xpLayout.addView(xpIcon);

            TextView xpText = new TextView(this);
            xpText.setText(String.valueOf(task.getXpString()));
            xpText.setTextSize(12);
            xpText.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD_ITALIC));
            xpText.setGravity(Gravity.START);

            xpLayout.addView(xpText);

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