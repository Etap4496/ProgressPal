package edu.utsa.cs3443.progresspal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class pointsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);

        Button profileButton = findViewById(R.id.profile_button);
        Button pointButton = findViewById(R.id.points_button);
        Button creditButton = findViewById(R.id.credits_button);
        Button homeButton = findViewById(R.id.home_button);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchHome();
            }
        });

        pointButton.setOnClickListener(new View.OnClickListener() {
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

    private void launchProfile(){
        Intent intentProfile = new Intent(this, profileActivity.class);
        startActivity(intentProfile);
    }
    private void launchCredit(){
        Intent intentCredit = new Intent(this, creditsActivity.class);
        startActivity(intentCredit);
    }

    private void launchHome(){
        Intent intentHome = new Intent(this, homeActivity.class);
        startActivity(intentHome);
    }
}