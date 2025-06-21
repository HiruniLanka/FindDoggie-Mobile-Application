package com.lab1.finddoggie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class GalleryActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> onBackPressed());

        Button btn1 = findViewById(R.id.seeButton1);
        btn1.setOnClickListener(v -> {
            // Start Nearby Activity
            Intent intent1 = new Intent(GalleryActivity.this, Pet1ProfileActivity.class);
            startActivity(intent1);
        });
        Button btn2 = findViewById(R.id.seeButton2);
        btn2.setOnClickListener(v -> {
            // Start Nearby Activity
            Intent intent2 = new Intent(GalleryActivity.this, Pet2ProfileActivity.class);
            startActivity(intent2);
        });
        Button btn3 = findViewById(R.id.seeButton3);
        btn3.setOnClickListener(v -> {
            // Start Nearby Activity
            Intent intent3 = new Intent(GalleryActivity.this, Pet3ProfileActivity.class);
            startActivity(intent3);
        });
        Button btn4 = findViewById(R.id.seeButton4);
        btn4.setOnClickListener(v -> {
            // Start Nearby Activity
            Intent intent4 = new Intent(GalleryActivity.this, Pet4ProfileActivity.class);
            startActivity(intent4);
        });
    }
}