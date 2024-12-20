package edu.utsa.cs3443.progresspal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.progresspal.model.MediaPlayerManager;
import edu.utsa.cs3443.progresspal.model.Task;
import edu.utsa.cs3443.progresspal.model.TaskTracker;

/**
 * This class represents the new task page of the application
 * where you create a new task and add it to the array list of tasks
 *
 * @author Eli Tapia uxb422
 * @author Mathew Robillard gll855
 * @author Marc Jabian ibs065
 * @author Leslie Henley lbu591
 */
public class newTaskActivity extends AppCompatActivity {

    /**
     * Inflates the xml page associated, handles user clicks/Input,
     * and uses model class functions to save/update data
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        MediaPlayerManager.start(this);

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

                String timeString = time.getText().toString();

                // Validate that the time entered is a number between 1 and 12
                try {
                    int completionTime = Integer.parseInt(timeString);

                    if (completionTime > 24) {
                        Toast.makeText(newTaskActivity.this, "I know you're lying...", Toast.LENGTH_SHORT).show();
                    } else if (completionTime < 1 || completionTime > 12) {
                        // Show a toast if the time is out of the range 1-12
                        Toast.makeText(newTaskActivity.this, "Enter a number between 1-12", Toast.LENGTH_SHORT).show();
                    } else {
                        // Proceed with task creation if the time is valid
                        TaskTracker taskTracker = homeActivity.getTaskTracker();
                        taskTracker.addTasks(new Task(taskName.getText().toString(), dueDate.getText().toString(), completionTime));
                        taskTracker.saveTasks();
                        launchCreateTask();
                    }
                } catch (NumberFormatException e) {
                    // Handle case where the entered time is not a valid number
                    Toast.makeText(newTaskActivity.this, "Enter a valid number between 1-12", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * onPause the music pauses
     */
    @Override
    protected void onPause() {
        super.onPause();
        MediaPlayerManager.pause(); // Pause the music
    }

    /**
     * onResume the music resumes from where it left off
     */
    @Override
    protected void onResume() {
        super.onResume();
        MediaPlayerManager.start(this); // Resume music based on preferences
    }

    /**
     * Launches the user back to the home page without creating a new task
     */
    private void launchCancel() {
        Intent intentCancel = new Intent(this, homeActivity.class);
        startActivity(intentCancel);
    }

    /**
     * Launches the user back to the home page after creating a new task and saving the data
     */
    private void launchCreateTask() {
        Intent intentCreate = new Intent(this, homeActivity.class);
        startActivity(intentCreate);
    }
}
