package com.rajabmammadli.rockit.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.rajabmammadli.rockit.AboutActivity;
import com.rajabmammadli.rockit.AuthenticationActivity;
import com.rajabmammadli.rockit.CompleteUserActivity;
import com.rajabmammadli.rockit.FavoritesActivity;
import com.rajabmammadli.rockit.FeedActivity;
import com.rajabmammadli.rockit.HelpActivity;
import com.rajabmammadli.rockit.OrderActivity;
import com.rajabmammadli.rockit.ProductActivity;
import com.rajabmammadli.rockit.R;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {

    ListView profileListView;
    String mDescription[] = {"My Account", "Order History", "Favorites", "Need Help", "About this app"};

    CircleImageView profileImg;
    TextView fullName;
    TextView logoutBtn;

    //Firebase
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    StorageReference storageReference;
    FirebaseStorage firebaseStorage;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        //Firebase
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseStorage = FirebaseStorage.getInstance();
        storageReference = firebaseStorage.getReference();

        fullName = view.findViewById(R.id.fullName);
        profileImg = view.findViewById(R.id.profileImg);

        String userEmail = firebaseUser.getEmail();

        logoutBtn = view.findViewById(R.id.logoutBtn);

        profileListView = view.findViewById(R.id.profileListView);

        ProfileAdapter profileAdapter = new ProfileAdapter(getContext(), mDescription);
        profileListView.setAdapter(profileAdapter);

        profileListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(getContext(), CompleteUserActivity.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(getContext(), OrderActivity.class);
                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(getContext(), FavoritesActivity.class);
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(getContext(), HelpActivity.class);
                    startActivity(intent);
                }
                if (position == 4) {
                    Intent intent = new Intent(getContext(), AboutActivity.class);
                    startActivity(intent);
                }
            }
        });

        databaseReference.orderByChild("userEmail").equalTo(userEmail).addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    String firstName = childSnapshot.child("userFirstName").getValue(String.class);
                    String lastName = childSnapshot.child("userLastName").getValue(String.class);
                    fullName.setText(firstName + " " + lastName);

                    if (getActivity() == null) {
                        return;
                    }

                    String imageUrl = childSnapshot.child("userImageUrl").getValue(String.class);
                    Glide.with(getActivity()).load(imageUrl).into(profileImg);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    class ProfileAdapter extends ArrayAdapter<String> {

        Context context;
        String mDescription[];

        ProfileAdapter(Context c, String description[]) {
            super(c, R.layout.profile_row, description);
            this.context = c;
            this.mDescription = description;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.profile_row, parent, false);
            TextView description = row.findViewById(R.id.description);

            description.setText(mDescription[position]);

            return row;
        }
    }

    //Logout user
    public void logoutClicked(View view) {

    }

}