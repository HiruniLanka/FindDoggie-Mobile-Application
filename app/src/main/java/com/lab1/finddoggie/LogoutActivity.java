package com.lab1.finddoggie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.VideoView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LogoutActivity extends AppCompatActivity {
    private ImageButton backButton;
    private VideoView videoView1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        backButton = findViewById(R.id.back_button);
        // Set up click listener for back button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Hide the default action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        videoView1 = findViewById(R.id.logout);

        // Set the video path
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.logout;// Replace with your video path

        // Load the video
        Uri videoUri = Uri.parse(videoPath);
        videoView1.setVideoURI(videoUri);

        // Start playing the video
        videoView1.start();

        Button logoutButton = findViewById(R.id.logoutButton);

        // Set click listener for the Log Out button
        logoutButton.setOnClickListener(v -> {
            // Perform log out action here

            // Start the login activity and clear the back stack
            Intent intent = new Intent(LogoutActivity.this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
//        bottomNavigationView.setSelectedItemId(R.id.bottom_menu);

        // Set the OnClickListener for the BottomNavigationView items
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_map:
                    startActivity(new Intent(getApplicationContext(), MapActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_menu:
                    startActivity(new Intent(getApplicationContext(),MenuActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
            }
            return false;
        });
    }
}

