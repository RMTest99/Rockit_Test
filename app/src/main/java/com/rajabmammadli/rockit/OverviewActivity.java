package com.rajabmammadli.rockit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.rajabmammadli.rockit.Adapters.OverviewAdapter;
import com.rajabmammadli.rockit.Adapters.StoreAdapter;
import com.rajabmammadli.rockit.Models.OverviewModel;

import java.util.ArrayList;

public class OverviewActivity extends AppCompatActivity {

    RecyclerView overviewRecyclerView;
    ArrayList<OverviewModel> overviewModels;
    OverviewAdapter overviewAdapter;

    ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        overviewRecyclerView = findViewById(R.id.productListRecyclerView);
        backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Integer[] overviewProductImage = {R.drawable.nikesneaker, R.drawable.samsungphone, R.drawable.honeybottle, R.drawable.book, R.drawable.tshirt};
        String[] overviewProductName = {"Nike Sneaker", "Samsung S20+", "Pure Honey", "Principles to Fortune", "Benetton T-Shirt"};
        String[] overviewStoreName = {"Nike", "Samsung", "Banker's Backyard", "Scott J. Bintz", "Benetton"};
        String[] overviewPriceList = {"$135", "$1299.99", "$8.99", "$24.99", "$42"};

        overviewModels = new ArrayList<>();
        for (int i = 0; i < overviewProductImage.length; i++) {
            OverviewModel model = new OverviewModel(overviewProductImage[i], overviewProductName[i], overviewStoreName[i], overviewPriceList[i]);
            overviewModels.add(model);
        }
        
        LinearLayoutManager layoutManager = new GridLayoutManager(this, 2);
        overviewRecyclerView.setLayoutManager(layoutManager);
        overviewRecyclerView.setItemAnimator(new DefaultItemAnimator());
        overviewRecyclerView.addItemDecoration(new DividerItemDecoration(this, layoutManager.getOrientation()));
        overviewRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));

        overviewAdapter = new OverviewAdapter(overviewModels, getApplicationContext());
        overviewRecyclerView.setAdapter(overviewAdapter);

    }
}