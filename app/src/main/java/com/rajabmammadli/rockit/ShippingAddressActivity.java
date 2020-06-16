package com.rajabmammadli.rockit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rajabmammadli.rockit.Models.User;

public class ShippingAddressActivity extends AppCompatActivity {

    String EMPTY = "Empty";

    //Initializing views
    ImageButton backBtn;
    Button continueBtn;
    EditText firstNameEditText, lastNameEditText, addressEditText, addressEditText2, countryEditText, cityEditText, stateEditText, postCodeEditText;

    //Firebase
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_address);

        //Firebase
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        //Assigning views
        backBtn = findViewById(R.id.backBtn);
        continueBtn = findViewById(R.id.continueBtn);
        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        addressEditText = findViewById(R.id.addressEditText);
        addressEditText2 = findViewById(R.id.addressEditText2);
        countryEditText = findViewById(R.id.countryEditText);
        cityEditText = findViewById(R.id.cityEditText);
        stateEditText = findViewById(R.id.stateEditText);
        postCodeEditText = findViewById(R.id.postCodeEditText);

        final String userEmail = firebaseUser.getEmail();

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.orderByChild("userEmail").equalTo(userEmail).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {

                            //Assign suitable data
                            final String userId = childSnapshot.child("userId").getValue(String.class);
                            final String userEmail = childSnapshot.child("userEmail").getValue(String.class);
                            final String userFirstName = childSnapshot.child("userFirstName").getValue(String.class);
                            final String userLastName = childSnapshot.child("userLastName").getValue(String.class);
                            final String userAge = childSnapshot.child("userAge").getValue(String.class);
                            final String userCity = cityEditText.getText().toString();
                            final String userState = stateEditText.getText().toString();
                            final String userZip = postCodeEditText.getText().toString();
                            final boolean userEmailVerified = false;
                            final String userRegistrationDate = childSnapshot.child("userRegistrationDate").getValue(String.class);
                            final String userVerificationCode = EMPTY;
                            final String userPhone = EMPTY;
                            final String userCountry = countryEditText.getText().toString();
                            final String userAddress = addressEditText.getText().toString();
                            final String userName = childSnapshot.child("userName").getValue(String.class);
                            final String userImageUrl = childSnapshot.child("userImageUrl").getValue(String.class);

                            updateUser(userId, userEmail, userFirstName, userLastName, userAge, userCity, userState, userZip, userEmailVerified, userRegistrationDate, userVerificationCode, userPhone, userCountry, userAddress, userName, userImageUrl);
                            Toast.makeText(ShippingAddressActivity.this, "User Data Updated", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(ShippingAddressActivity.this, ShippingOptionsActivity.class);
                            startActivity(intent);
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });



        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void updateUser(String userId, String userEmail, String userFirstName, String userLastName, String userAge, String userCity, String userState, String userZip,
                            boolean userEmailVerified, String userRegistrationDate, String userVerificationCode, String userPhone, String userCountry, String userAddress, String userName, String userImageUrl) {

        User user = new User(userId, userEmail, userFirstName, userLastName, userAge, userCity, userState, userZip, userEmailVerified, userRegistrationDate, userVerificationCode, userPhone, userCountry, userAddress, userName, userImageUrl);

        databaseReference.child(userId).setValue(user);
    }

}