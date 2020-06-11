package com.rajabmammadli.rockit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.rajabmammadli.rockit.Adapters.FavoritesAdapter;
import com.rajabmammadli.rockit.Models.FavoritesModel;

import java.util.ArrayList;

public class FavoritesActivity extends AppCompatActivity {

    RecyclerView favoritesRecyclerView;

    ArrayList<FavoritesModel> favoritesModels;
    FavoritesAdapter favoritesAdapter;

    ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        favoritesRecyclerView = findViewById(R.id.favoritesRecyclerView);

        Integer[] productImg = {R.drawable.nikesneaker, R.drawable.samsungphone, R.drawable.tshirt};
        String[] productName = {"Nike Sneaker", "Samsung S20+", "Benetton T-Shirt"};
        String[] storeName = {"Nike", "Samsung", "Benetton"};
        String[] priceList = {"$135", "$1299.99", "$42"};

        favoritesModels = new ArrayList<>();
        for (int i = 0; i < productImg.length; i++) {
            FavoritesModel favoritesModel = new FavoritesModel(productImg[i], productName[i], storeName[i], priceList[i]);
            favoritesModels.add(favoritesModel);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(FavoritesActivity.this, LinearLayoutManager.VERTICAL, false);
        favoritesRecyclerView.setLayoutManager(layoutManager);
        favoritesRecyclerView.setItemAnimator(new DefaultItemAnimator());

        favoritesAdapter = new FavoritesAdapter(favoritesModels, FavoritesActivity.this);
        favoritesRecyclerView.setAdapter(favoritesAdapter);

    }
}