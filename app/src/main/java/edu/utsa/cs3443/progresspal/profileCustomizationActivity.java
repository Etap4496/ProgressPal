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

public class profileCustomizationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_customization);

        Button backButton = findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchBack();
            }
        });
    }

    private void launchBack(){
        Intent intentBack = new Intent(this, profileActivity.class);
        startActivity(intentBack);
    }
}