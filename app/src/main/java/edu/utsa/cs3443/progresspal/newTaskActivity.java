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

import edu.utsa.cs3443.progresspal.model.TaskTracker;

public class newTaskActivity extends AppCompatActivity {

    private static TaskTracker taskTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        Button cancelButton = findViewById(R.id.cancel_button);
        Button createButton = findViewById(R.id.create_button);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchCancel();
            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchCreateTask();
            }
        });
    }


    private void launchCancel(){
        Intent intentCancel = new Intent(this, homeActivity.class);
        startActivity(intentCancel);
    }

    private void launchCreateTask(){
        Intent intentCreate = new Intent(this, homeActivity.class);
        startActivity(intentCreate);
    }
}