package edu.utsa.cs3443.progresspal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.progresspal.model.MediaPlayerManager;

public class creditsActivity extends AppCompatActivity {

    private Switch musicSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        MediaPlayerManager.start(this);

        // Navigation buttons
        ImageButton profileButton = findViewById(R.id.profile_button);
        ImageButton pointButton = findViewById(R.id.points_button);
        ImageButton homeButton = findViewById(R.id.home_button);

        Button mathewGithub = findViewById(R.id.mathew_github);
        Button marcGithub = findViewById(R.id.marc_github);
        Button eliGithub = findViewById(R.id.eli_github);
        Button leslieGithub = findViewById(R.id.leslie_github);

        // Music Switch
        musicSwitch = findViewById(R.id.music_switch);
        Switch sfxSwitch = findViewById(R.id.sfx_switch);

        SharedPreferences preferences = getSharedPreferences("AppSettings", MODE_PRIVATE);
        boolean isMusicEnabled = preferences.getBoolean("music_enabled", true);
        boolean isSfxEnabled = preferences.getBoolean("sfx_enabled", true);
        musicSwitch.setChecked(isMusicEnabled); // Set initial state of the switch
        sfxSwitch.setChecked(isSfxEnabled);

        musicSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("music_enabled", isChecked);
            editor.apply();

            if (isChecked) {
                MediaPlayerManager.start(this); // Start music if enabled
            } else {
                MediaPlayerManager.pause(); // Pause music if disabled
            }
        });
        sfxSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("sfx_enabled", isChecked);
            editor.apply();
        });

        // GitHub button listeners
        mathewGithub.setOnClickListener(view -> {
            Intent viewIntent = new Intent("android.intent.action.VIEW",
                    Uri.parse("https://github.com/mattyb8591"));
            startActivity(viewIntent);
        });

        marcGithub.setOnClickListener(view -> {
            Intent viewIntent = new Intent("android.intent.action.VIEW",
                    Uri.parse("https://github.com/marcdjbn"));
            startActivity(viewIntent);
        });

        eliGithub.setOnClickListener(view -> {
            Intent viewIntent = new Intent("android.intent.action.VIEW",
                    Uri.parse("https://github.com/Etap4496"));
            startActivity(viewIntent);
        });

        leslieGithub.setOnClickListener(view -> {
            Intent viewIntent = new Intent("android.intent.action.VIEW",
                    Uri.parse("https://github.com/LeslieH0"));
            startActivity(viewIntent);
        });

        // Navigation listeners
        homeButton.setOnClickListener(view -> launchHome());
        pointButton.setOnClickListener(view -> launchPoint());
        profileButton.setOnClickListener(view -> launchProfile());
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Pause the music when the activity is not visible
        MediaPlayerManager.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Resume the music if enabled
        MediaPlayerManager.start(this);
    }

    private void launchPoint() {
        Intent intentPoint = new Intent(this, pointsActivity.class);
        startActivity(intentPoint);
    }

    private void launchProfile() {
        Intent intentProfile = new Intent(this, profileActivity.class);
        startActivity(intentProfile);
    }

    private void launchHome() {
        Intent intentHome = new Intent(this, homeActivity.class);
        startActivity(intentHome);
    }
}
