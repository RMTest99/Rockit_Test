package com.rajabmammadli.rockit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.TagLostException;
import android.os.Bundle;
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

public class LoginActivity extends AppCompatActivity {

    ImageButton backBtn, facebookBtn, googleBtn, twitterBtn;
    EditText editTextEmail, editTextPassword;
    Button loginBtn;
    TextView signUpBtn;
    TextView forgotBtn;

    //Firebase
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Image Buttons
        backBtn = findViewById(R.id.backBtn);
        facebookBtn = findViewById(R.id.facebookBtn);
        googleBtn = findViewById(R.id.googleBtn);
        twitterBtn = findViewById(R.id.twitterBtn);

        //Firebase
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        //Edit Texts
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        //Buttons
        loginBtn = findViewById(R.id.loginBtn);
        signUpBtn = findViewById(R.id.signUpBtn);
        forgotBtn = findViewById(R.id.forgotBtn);

        //Login Button Listener
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logUser();
            }
        });

        //Sign Up Button Listener
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go to Sign Up Page
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //Forgot Button Listener
        forgotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ResetActivity.class);
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

    private void logUser() {

        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Intent intent = new Intent(LoginActivity.this, FeedActivity.class);
                startActivity(intent);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}