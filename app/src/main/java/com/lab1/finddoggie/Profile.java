package com.lab1.finddoggie;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

public class Profile extends AppCompatActivity {

    private EditText editPetName, editAge, editDescription, editContact;
    private RadioGroup radioGroupGender;
    private Button buttonSave;

//    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

//        editPetName = findViewById(R.id.editPetName);
//        radioGroupGender = findViewById(R.id.radioGroupGender);
//        editAge = findViewById(R.id.editAge);
//        editDescription = findViewById(R.id.editDescription);
//        editContact = findViewById(R.id.editContact);
//        buttonSave = findViewById(R.id.buttonSave);
//
//        // Initialize Firebase database reference
//        databaseReference = FirebaseDatabase.getInstance().getReference().child("Profiles");
//
//        buttonSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                saveProfile();
//            }
//        });
//    }
//
//    private void saveProfile() {
//        String petName = editPetName.getText().toString().trim();
//        String gender = ((RadioButton) findViewById(radioGroupGender.getCheckedRadioButtonId())).getText().toString();
//        int age = Integer.parseInt(editAge.getText().toString().trim());
//        String description = editDescription.getText().toString().trim();
//        String contact= editContact.getText().toString().trim();
//
//        // Create a unique key for the profile
//        String profileId = databaseReference.push().getKey();
//
//        // Create a Profile object
//        Profile profile = new Profile(profileId, petName, gender, age, description, contact);
//
//        // Save the profile to Firebase
//        databaseReference.child(profileId).setValue(profile)
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        Toast.makeText(Profile.this, "Profile saved successfully", Toast.LENGTH_SHORT).show();
//                        clearFields();
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(Profile.this, "Failed to save profile: " + e.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//
//    private void clearFields() {
//        editPetName.setText("");
//        radioGroupGender.clearCheck();
//        editAge.setText("");
//        editDescription.setText("");
//        editContact.setText("");
//    }
}}

