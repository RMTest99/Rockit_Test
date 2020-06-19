package com.rajabmammadli.rockit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class CategoryDetailActivity extends AppCompatActivity {

    ImageButton backBtn;
    TextView mCategoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);

        backBtn = findViewById(R.id.backBtn);
        mCategoryName = findViewById(R.id.categoryName);

        Bundle bundle = getIntent().getExtras();
        String categoryName = bundle.getString("categoryName");

        mCategoryName.setText(categoryName);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}