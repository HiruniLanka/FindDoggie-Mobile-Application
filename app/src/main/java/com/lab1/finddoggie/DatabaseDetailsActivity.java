package com.lab1.finddoggie;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DatabaseDetailsActivity extends AppCompatActivity {

    private TextView databaseDetailsTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_details);

        databaseDetailsTextView = findViewById(R.id.databaseDetailsTextView);

        // Get the database details from your database or any other source
        String databaseDetails = getDatabaseDetails();

        // Set the database details to the TextView
        databaseDetailsTextView.setText(databaseDetails);
    }

    private String getDatabaseDetails() {
        // Implement your logic to retrieve the database details here
        // You can fetch the details from a database, API, or any other source

        // For this example, we'll return a sample string
        return "Sample Database Details";
    }
}
