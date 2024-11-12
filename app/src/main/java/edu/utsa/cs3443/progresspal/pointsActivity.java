package edu.utsa.cs3443.progresspal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import edu.utsa.cs3443.progresspal.model.TaskTracker;

import androidx.appcompat.app.AppCompatActivity;

public class pointsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);

        TaskTracker taskTracker = new TaskTracker(this);
        taskTracker.initializeTasks();

        TextView totalXpTextView = findViewById(R.id.pointsTotalXP);
        totalXpTextView.setText("Total XP: " + taskTracker.getTotalXp());

        loadXP();
        loadMostTasksCompleted();

        ImageButton profileButton = findViewById(R.id.profile_button);
        ImageButton creditButton = findViewById(R.id.credits_button);
        ImageButton homeButton = findViewById(R.id.home_button);

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

    private void loadXP(){
        TextView textXP = findViewById(R.id.pointsTotalXP);
        TaskTracker taskTracker = new TaskTracker(this);
        taskTracker.initializeTasks();
        textXP.setText(" " + taskTracker.getTotalXp() + " ");
    }

    private void loadMostTasksCompleted(){
        TextView lifeTimeTasks = findViewById(R.id.lifetime_tasks);
        TaskTracker taskTracker = new TaskTracker(this);
        taskTracker.initializeTasks();
        //lifeTimeTasks.setText("Tasks Completed: " + taskTracker.getTasksCompleted());
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
