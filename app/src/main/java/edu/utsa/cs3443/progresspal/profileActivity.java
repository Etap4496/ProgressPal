package edu.utsa.cs3443.progresspal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.progresspal.model.Mascot;
import edu.utsa.cs3443.progresspal.model.Stats;
import edu.utsa.cs3443.progresspal.model.TaskTracker;

public class profileActivity extends AppCompatActivity {

    private static TaskTracker taskTracker;

    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        MediaPlayerManager.start(this);

        // Retrieve saved selections from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MascotPrefs", MODE_PRIVATE);
        int mascotImageResID = sharedPreferences.getInt("mascotColor", R.drawable.red_lizard); // Default to red lizard
        int hatImageResID = sharedPreferences.getInt("hat", -1); // Default to -1 if no hat is selected
        int staffImageResID = sharedPreferences.getInt("staff", -1); // Default to -1 if no staff is selected
        int noHat= sharedPreferences.getInt("noHat", -2);
        int noStaff = sharedPreferences.getInt("noStaff", -2);
        // Update UI elements
        ImageView mascotImageView = findViewById(R.id.mascot);
        ImageView hatImageView = findViewById(R.id.hat);
        ImageView staffImageView = findViewById(R.id.staff);

        TextView mascotNameText = findViewById(R.id.mascotName);
        //String mascotNewName = getIntent().getStringExtra(profileCustomizationActivity.decodeMascotName());

        taskTracker = homeActivity.getTaskTracker();

        mascotNameText.setText(taskTracker.initializeName());

        // Set the mascot image
        mascotImageView.setImageResource(mascotImageResID);

        /*if (noHat != -2){
            hatImageView.setImageDrawable(null);
        }
        if (noStaff != -2){
            staffImageView.setImageDrawable(null);
        } */

        // Set the hat image if a hat is selected
        if (hatImageResID != -1) {
            hatImageView.setImageResource(hatImageResID);
            hatImageView.setVisibility(View.VISIBLE); // Ensure visibility
        }
        else {
            hatImageView.setVisibility(View.GONE); // Hide if no hat is selected
        }

        // Set the staff image if a staff is selected
        if (staffImageResID != -1) {
            staffImageView.setImageResource(staffImageResID);
            staffImageView.setVisibility(View.VISIBLE); // Ensure visibility
        } else {
            staffImageView.setVisibility(View.GONE); // Hide if no staff is selected
        }
        Stats stats = homeActivity.getStats();
        stats.initializeStats();

        loadMostTasksCompleted(stats);

        ImageButton profileButton = findViewById(R.id.profile_button);
        ImageButton pointButton = findViewById(R.id.points_button);
        ImageButton creditButton = findViewById(R.id.credits_button);
        ImageButton homeButton = findViewById(R.id.home_button);
        Button customizeButton = findViewById(R.id.customize_button);
        ImageView mascotView = findViewById((R.id.mascot));
        ImageView hatView = findViewById((R.id.hat));
        ImageView staffView = findViewById((R.id.staff));

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
        } */

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchHome();
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

        customizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchProfileCustomization();
            }
        });


    }

    @Override
    protected void onPause() {
        super.onPause();
        MediaPlayerManager.pause(); // Pause the music
    }

    @Override
    protected void onResume() {
        super.onResume();
        MediaPlayerManager.start(this); // Resume music based on preferences
    }

    private void loadMostTasksCompleted(Stats stats) {
        TextView lifeTimeTasks = findViewById(R.id.tasksaccomp);
        lifeTimeTasks.setText(String.valueOf(stats.getTasksCompleted()));
    }

    private void launchPoint(){
        Intent intentPoint = new Intent(this, pointsActivity.class);
        startActivity(intentPoint);
    }
    private void launchCredit(){
        Intent intentCredit = new Intent(this, creditsActivity.class);
        startActivity(intentCredit);
    }
    private void launchHome(){
        Intent intentHome = new Intent(this, homeActivity.class);
        startActivity(intentHome);
    }
    private void launchProfileCustomization(){
        Intent intentCustomize = new Intent(this, profileCustomizationActivity.class);
        startActivity(intentCustomize);
    }
}