package com.rajabmammadli.rockit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.rajabmammadli.rockit.Adapters.OrderHistoryAdapter;
import com.rajabmammadli.rockit.Models.OrderListModel;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    RecyclerView orderRecyclerView;
    ArrayList<OrderListModel> orderListModels;
    OrderHistoryAdapter orderHistoryAdapter;

    ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        orderRecyclerView = findViewById(R.id.orderRecyclerView);

        backBtn = findViewById(R.id.backBtn);

        Integer[] orderProductImage = {R.drawable.tshirt, R.drawable.nikesneaker, R.drawable.book, R.drawable.honeybottle, R.drawable.samsungphone};
        String[] orderProductName = {"Benetton T-Shirt", "Nike Air Max 97", "Principles to Fortune", "Pure Honey", "Samsung S20+"};
        String[] orderDate = {"Bought Jan 2, 2021", "Bought Jan 28, 2021", "Bought Feb 4, 2021", "Bought March 23, 2021", "Bought April 30, 2021"};

        orderListModels = new ArrayList<>();
        for (int i = 0; i < orderProductImage.length; i++) {
            OrderListModel orderListModel = new OrderListModel(orderProductImage[i], orderProductName[i], orderDate[i]);
            orderListModels.add(orderListModel);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        orderRecyclerView.setLayoutManager(layoutManager);
        orderRecyclerView.setItemAnimator(new DefaultItemAnimator());

        orderHistoryAdapter = new OrderHistoryAdapter(orderListModels, getApplicationContext());
        orderRecyclerView.setAdapter(orderHistoryAdapter);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}