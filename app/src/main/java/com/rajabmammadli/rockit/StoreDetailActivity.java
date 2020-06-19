package com.rajabmammadli.rockit;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoreDetailActivity extends AppCompatActivity {

    ImageButton backBtn;
    CircleImageView mStoreImage;
    TextView mStoreName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_detail);

        backBtn = findViewById(R.id.backBtn);
        mStoreImage = findViewById(R.id.storeImg);
        mStoreName = findViewById(R.id.storeName);

        Bundle bundle = getIntent().getExtras();
        String storeName = bundle.getString("storeName");
        Integer storeImage = bundle.getInt("storeImage");

        mStoreName.setText(storeName);
        mStoreImage.setImageResource(storeImage);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0,0);
            }
        });
    }
}