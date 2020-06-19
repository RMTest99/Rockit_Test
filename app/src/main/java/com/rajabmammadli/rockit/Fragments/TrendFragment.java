package com.rajabmammadli.rockit.Fragments;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.util.AbstractDrawerImageLoader;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;
import com.rajabmammadli.rockit.Adapters.PopularProductAdapter;
import com.rajabmammadli.rockit.Adapters.TrendingAdapter;
import com.rajabmammadli.rockit.FilterActivity;
import com.rajabmammadli.rockit.Models.PopularProductModel;
import com.rajabmammadli.rockit.Models.TrendingModel;
import com.rajabmammadli.rockit.R;

import java.util.ArrayList;

public class TrendFragment extends Fragment {

    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    FirebaseUser firebaseUser;

    RecyclerView trendingTodayRecyclerView;
    ArrayList<TrendingModel> trendingModelArrayList;
    TrendingAdapter trendingAdapter;

    RecyclerView popularProductsRecyclerView;
    ArrayList<PopularProductModel> popularProductModelArrayList;
    PopularProductAdapter popularProductAdapter;

    ImageButton filterBtn;

    public TrendFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_trend, container, false);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");

        filterBtn = view.findViewById(R.id.filterBtn);

        filterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FilterActivity.class);
                startActivity(intent);
            }
        });

        String userEmail = firebaseUser.getEmail();

        trendingTodayRecyclerView = view.findViewById(R.id.trendingTodayRecyclerView);
        popularProductsRecyclerView = view.findViewById(R.id.popularProductsRecyclerView);

        //Popular products data
        Integer[] popularProductImage = {R.drawable.tshirt, R.drawable.nikesneaker, R.drawable.samsungphone, R.drawable.honeybottle, R.drawable.book};
        String[] popularProductName = {"Benetton T-Shirt", "Nike Sneaker", "Samsung S20+", "Pure Honey", "Principles to Fortune"};
        String[] popularStoreName = {"Benetton", "Nike", "Samsung", "Banker's Backyard", "Scott J. Bintz"};
        String[] popularPriceList = {"$42", "$135", "$1299.99", "$8.99", "$24.99"};

        popularProductModelArrayList = new ArrayList<>();
        for (int i = 0; i < popularProductImage.length; i++) {
            PopularProductModel model = new PopularProductModel(popularProductImage[i], popularProductName[i], popularStoreName[i], popularPriceList[i]);
            popularProductModelArrayList.add(model);
        }

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        popularProductsRecyclerView.setLayoutManager(layoutManager1);
        popularProductsRecyclerView.setItemAnimator(new DefaultItemAnimator());

        popularProductAdapter = new PopularProductAdapter(popularProductModelArrayList, getContext());
        popularProductsRecyclerView.setAdapter(popularProductAdapter);

        //Trend data
        Integer[] productImage = {R.drawable.nikesneaker, R.drawable.tshirt, R.drawable.book, R.drawable.honeybottle, R.drawable.samsungphone};
        String[] productName = {"Nike Sneaker", "Benetton T-Shirt", "Principles to Fortune", "Pure Honey", "Samsung S20+"};
        String[] storeName = {"Nike", "Benetton", "Scott J. Bintz", "Banker's Backyard", "Samsung"};
        String[] priceList = {"$135", "$42", "$24.99", "$8.99", "$1299.99"};

        trendingModelArrayList = new ArrayList<>();
        for (int i = 0; i < productImage.length; i++) {
            TrendingModel model = new TrendingModel(productImage[i], productName[i], storeName[i], priceList[i]);
            trendingModelArrayList.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        trendingTodayRecyclerView.setLayoutManager(layoutManager);
        trendingTodayRecyclerView.setItemAnimator(new DefaultItemAnimator());

        trendingAdapter = new TrendingAdapter(trendingModelArrayList, getContext());
        trendingTodayRecyclerView.setAdapter(trendingAdapter);

        databaseReference.orderByChild("userEmail").equalTo(userEmail).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {

                    String imageUrl = childSnapshot.child("userImageUrl").getValue(String.class);
                    String userEmail = childSnapshot.child("userEmail").getValue(String.class);
                    String firstName = childSnapshot.child("userFirstName").getValue(String.class);
                    String lastName = childSnapshot.child("userLastName").getValue(String.class);

                    String fullName = firstName + " " + lastName;

                    Toolbar toolbar = view.findViewById(R.id.toolbar);
                    ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
                    ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
                    toolbar.setBackground(getResources().getDrawable(R.color.colorWhite));

                    DrawerImageLoader.init(new AbstractDrawerImageLoader() {
                        @Override
                        public void set(ImageView imageView, Uri uri, Drawable placeholder, String tag) {
                            Glide.with(imageView.getContext()).load(uri).placeholder(placeholder).into(imageView);
                        }

                        @Override
                        public void cancel(ImageView imageView) {
                            Glide.with(imageView.getContext()).clear(imageView);
                        }
                    });

                    AccountHeader accountHeader = new AccountHeaderBuilder()
                            .withActivity(getActivity())
                            .withTextColor(getResources().getColor(R.color.colorWhite))
                            .withHeaderBackground(R.color.colorDarkPurple)
                            .addProfiles(new ProfileDrawerItem().withName(fullName).withEmail(userEmail).withIcon(imageUrl))
                            .withTranslucentStatusBar(true)
                            .build();

                    PrimaryDrawerItem item1 = new PrimaryDrawerItem().withName("Home");
                    PrimaryDrawerItem item2 = new PrimaryDrawerItem().withName("Awesome");

                    SecondaryDrawerItem s1 = new SecondaryDrawerItem().withName("Recent").withIcon(FontAwesome.Icon.faw_newspaper);

                    Drawer result = new DrawerBuilder()
                            .withActivity(getActivity())
                            .withToolbar(toolbar)
                            .withAccountHeader(accountHeader)
                            .addDrawerItems(
                                    item1,
                                    item2,
                                    new DividerDrawerItem(),
                                    s1
                            ).build();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}