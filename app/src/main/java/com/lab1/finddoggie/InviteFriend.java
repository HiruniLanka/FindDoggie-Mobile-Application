package com.lab1.finddoggie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class InviteFriend extends AppCompatActivity {
    private ImageButton backButton;
    private EditText editTextEmail;
    private Button buttonSendInvitation;
    private ImageView imageViewFacebook;
    private ImageView imageViewWhatsApp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friend);

        // Initialize views
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonSendInvitation = findViewById(R.id.buttonSendInvitation);
        imageViewFacebook = findViewById(R.id.imageViewFacebook);
        imageViewWhatsApp = findViewById(R.id.imageViewWhatsApp);
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

        // Set click listener for send invitation button
        buttonSendInvitation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the email address entered by the user
                String emailAddress = editTextEmail.getText().toString();

                // Send invitation via email
                sendEmailInvitation(emailAddress);
            }
        });

        // Set click listener for Facebook image view
        imageViewFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Share invitation via Facebook
                shareOnFacebook();
            }
        });

        // Set click listener for WhatsApp image view
        imageViewWhatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Share invitation via WhatsApp
                shareOnWhatsApp();
            }
        });

        // Set up bottom navigation view
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            // Handle bottom navigation item selection
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    // Start HomeActivity
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_map:
                    // Start MapActivity
                    startActivity(new Intent(getApplicationContext(), MapActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_menu:
                    // Start MenuActivity
                    startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
            }
            return false;
        });
    }
    private void sendEmailInvitation(String emailAddress) {
        // Create an intent to send the email
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailAddress});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Join my app");
        intent.putExtra(Intent.EXTRA_TEXT, "Download my app and join me!");

        // Check if there is an app that can handle the email intent
        if (intent.resolveActivity(getPackageManager()) != null) {
            // Start the email activity
            startActivity(intent);
        }
    }
    private void shareOnFacebook() {
        // Open Facebook app or website
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.facebook.com"));
        startActivity(intent);
    }
    private void shareOnWhatsApp() {
        // Open WhatsApp with pre-filled text
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "Download my app and join me!");
        intent.setPackage("com.whatsapp");

        // Check if there is an app that can handle the WhatsApp intent
        if (intent.resolveActivity(getPackageManager()) != null) {
            // Start the WhatsApp activity
            startActivity(intent);
        }
    }
}

