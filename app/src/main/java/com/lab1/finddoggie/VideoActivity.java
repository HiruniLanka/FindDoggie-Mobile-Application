package com.lab1.finddoggie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener {

    // Declare variables for VideoView, MediaController, and ImageView
    VideoView videoIdea, videoIdea1, videoIdea2, videoIdea3, videoIdea4;
    MediaController mediaController;
    ImageView icon, icon1, icon2, icon3, icon4;
    private ImageButton backButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        // Initialize the backButton and set its click listener to handle the back navigation
        backButton = findViewById(R.id.back_button);
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

        // Initialize the ImageView variables and set their click listeners
        icon = findViewById(R.id.heart);
        icon1 = findViewById(R.id.heart1);
        icon2 = findViewById(R.id.heart2);
        icon3 = findViewById(R.id.heart3);
        icon4 = findViewById(R.id.heart4);

        icon.setOnClickListener(this);
        icon1.setOnClickListener(this);
        icon2.setOnClickListener(this);
        icon3.setOnClickListener(this);
        icon4.setOnClickListener(this);

        // Find the VideoView elements in the layout and set their video paths
        videoIdea = findViewById(R.id.vi_idea);
        videoIdea.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video1);

        videoIdea1 = findViewById(R.id.vi_idea2);
        videoIdea1.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video2);

        videoIdea2 = findViewById(R.id.vi_idea3);
        videoIdea2.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video3);

        videoIdea3 = findViewById(R.id.vi_idea4);
        videoIdea3.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video4);

        videoIdea4 = findViewById(R.id.vi_idea5);
        videoIdea4.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video5);

        // Create a new MediaController for each VideoView and set it as the anchor view
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoIdea);
        videoIdea.setMediaController(mediaController);

        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoIdea1);
        videoIdea1.setMediaController(mediaController);

        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoIdea2);
        videoIdea2.setMediaController(mediaController);

        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoIdea3);
        videoIdea3.setMediaController(mediaController);

        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoIdea4);
        videoIdea4.setMediaController(mediaController);


        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    return true;
                // Start the Map activity and finish the current activity
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
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.heart:
                changeHeartIcon(icon);
                break;
            case R.id.heart1:
                changeHeartIcon(icon1);
                break;
            case R.id.heart2:
                changeHeartIcon(icon2);
                break;
            case R.id.heart3:
                changeHeartIcon(icon3);
                break;
            case R.id.heart4:
                changeHeartIcon(icon4);
                break;
        }
    }

    public void changeHeartIcon(ImageView icon) {
        int i = (icon.getTag().toString().equals("black")) ? R.drawable.red_heart : R.drawable.baseline_favorite_24;
        String j = (icon.getTag().toString().equals("black")) ? "red" : "black";
        icon.setImageResource(i);
        icon.setTag(j);
    }
}