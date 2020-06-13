package com.rajabmammadli.rockit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResetSuccessActivity extends AppCompatActivity {

    TextView loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_success);

        loginBtn = findViewById(R.id.logInBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResetSuccessActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}