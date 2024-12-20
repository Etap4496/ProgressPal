package edu.utsa.cs3443.progresspal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import edu.utsa.cs3443.progresspal.model.MediaPlayerManager;
import edu.utsa.cs3443.progresspal.model.Stats;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This class represents the points page for the application
 * displays the total xp, tasks completed,
 * xp needed for the next reward,
 * and displaying the current mascot
 *
 * @author Eli Tapia uxb422
 * @author Mathew Robillard gll855
 * @author Marc Jabian ibs065
 * @author Leslie Henley lbu591
 */
public class pointsActivity extends AppCompatActivity {

    /**
     * Inflates the xml associated with this class, updates data using model class functions,
     * and displays the current mascot
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);

        MediaPlayerManager.start(this);

        // Retrieve saved selections from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MascotPrefs", MODE_PRIVATE);
        int mascotImageResID = sharedPreferences.getInt("mascotColor", R.drawable.red_lizard); // Default to red lizard
        int hatImageResID = sharedPreferences.getInt("hat", -1); // Default to -1 if no hat is selected
        int staffImageResID = sharedPreferences.getInt("staff", -1); // Default to -1 if no staff is selected
        int noHat = sharedPreferences.getInt("noStaff", -2);
        int noStaff = sharedPreferences.getInt("noHat", -2);
        // Update UI elements
        ImageView mascotImageView = findViewById(R.id.imageView2);
        ImageView hatImageView = findViewById(R.id.imageView10);
        ImageView staffImageView = findViewById(R.id.imageView13);


        ImageButton profileButton = findViewById(R.id.profile_button);
        ImageButton creditButton = findViewById(R.id.credits_button);
        ImageButton homeButton = findViewById(R.id.home_button);
        ImageView mascotView = findViewById((R.id.imageView2));
        ImageView hatView = findViewById((R.id.imageView10));
        ImageView staffView = findViewById((R.id.imageView13));

        // Set the mascot image
        mascotImageView.setImageResource(mascotImageResID);

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
        Stats stats = homeActivity.getStats();
        stats.initializeStats();


        loadXP(stats);
        loadMostTasksCompleted(stats);
        loadxpNeeded(stats);


        if (profileCustomizationActivity.ImageResID != -1) {
            mascotView.setImageResource(profileCustomizationActivity.ImageResID);
        }
        if (profileCustomizationActivity.hatImageResID != -1) {
            hatView.setImageResource(profileCustomizationActivity.hatImageResID);
        }
        if (profileCustomizationActivity.staffImageResID != -1) {
            staffView.setImageResource(profileCustomizationActivity.staffImageResID);
        }

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchHome();
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchProfile();
            }
        });

        creditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchCredit();
            }
        });


    }

    /**
     * onPayse the music pauses
     */
    @Override
    protected void onPause() {
        super.onPause();
        MediaPlayerManager.pause();
    }

    /**
     * onResume the music plays from where it left off
     */
    @Override
    protected void onResume() {
        super.onResume();
        MediaPlayerManager.start(this);
    }

    /**
     * Displays the total xp the user has gained
     * @param stats Stats object
     */
    private void loadXP(Stats stats){
        TextView textXP = findViewById(R.id.pointsTotalXP);
        textXP.setText(String.valueOf(stats.getTotalXP()));
    }

    /**
     * Displays the life time tasks completed
     * @param stats Stats object
     */
    private void loadMostTasksCompleted(Stats stats) {
        TextView lifeTimeTasks = findViewById(R.id.lifetime_tasks);
        lifeTimeTasks.setText(String.valueOf(stats.getTasksCompleted()));
    }

    /**
     * Displays the xp needed for the new reward
     * @param stats Stats object
     */
    private void loadxpNeeded(Stats stats) {
        TextView textXPNeeded = findViewById(R.id.xpNeeded);
        textXPNeeded.setText(String.valueOf((stats.getTotalXP() - (stats.getTotalXP()%500))+500));
    }

    /**
     * Launches the user to the profile page through an intent
     */
    private void launchProfile(){
        Intent intentProfile = new Intent(this, profileActivity.class);
        startActivity(intentProfile);
    }
    /**
     * Launches the user to the credits page through an intent
     */
    private void launchCredit(){
        Intent intentCredit = new Intent(this, creditsActivity.class);
        startActivity(intentCredit);
    }
    /**
     * Launches the user to the home page through an intent
     */
    private void launchHome(){
        Intent intentHome = new Intent(this, homeActivity.class);
        startActivity(intentHome);
    }
}
