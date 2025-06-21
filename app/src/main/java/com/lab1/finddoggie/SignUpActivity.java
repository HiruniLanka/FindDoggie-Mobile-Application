package com.lab1.finddoggie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
public class SignUpActivity extends AppCompatActivity {
    private ImageButton backButton;
    EditText username,password,confirmpassword,email,phone;
    Button signup;
    DbHelper DB;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

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

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        confirmpassword=findViewById(R.id.confirmpassword);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
        signup=findViewById(R.id.button);
        DB=new DbHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String conpass = confirmpassword.getText().toString();
                String mail = email.getText().toString();
                String pho=phone.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(user) || TextUtils.isEmpty(conpass) || TextUtils.isEmpty(mail) || TextUtils.isEmpty(pho)  )
                    Toast.makeText(SignUpActivity.this,"All field Required", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(conpass)){
                        Boolean checkuser = DB.checkUsername (user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user,pass,conpass,mail,pho);
                            if(insert==true){
                                Toast.makeText(SignUpActivity.this,"Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(i);
                            }else{
                                Toast.makeText(SignUpActivity.this,"Registered Failed",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(SignUpActivity.this,"User already Exists", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(SignUpActivity.this,"Passwords are not matching",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
