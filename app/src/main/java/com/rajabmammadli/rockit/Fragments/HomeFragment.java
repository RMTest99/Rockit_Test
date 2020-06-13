package com.rajabmammadli.rockit.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rajabmammadli.rockit.Adapters.CategoryAdapter;
import com.rajabmammadli.rockit.Adapters.NewReleaseAdapter;
import com.rajabmammadli.rockit.Adapters.StoreAdapter;
import com.rajabmammadli.rockit.CategoryListActivity;
import com.rajabmammadli.rockit.Models.CategoryListModel;
import com.rajabmammadli.rockit.Models.NewReleaseListModel;
import com.rajabmammadli.rockit.Models.StoreListModel;
import com.rajabmammadli.rockit.OverviewActivity;
import com.rajabmammadli.rockit.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView storesRecyclerView;
    ArrayList<StoreListModel> storeListModels;
    StoreAdapter storeAdapter;

    RecyclerView categoriesRecyclerView;
    ArrayList<CategoryListModel> categoryListModels;
    CategoryAdapter categoryAdapter;

    RecyclerView newReleaseRecyclerView;
    ArrayList<NewReleaseListModel> newReleaseListModels;
    NewReleaseAdapter newReleaseAdapter;

    TextView newReleasesAll;
    TextView categoriesAll;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        categoriesRecyclerView = view.findViewById(R.id.categoriesRecyclerView);
        newReleaseRecyclerView = view.findViewById(R.id.newReleaseRecyclerView);
        storesRecyclerView = view.findViewById(R.id.storesRecyclerView);

        newReleasesAll = view.findViewById(R.id.newReleasesAll);
        categoriesAll = view.findViewById(R.id.categoriesAll);

        categoriesAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CategoryListActivity.class);
                startActivity(intent);
            }
        });

        newReleasesAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), OverviewActivity.class);
                startActivity(intent);
            }
        });

        //Stores data
        Integer[] storesImage = {R.drawable.nikelogo, R.drawable.samsunglogo, R.drawable.reeboklogo, R.drawable.adidaslogo};
        String[] storeMainName = {"Nike", "Samsung", "Reebok", "Adidas"};

        //Categories data
        Integer[] bgColor = {R.drawable.tshirtbg, R.drawable.householdbg, R.drawable.electronicsbg, R.drawable.booksbg};
        String[] categoryDesc = {"T-Shirts", "Household", "Electronics", "Books"};

        //New Release data
        Integer[] bgImage = {R.drawable.nikesneaker, R.drawable.tshirt, R.drawable.book, R.drawable.honeybottle, R.drawable.samsungphone};
        String[] productName = {"Nike Sneaker", "Benetton T-Shirt", "Principles to Fortune", "Pure Honey", "Samsung S20+"};
        String[] storeName = {"Nike", "Benetton", "Scott J. Bintz", "Banker's Backyard", "Samsung"};
        String[] priceList = {"$135", "$42", "$24.99", "$8.99", "$1299.99"};

        storeListModels = new ArrayList<>();
        for (int i = 0; i < storeMainName.length; i++) {
            StoreListModel model = new StoreListModel(storesImage[i], storeMainName[i]);
            storeListModels.add(model);
        }

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        storesRecyclerView.setLayoutManager(layoutManager2);
        storesRecyclerView.setItemAnimator(new DefaultItemAnimator());

        storeAdapter = new StoreAdapter(storeListModels, getContext());
        storesRecyclerView.setAdapter(storeAdapter);

        categoryListModels = new ArrayList<>();
        for (int i = 0; i < bgColor.length; i++) {
            CategoryListModel model = new CategoryListModel(bgColor[i], categoryDesc[i]);
            categoryListModels.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
        categoriesRecyclerView.setLayoutManager(layoutManager);
        categoriesRecyclerView.setItemAnimator(new DefaultItemAnimator());

        categoryAdapter = new CategoryAdapter(getContext(), categoryListModels);
        categoriesRecyclerView.setAdapter(categoryAdapter);

        newReleaseListModels = new ArrayList<>();
        for (int i = 0; i < bgImage.length; i++) {
            NewReleaseListModel newReleaseListModel = new NewReleaseListModel(bgImage[i], productName[i], storeName[i], priceList[i]);
            newReleaseListModels.add(newReleaseListModel);
        }

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        newReleaseRecyclerView.setLayoutManager(layoutManager1);
        newReleaseRecyclerView.setItemAnimator(new DefaultItemAnimator());

        newReleaseAdapter = new NewReleaseAdapter(newReleaseListModels, getContext());
        newReleaseRecyclerView.setAdapter(newReleaseAdapter);

        // Inflate the layout for this fragment
        return view;
    }
}