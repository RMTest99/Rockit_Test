package com.rajabmammadli.rockit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rajabmammadli.rockit.Adapters.ShippingOptionAdapter;
import com.rajabmammadli.rockit.Models.ShippingOptionModel;

import java.util.ArrayList;

public class ShippingOptionsActivity extends AppCompatActivity {

    RecyclerView shippingOptionsRecyclerView;
    ArrayList<ShippingOptionModel> shippingOptionModelArrayList;
    ShippingOptionAdapter shippingOptionAdapter;

    Button continueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_options);

        shippingOptionsRecyclerView = findViewById(R.id.shippingOptionRecyclerView);
        continueBtn = findViewById(R.id.continueBtn);

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShippingOptionsActivity.this, BillingActivity.class);
                startActivity(intent);
            }
        });

        String[] optionDesc = {"Standard (5-9 Business Days)", "Express (2-6 Business Days)", "2-Day (3 Business Days)", "1-Day (2 Business Days)"};
        String[] optionPrice = {"FREE", "$1.99", "$3.99", "$5.99"};

        shippingOptionModelArrayList = new ArrayList<>();
        for (int i = 0; i < optionDesc.length; i++) {
            ShippingOptionModel shippingOptionModel = new ShippingOptionModel(optionDesc[i], optionPrice[i]);
            shippingOptionModelArrayList.add(shippingOptionModel);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(ShippingOptionsActivity.this, LinearLayoutManager.VERTICAL, false);
        shippingOptionsRecyclerView.setLayoutManager(layoutManager);
        shippingOptionsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        shippingOptionsRecyclerView.addItemDecoration(new DividerItemDecoration(this, layoutManager.getOrientation()));
        shippingOptionsRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));

        shippingOptionAdapter = new ShippingOptionAdapter(shippingOptionModelArrayList, getApplicationContext());
        shippingOptionsRecyclerView.setAdapter(shippingOptionAdapter);
    }
}