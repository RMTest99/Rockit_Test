package com.rajabmammadli.rockit.Fragments;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rajabmammadli.rockit.Adapters.SearchTagAdapter;
import com.rajabmammadli.rockit.Models.SearchTagModel;
import com.rajabmammadli.rockit.R;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    RecyclerView recyclerViewSearchTag;
    ArrayList<SearchTagModel> searchTagModels;
    SearchTagAdapter searchTagAdapter;

    SearchView searchView;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);

        recyclerViewSearchTag = view.findViewById(R.id.recyclerViewSearchTag);

        String[] searchTag = {"Electronics", "Household", "Clothing", "Toys", "Books"};

        searchView = view.findViewById(R.id.searchView);

        searchView.setQueryHint("Search...");

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