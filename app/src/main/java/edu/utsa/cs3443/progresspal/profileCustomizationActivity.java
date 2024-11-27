package edu.utsa.cs3443.progresspal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.progresspal.model.MediaPlayerManager;
import edu.utsa.cs3443.progresspal.model.Stats;
import edu.utsa.cs3443.progresspal.model.TaskTracker;

public class profileCustomizationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public static int ImageResID = -1;
    public static int hatImageResID = -1;
    public static int staffImageResID = -1;
    public static int noHatImageResID = -2;
    public static int noStaffImageResID = -2;

    private static TaskTracker taskTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_customization);

        MediaPlayerManager.start(this);

        // Load previous selections from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MascotPrefs", MODE_PRIVATE);
        ImageResID = sharedPreferences.getInt("mascotColor", R.drawable.red_lizard);
        hatImageResID = sharedPreferences.getInt("hat", -1);  // Default to -1 if not set
        staffImageResID = sharedPreferences.getInt("staff", -1);// Default to -1 if not set
        noHatImageResID = sharedPreferences.getInt("noHat", -2);
        noStaffImageResID = sharedPreferences.getInt("noStaff", -2);


        Stats stats = homeActivity.getStats();
        stats.initializeStats();

        Button backButton = findViewById(R.id.back_button);
        Button confirmButton = findViewById(R.id.confirm_button);

        ImageButton blackHatButton = findViewById(R.id.black_hat);
        ImageButton greenHatButton = findViewById(R.id.green_hat);
        ImageButton redHatButton = findViewById(R.id.red_hat);
        ImageButton greenBlueHatButton = findViewById(R.id.green_blue_hat);
        ImageButton purpleHatButton = findViewById(R.id.purple_hat);
        ImageButton blueHatButton = findViewById(R.id.blue_hat);
        ImageButton greenStaffButton = findViewById(R.id.green_staff);
        ImageButton redStaffButton = findViewById(R.id.red_staff);
        ImageButton purpleStaffButton = findViewById(R.id.purple_staff);
        ImageButton noHat = findViewById(R.id.no_hat);
        ImageButton noStaff = findViewById(R.id.no_staff);

        taskTracker = homeActivity.getTaskTracker();

        Spinner spinnerColors = findViewById(R.id.mascot_colors);
        spinnerColors.setOnItemSelectedListener(this);
        String[] colors = getResources().getStringArray(R.array.mascot_colors);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, colors);
        adapter.setDropDownViewResource(androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item);
        spinnerColors.setAdapter(adapter);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText changeName = (EditText)findViewById(R.id.change_name);
                String changeNameText = changeName.getText().toString();

                Toast.makeText(view.getContext(), "Mascot Name Changed" , Toast.LENGTH_LONG).show();
                System.out.println("Name changed to " + changeNameText);

                //write change to csv file
                taskTracker.saveName(changeNameText);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchBack();
            }
        });

       /* noHat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noHatImageResID = R.drawable.ic_launcher_background;
                saveSelection("noHat", noHatImageResID);
                Toast.makeText(view.getContext(), "No hat selected", Toast.LENGTH_SHORT).show();
            }
        });

        noStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noStaffImageResID = R.drawable.ic_launcher_background;
                saveSelection("noStaff", noStaffImageResID);
                Toast.makeText(view.getContext(), "No staff selected", Toast.LENGTH_SHORT).show();
            }
        }); */

        // Save each hat selection to SharedPreferences
        blackHatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stats.getTotalXP() > 500){
                    hatImageResID = R.drawable.black_hat;
                    saveSelection("hat", hatImageResID);
                    Toast.makeText(view.getContext(), "Item Selected", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(view.getContext(), "Insufficient amount of XP", Toast.LENGTH_SHORT).show();
                }
            }
        });
        blueHatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stats.getTotalXP() > 1000){
                    hatImageResID = R.drawable.blue_hat;
                    saveSelection("hat", hatImageResID);
                    Toast.makeText(view.getContext(), "Item Selected", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(view.getContext(), "Insufficient amount of XP", Toast.LENGTH_SHORT).show();
                }
            }
        });
        greenHatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stats.getTotalXP() > 2000){
                    hatImageResID = R.drawable.green_hat;
                    saveSelection("hat", hatImageResID);
                    Toast.makeText(view.getContext(), "Item Selected", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(view.getContext(), "Insufficient amount of XP", Toast.LENGTH_SHORT).show();
                }
            }
        });
        greenBlueHatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stats.getTotalXP() > 2500){
                    hatImageResID = R.drawable.green_blue_hat;
                    saveSelection("hat", hatImageResID);
                    Toast.makeText(view.getContext(), "Item Selected", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(view.getContext(), "Insufficient amount of XP", Toast.LENGTH_SHORT).show();
                }
            }
        });
        purpleHatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stats.getTotalXP() > 3500){
                    hatImageResID = R.drawable.purple_hat;
                    saveSelection("hat", hatImageResID);
                    Toast.makeText(view.getContext(), "Item Selected", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(view.getContext(), "Insufficient amount of XP", Toast.LENGTH_SHORT).show();
                }
            }
        });
        redHatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stats.getTotalXP() > 4000){
                    hatImageResID = R.drawable.red_hat;
                    saveSelection("hat", hatImageResID);
                    Toast.makeText(view.getContext(), "Item Selected", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(view.getContext(), "Insufficient amount of XP", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Save each staff selection to SharedPreferences
        greenStaffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stats.getTotalXP() > 1500){
                    staffImageResID = R.drawable.green_staff;
                    saveSelection("staff", staffImageResID);
                    Toast.makeText(view.getContext(), "Item Selected", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(view.getContext(), "Insufficient amount of XP", Toast.LENGTH_SHORT).show();
                }
            }
        });
        purpleStaffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stats.getTotalXP() > 3000){
                    staffImageResID = R.drawable.purple_staff;
                    saveSelection("staff", staffImageResID);
                    Toast.makeText(view.getContext(), "Item Selected", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(view.getContext(), "Insufficient amount of XP", Toast.LENGTH_SHORT).show();
                }
            }
        });
        redStaffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stats.getTotalXP() > 4500){
                    staffImageResID = R.drawable.red_staff;
                    saveSelection("staff", staffImageResID);
                    Toast.makeText(view.getContext(), "Item Selected", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(view.getContext(), "Insufficient amount of XP", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        MediaPlayerManager.pause(); // Pause the music
    }

    @Override
    protected void onResume() {
        super.onResume();
        MediaPlayerManager.start(this); // Resume music based on preferences
    }

    private void launchBack(){
        Intent intentBack = new Intent(this, profileActivity.class);
        startActivity(intentBack);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // Set and save mascot color based on selection
        switch (i) {
            case 0:
                ImageResID = R.drawable.red_lizard;
                break;
            case 1:
                ImageResID = R.drawable.green_lizard;
                break;
            case 2:
                ImageResID = R.drawable.blue_lizard;
                break;
            case 3:
                ImageResID = R.drawable.pink_lizard;
                break;
        }
        saveSelection("mascotColor", ImageResID);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    // Method to save selections to SharedPreferences
    private void saveSelection(String key, int resID) {
        SharedPreferences sharedPreferences = getSharedPreferences("MascotPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, resID);
        editor.apply();
    }
}
