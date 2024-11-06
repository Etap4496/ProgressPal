package edu.utsa.cs3443.progresspal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class profileCustomizationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public static int ImageResID = -1;
    public static int hatImageResID = -1;
    public static int staffImageResID = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_customization);

        Button backButton = findViewById(R.id.back_button);

        ImageButton blackHatButton = findViewById(R.id.black_hat);
        ImageButton greenHatButton = findViewById(R.id.green_hat);
        ImageButton redHatButton = findViewById(R.id.red_hat);
        ImageButton greenBlueHatButton = findViewById(R.id.green_blue_hat);
        ImageButton purpleHatButton = findViewById(R.id.purple_hat);
        ImageButton blueHatButton = findViewById(R.id.blue_hat);
        ImageButton greenStaffButton  = findViewById(R.id.green_staff);
        ImageButton redStaffButton = findViewById(R.id.red_staff);
        ImageButton purpleStaffButton = findViewById(R.id.purple_staff);

        Spinner spinnerColors = findViewById(R.id.mascot_colors);
        spinnerColors.setOnItemSelectedListener(this);
        String[] colors = getResources().getStringArray(R.array.mascot_colors);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, colors);
        adapter.setDropDownViewResource(androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item);
        spinnerColors.setAdapter(adapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchBack();
            }
        });
        greenHatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hatImageResID = R.drawable.green_hat;
            }
        });
        blackHatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hatImageResID = R.drawable.black_hat;
            }
        });
        redHatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hatImageResID = R.drawable.red_hat;
            }
        });
        greenBlueHatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hatImageResID = R.drawable.green_blue_hat;
            }
        });
        purpleHatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hatImageResID = R.drawable.purple_hat;
            }
        });
        blueHatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hatImageResID = R.drawable.blue_hat;
            }
        });
        greenStaffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                staffImageResID = R.drawable.green_staff;
            }
        });
        redStaffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                staffImageResID = R.drawable.red_staff;
            }
        });
        purpleStaffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                staffImageResID = R.drawable.purple_staff;
            }
        });
    }

    private void launchBack(){
        Intent intentBack = new Intent(this, profileActivity.class);
        startActivity(intentBack);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //implement method for color change of mascot
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
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}