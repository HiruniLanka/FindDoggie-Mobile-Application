package com.lab1.finddoggie;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class OrganizationActivity extends AppCompatActivity {
    private ImageButton backButton;
    private TextView organization1WebsiteTextView, organization2WebsiteTextView, organization3WebsiteTextView, organization4WebsiteTextView, organization5WebsiteTextView;

    // Declare more TextView variables for additional organizations

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization);

        // Set up the back button and its onClickListener
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

        // Initialize TextView variables for each organization's website
        organization1WebsiteTextView = findViewById(R.id.organization1WebsiteTextView);
        organization2WebsiteTextView = findViewById(R.id.organization2WebsiteTextView);
        organization3WebsiteTextView = findViewById(R.id.organization3WebsiteTextView);
        organization4WebsiteTextView = findViewById(R.id.organization4WebsiteTextView);
        organization5WebsiteTextView = findViewById(R.id.organization5WebsiteTextView);

        // Set onClickListener for organization1's website TextView
        organization1WebsiteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebsite("https://www.embarkpassion.com/");
            }
        });

        // Set onClickListener for organization2's website TextView
        organization2WebsiteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebsite("http://www.animalsos-sl.com/");
            }
        });

        // Set onClickListener for organization3's website TextView
        organization3WebsiteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebsite("http://www.bluepawtrust.org/");
            }
        });

        // Set onClickListener for organization4's website TextView
        organization4WebsiteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebsite("https://www.dogstarfoundation.com/");
            }
        });

        // Set onClickListener for organization5's website TextView
        organization5WebsiteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebsite("https://www.otarafoundation.com/");
            }
        });
    }

    // Method to open a website URL in the browser
    private void openWebsite(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
