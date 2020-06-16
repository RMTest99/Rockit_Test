package com.rajabmammadli.rockit.Fragments;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.mikepenz.materialize.holder.ImageHolder;
import com.rajabmammadli.rockit.R;
import com.squareup.picasso.Picasso;

public class TrendFragment extends Fragment {

    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    FirebaseUser firebaseUser;

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

        String userEmail = firebaseUser.getEmail();

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