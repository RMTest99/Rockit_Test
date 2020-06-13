package com.rajabmammadli.rockit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ResetActivity extends AppCompatActivity {

    FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;
    EditText emailText;
    ImageButton backBtn;
    Button resetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        backBtn = findViewById(R.id.backBtn);
        resetBtn = findViewById(R.id.resetBtn);

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetClicked();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void resetClicked() {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        emailText = findViewById(R.id.emailText);

        String userEmail = emailText.getText().toString();

        firebaseAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Intent intent = new Intent(ResetActivity.this, ResetSuccessActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(ResetActivity.this, ResetFailActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

}