package com.lab1.finddoggie;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Get the reference to the card view
        CardView cardView1 = findViewById(R.id.cardView8);

        // Set the OnClickListener for the card view
        cardView1.setOnClickListener(view -> {
            // Create an Intent to launch the new activity
            Intent intent1 = new Intent(MenuActivity.this, Profile.class);
            startActivity(intent1);
        });


        CardView cardView2 = findViewById(R.id.cardView7);
        cardView2.setOnClickListener(view -> {
            Intent intent2 = new Intent(MenuActivity.this, LogoutActivity.class);
            startActivity(intent2);
        });

        CardView cardView3 = findViewById(R.id.cardView6);
        cardView3.setOnClickListener(view -> {
            Intent intent3 = new Intent(MenuActivity.this, InviteFriend.class);
            startActivity(intent3);
        });

        CardView cardView4 = findViewById(R.id.cardView5);
        cardView4.setOnClickListener(view -> {
            Intent intent4 = new Intent(MenuActivity.this, AboutActivity.class);
            startActivity(intent4);
        });

        CardView cardView5= findViewById(R.id.cardView4);
        cardView5.setOnClickListener(view -> {
            Intent intent5 = new Intent(MenuActivity.this, AdoptedActivity.class);
            startActivity(intent5);
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_menu);

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
                    startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
            }
            return false;
        });
    }
}