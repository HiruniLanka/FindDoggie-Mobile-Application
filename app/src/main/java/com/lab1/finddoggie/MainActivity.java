package com.lab1.finddoggie;

import static com.lab1.finddoggie.R.layout.activity_main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        Intent welcome = new Intent(this, WelcomeActivity.class);
        startActivity(welcome);
    }
}