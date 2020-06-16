package com.rajabmammadli.rockit.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.rajabmammadli.rockit.Adapters.BestSellerAdapter;
import com.rajabmammadli.rockit.Adapters.RecentViewedAdapter;
import com.rajabmammadli.rockit.Adapters.SearchTagAdapter;
import com.rajabmammadli.rockit.Models.BestSellerModel;
import com.rajabmammadli.rockit.Models.RecentlyViewedModel;
import com.rajabmammadli.rockit.Models.SearchTagModel;
import com.rajabmammadli.rockit.R;
import com.rajabmammadli.rockit.SearchActivity;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    RecyclerView recyclerViewSearchTag;
    ArrayList<SearchTagModel> searchTagModels;
    SearchTagAdapter searchTagAdapter;

    RecyclerView recentlyViewedRecyclerView;
    ArrayList<RecentlyViewedModel> recentlyViewedModels;
    RecentViewedAdapter recentViewedAdapter;

    RecyclerView bestSellerRecyclerView;
    ArrayList<BestSellerModel> bestSellerModels;
    BestSellerAdapter bestSellerAdapter;

    LinearLayout searchHeader;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);

        recyclerViewSearchTag = view.findViewById(R.id.recyclerViewSearchTag);
        recentlyViewedRecyclerView = view.findViewById(R.id.recentlyViewedRecyclerView);
        bestSellerRecyclerView = view.findViewById(R.id.bestSellerRecyclerView);

        searchHeader = view.findViewById(R.id.searchHeader);

        searchHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(0,0);
            }
        });

        Integer[] bestSellerImage = {R.drawable.samsungphone, R.drawable.honeybottle, R.drawable.book, R.drawable.tshirt, R.drawable.nikesneaker};
        String[] bestSellerProductName = {"Samsung S20+", "Pure Honey", "Principles to Fortune", "Benetton T-Shirt", "Nike Sneaker"};
        String[] bestSellerStoreName = {"Samsung", "Banker's Backyard", "Scott J. Bintz", "Benetton", "Nike"};
        String[] bestSellerPriceList = {"$1299.99", "$8.99", "$24.99", "$42", "$135"};

        bestSellerModels = new ArrayList<>();
        for (int i = 0; i < bestSellerImage.length; i++) {
            BestSellerModel bestSellerModel = new BestSellerModel(bestSellerImage[i], bestSellerProductName[i], bestSellerStoreName[i], bestSellerPriceList[i]);
            bestSellerModels.add(bestSellerModel);
        }

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        bestSellerRecyclerView.setLayoutManager(layoutManager2);
        bestSellerRecyclerView.setItemAnimator(new DefaultItemAnimator());

        bestSellerAdapter = new BestSellerAdapter(bestSellerModels, getContext());
        bestSellerRecyclerView.setAdapter(bestSellerAdapter);

        Integer[] recentBgImage = {R.drawable.tshirt, R.drawable.nikesneaker, R.drawable.book, R.drawable.samsungphone, R.drawable.honeybottle};
        String[] recentProductName = {"Benetton T-Shirt", "Nike Sneaker", "Principles to Fortune", "Samsung S20+", "Pure Honey"};
        String[] recentStoreName = {"Benetton", "Nike", "Scott J. Bintz", "Samsung", "Banker's Backyard"};
        String[] recentPriceList = {"$42", "$135", "$24.99", "$1299.99", "$8.99"};

        recentlyViewedModels = new ArrayList<>();
        for (int i = 0; i < recentBgImage.length; i++) {
            RecentlyViewedModel recentlyViewedModel = new RecentlyViewedModel(recentBgImage[i], recentProductName[i], recentStoreName[i], recentPriceList[i]);
            recentlyViewedModels.add(recentlyViewedModel);
        }

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recentlyViewedRecyclerView.setLayoutManager(layoutManager1);
        recentlyViewedRecyclerView.setItemAnimator(new DefaultItemAnimator());

        recentViewedAdapter = new RecentViewedAdapter(recentlyViewedModels, getContext());
        recentlyViewedRecyclerView.setAdapter(recentViewedAdapter);

        String[] searchTag = {"Electronics", "Household", "Clothing", "Toys", "Books"};

        searchTagModels = new ArrayList<>();
        for (int i = 0; i < searchTag.length; i++) {
            SearchTagModel searchTagModel = new SearchTagModel(searchTag[i]);
            searchTagModels.add(searchTagModel);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewSearchTag.setLayoutManager(layoutManager);
        recyclerViewSearchTag.setItemAnimator(new DefaultItemAnimator());

        searchTagAdapter = new SearchTagAdapter(searchTagModels, getContext());
        recyclerViewSearchTag.setAdapter(searchTagAdapter);
        // Inflate the layout for this fragment
        return view;
    }
}