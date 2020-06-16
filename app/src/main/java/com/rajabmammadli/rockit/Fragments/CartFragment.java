package com.rajabmammadli.rockit.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rajabmammadli.rockit.Adapters.CartAdapter;
import com.rajabmammadli.rockit.Models.CartModel;
import com.rajabmammadli.rockit.R;
import com.rajabmammadli.rockit.ShippingAddressActivity;

import java.util.ArrayList;

public class CartFragment extends Fragment {

    RecyclerView cartRecyclerView;

    ArrayList<CartModel> cartModelArrayList;
    CartAdapter cartAdapter;

    Button checkoutBtn;

    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        cartRecyclerView = view.findViewById(R.id.cartRecyclerView);
        checkoutBtn = view.findViewById(R.id.checkoutBtn);

        //Data Arrays
        Integer[] cartProductImage = {R.drawable.tshirt};
        String[] cartProductName = {"Benetton T-Shirt"};
        String[] cartProductSize = {"M"};
        String[] cartProductColor = {"White"};
        String[] cartProductPrice = {"$42"};

        cartModelArrayList = new ArrayList<>();
        for (int i = 0; i < cartProductImage.length; i++) {
            CartModel cartModel = new CartModel(cartProductImage[i], cartProductName[i], cartProductSize[i], cartProductColor[i], cartProductPrice[i]);
            cartModelArrayList.add(cartModel);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        cartRecyclerView.setLayoutManager(layoutManager);
        cartRecyclerView.setItemAnimator(new DefaultItemAnimator());

        cartAdapter = new CartAdapter(cartModelArrayList, getContext());
        cartRecyclerView.setAdapter(cartAdapter);
        cartRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));

        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ShippingAddressActivity.class);
                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}