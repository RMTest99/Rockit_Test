package com.rajabmammadli.rockit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.rajabmammadli.rockit.Adapters.SearchTagAdapter;
import com.rajabmammadli.rockit.Adapters.StoreTagAdapter;
import com.rajabmammadli.rockit.Models.StoreTagModel;

import java.util.ArrayList;

public class StoreAllActivity extends AppCompatActivity {

    RecyclerView recyclerViewStoreTag;
    ArrayList<StoreTagModel> storeTagModelArrayList;
    StoreTagAdapter storeTagAdapter;

    ImageButton backBtn;

    LinearLayout searchSide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_all);

        recyclerViewStoreTag = findViewById(R.id.recyclerViewStoreTag);
        backBtn = findViewById(R.id.backBtn);
        searchSide = findViewById(R.id.searchSide);

        searchSide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StoreAllActivity.this, SearchActivity.class);
                startActivity(intent);
                overridePendingTransition(0,0);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0,0);
            }
        });

        String[] storeTag = {"Electronics", "Household", "Clothing", "Toys", "Books"};

        storeTagModelArrayList = new ArrayList<>();
        for (int i = 0; i < storeTag.length; i++) {
            StoreTagModel searchTagModel = new StoreTagModel(storeTag[i]);
            storeTagModelArrayList.add(searchTagModel);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewStoreTag.setLayoutManager(layoutManager);
        recyclerViewStoreTag.setItemAnimator(new DefaultItemAnimator());

        storeTagAdapter = new StoreTagAdapter(storeTagModelArrayList, getApplicationContext());
        recyclerViewStoreTag.setAdapter(storeTagAdapter);
    }
}