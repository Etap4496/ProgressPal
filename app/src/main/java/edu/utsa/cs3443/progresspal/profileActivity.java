package edu.utsa.cs3443.progresspal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class profileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button profileButton = findViewById(R.id.profile_button);
        Button pointButton = findViewById(R.id.points_button);
        Button creditButton = findViewById(R.id.credits_button);
        Button homeButton = findViewById(R.id.home_button);
        Button customizeButton = findViewById(R.id.customize_button);
        ImageView mascotView = findViewById((R.id.mascot));

        if (profileCustomizationActivity.ImageResID != -1) {
            mascotView.setImageResource(profileCustomizationActivity.ImageResID);
        }

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