package edu.utsa.cs3443.progresspal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class creditsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

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
                launchPoint();
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchProfile();
            }
        });

    }

    private void launchPoint(){
        Intent intentPoint = new Intent(this, pointsActivity.class);
        startActivity(intentPoint);
    }
    private void launchProfile(){
        Intent intentProfile = new Intent(this, profileActivity.class);
        startActivity(intentProfile);
    }
    private void launchHome(){
        Intent intentHome = new Intent(this, homeActivity.class);
        startActivity(intentHome);
    }
}