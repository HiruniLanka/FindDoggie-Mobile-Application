package com.lab1.finddoggie;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ForgotActivity extends AppCompatActivity {

    private ImageButton backButton;
    private EditText usernameEditText;
    private EditText newPasswordEditText;
    private Button resetPasswordButton;
    private DbHelper dbHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        // Initialize UI elements
        backButton = findViewById(R.id.back_button);
        usernameEditText = findViewById(R.id.username_edit_text);
        newPasswordEditText = findViewById(R.id.new_password_edit_text);
        resetPasswordButton = findViewById(R.id.reset_password_button);

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

        // Initialize database helper
        dbHelper = new DbHelper(this);

        // Set up click listener for reset password button
        resetPasswordButton.setOnClickListener(v -> {
            // Get the entered username and new password
            String username = usernameEditText.getText().toString().trim();
            String newPassword = newPasswordEditText.getText().toString().trim();

            // Check if username or new password is empty
            if (username.isEmpty() || newPassword.isEmpty()) {
                Toast.makeText(ForgotActivity.this, "Please enter a username and a new password.", Toast.LENGTH_SHORT).show();
            } else {
                // Update the password in the database
                boolean passwordUpdated = dbHelper.updatePassword(username, newPassword);
                if (passwordUpdated) {
                    Toast.makeText(ForgotActivity.this, "Password updated successfully.", Toast.LENGTH_SHORT).show();
                    finish();  // Finish the activity and go back to the previous screen
                } else {
                    Toast.makeText(ForgotActivity.this, "Failed to update the password. Please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
