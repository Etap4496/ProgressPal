package edu.utsa.cs3443.progresspal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import edu.utsa.cs3443.progresspal.model.TaskTracker;

import androidx.appcompat.app.AppCompatActivity;

public class pointsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);

        TaskTracker taskTracker = homeActivity.getTaskTracker();

        loadXP(taskTracker);
        loadMostTasksCompleted(taskTracker);

        ImageButton profileButton = findViewById(R.id.profile_button);
        ImageButton creditButton = findViewById(R.id.credits_button);
        ImageButton homeButton = findViewById(R.id.home_button);
        ImageView mascotView = findViewById((R.id.imageView2));
        ImageView hatView = findViewById((R.id.imageView10));
        ImageView staffView = findViewById((R.id.imageView13));

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

    private void loadXP(TaskTracker taskTracker){
        TextView textXP = findViewById(R.id.pointsTotalXP);
        textXP.setText(String.valueOf(taskTracker.getTotalXp()));
    }

    private void loadMostTasksCompleted(TaskTracker taskTracker){
        TextView lifeTimeTasks = findViewById(R.id.lifetime_tasks);
        lifeTimeTasks.setText(String.valueOf(taskTracker.getTasks().size()));
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
