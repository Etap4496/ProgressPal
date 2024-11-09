package edu.utsa.cs3443.progresspal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import edu.utsa.cs3443.progresspal.model.Task;
import edu.utsa.cs3443.progresspal.model.TaskTracker;

public class newTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        Button cancelButton = findViewById(R.id.cancel_button);
        Button createButton = findViewById(R.id.create_button);
        EditText taskName = findViewById(R.id.enter_task_name);
        EditText dueDate = findViewById(R.id.enter_due_date);
        EditText time = findViewById(R.id.enter_time);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchCancel();
            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TaskTracker taskTracker = homeActivity.getTaskTracker();
                int completionTime = Integer.parseInt(String.valueOf(time.getText().toString()));
                taskTracker.addTasks(new Task(taskName.getText().toString(), dueDate.getText().toString(), completionTime));
                taskTracker.saveTasks();
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