package com.rajabmammadli.rockit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.rajabmammadli.rockit.Models.User;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SignUpActivity extends AppCompatActivity {

    String EMPTY = "Empty";

    ImageButton backBtn, facebookBtn, googleBtn, twitterBtn;
    EditText editTextUsername, editTextEmail, editTextPassword;
    Button signUpBtn;
    TextView loginBtn, forgotBtn;

    //Firebase
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Not Assigned variable for empty database
        String NOT_ASSIGNED = "Not Assigned";

        //Image Buttons
        backBtn = findViewById(R.id.backBtn);
        facebookBtn = findViewById(R.id.facebookBtn);
        googleBtn = findViewById(R.id.googleBtn);
        twitterBtn = findViewById(R.id.twitterBtn);

        //Edit Texts
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        //Buttons
        signUpBtn = findViewById(R.id.signUpBtn);
        loginBtn = findViewById(R.id.loginBtn);
        forgotBtn = findViewById(R.id.forgotBtn);

        //Firebase
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        //Sign Up Button Listener
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        //Login Button Listener
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go to Login Page
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //Forgot Button Listener
        forgotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, ResetActivity.class);
                startActivity(intent);
            }
        });

        //Back Button Listener
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Return to Previous Page Upon Click
                finish();
            }
        });
    }

    // Method to add user to Firebase Database
    private void addUser(String userId, String userEmail, String userFirstName, String userLastName, String userAge, String userCity, String userState, String userZip,
                         boolean userEmailVerified, String userRegistrationDate, String userVerificationCode, String userPhone, String userCountry, String userAddress, String userName, String userImageUrl) {

        User user = new User(userId, userEmail, userFirstName, userLastName, userAge, userCity, userState, userZip, userEmailVerified, userRegistrationDate, userVerificationCode, userPhone, userCountry, userAddress, userName, userImageUrl);

        databaseReference.child("Users").child(userId).setValue(user);

    }

    // Method to register user
    private void registerUser() {
        //Get current date and time
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy h:mm a", Locale.ENGLISH);
        String formattedDate = dateFormat.format(cal.getTime());

        //Assign suitable data
        final String userId = databaseReference.push().getKey();
        final String userEmail = editTextEmail.getText().toString();
        final String userFirstName = EMPTY;
        final String userLastName = EMPTY;
        final String userAge = EMPTY;
        final String userCity = EMPTY;
        final String userState = EMPTY;
        final String userZip = EMPTY;
        final boolean userEmailVerified = false;
        final String userRegistrationDate = formattedDate;
        final String userVerificationCode = EMPTY;
        final String userPhone = EMPTY;
        final String userCountry = EMPTY;
        final String userAddress = EMPTY;
        final String userImageUrl = EMPTY;
        final String userName = editTextUsername.getText().toString();
        final String userPassword = editTextPassword.getText().toString();

        firebaseAuth.createUserWithEmailAndPassword(userEmail, userPassword).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Intent intent = new Intent(SignUpActivity.this, FeedActivity.class);
                startActivity(intent);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignUpActivity.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });

        addUser(userId, userEmail, userFirstName, userLastName, userAge, userCity, userState, userZip, userEmailVerified, userRegistrationDate, userVerificationCode, userPhone, userCountry, userAddress, userName, userImageUrl);
    }

}