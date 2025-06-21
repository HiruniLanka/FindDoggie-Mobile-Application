package com.lab1.finddoggie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;
public class WelcomeActivity extends AppCompatActivity {
    private long delay;

    @Override
    public  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        VideoView videoView = findViewById(R.id.video);
        videoView.setVideoPath(("android.resource://"+getPackageName()+"/"+R.raw.finddoggie));
        videoView.start();

        Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                login();
            }
        }, 5000);
    }
    public void login(){
        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
    }
    }
