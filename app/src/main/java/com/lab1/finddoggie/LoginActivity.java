package com.lab1.finddoggie;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    // Declare UI elements
    EditText user;
    EditText pass;
    Button loginButton;
    TextView textView, textView1;
    DbHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize UI elements
        user = findViewById(R.id.username1);
        pass = findViewById(R.id.password1);
        loginButton = findViewById(R.id.loginButton1);
        textView = findViewById(R.id.myTextView);
        textView1 = findViewById(R.id.forgot);

        // Initialize database helper
        DB = new DbHelper(this);

        // Set click listener for login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get username and password from input fields
                String username = user.getText().toString();
                String password = pass.getText().toString();

                // Check if any field is empty
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, "All fields Required", Toast.LENGTH_SHORT).show();
                } else {
                    // Check if username and password are correct
                    Boolean checkuserpass = DB.checkUsernamePassword(username, password);
                    if (checkuserpass == true) {
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        // Redirect to home activity
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Set click listener for sign up text view
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Redirect to sign up activity
                    Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                    startActivity(intent);
                }
            });
        }
        // Set click listener for forgot password text view
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to forgot password activity
                Intent intent1 = new Intent(LoginActivity.this, ForgotActivity.class);
                startActivity(intent1);
            }
        });
    }
}
