package com.lab1.finddoggie;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

// Define the class and implement SensorEventListener
public class HomeActivity extends AppCompatActivity implements SensorEventListener {

    //sensor related variables
    SensorManager sensorManager;
    Sensor sensor;
    public boolean isRunning = false;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        CardView cardView5 = findViewById(R.id.adopted);
        cardView5.setOnClickListener(v -> {
            // Start GalleryActivity
            Intent intent2 = new Intent(HomeActivity.this, AdoptedActivity.class);
            startActivity(intent2);
        });

        CardView cardView = findViewById(R.id.nearby);
        cardView.setOnClickListener(v -> {
            // Start Nearby Activity
            Intent intent = new Intent(HomeActivity.this, NearbyActivity.class);
            startActivity(intent);
        });

        CardView cardView2 = findViewById(R.id.gallery);
        cardView2.setOnClickListener(v -> {
            // Start GalleryActivity
            Intent intent2 = new Intent(HomeActivity.this, GalleryActivity.class);
            startActivity(intent2);
        });

        CardView cardView1 = findViewById(R.id.postPet);
        cardView1.setOnClickListener(v -> {
            // Start PostPetActivity
            Intent intent1 = new Intent(HomeActivity.this, PostPetActivity.class);
            startActivity(intent1);
        });
        CardView cardView3 = findViewById(R.id.video);
        cardView3.setOnClickListener(v -> {
            // Start Video Activity
            Intent intent3 = new Intent(HomeActivity.this, VideoActivity.class);
            startActivity(intent3);
        });

        CardView cardView4 = findViewById(R.id.organizations);
        cardView4.setOnClickListener(v -> {
            // Start Video Activity
            Intent intent4 = new Intent(HomeActivity.this, OrganizationActivity.class);
            startActivity(intent4);
        });

        //sensor related variables
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        // Check if the device has a light sensor and display an appropriate message
        PackageManager packageManager = getPackageManager();
        boolean hasLightSensor = packageManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_LIGHT);
        if(hasLightSensor) {
            // Light sensor is available on the device
            Toast.makeText(this, "Light sensor available", Toast.LENGTH_SHORT).show();
        } else {
            // Light sensor is not available on the device
            Toast.makeText(this, "Light sensor not available", Toast.LENGTH_SHORT).show();
        }
        // Initialize the bottom navigation view
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
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
    // Implement the onSensorChanged method to receive updates from the light sensor
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            float lightvalue = event.values[0];

            // If the ambient light is too bright and the alert dialog is not already displayed, show the dialog
            if (event.values[0] > 100 && !isRunning) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                alertDialog.setTitle("Alert");
                alertDialog.setMessage(lightvalue + "\n" + "Increase your Display Brightness !");
                isRunning = true;
                //When click "Yes" it will execute this
                alertDialog.setPositiveButton("Ok", (dialog, which) -> dialog.dismiss());
                alertDialog.show();
            } else if (event.values[0] <= 100) {
                isRunning = false;
            }
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}