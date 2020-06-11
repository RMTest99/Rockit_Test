package com.rajabmammadli.rockit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.rajabmammadli.rockit.Models.User;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import de.hdodenhof.circleimageview.CircleImageView;

public class CompleteUserActivity extends AppCompatActivity {

    String EMPTY = "Empty";

    //Assign views
    ImageButton backBtn;
    TextView saveBtn;
    CircleImageView profileImg;
    EditText emailEditText, firstNameEditText, lastNameEditText, userNameEditText, ageEditText;

    private final int PICK_IMAGE_REQUEST = 71;
    private Uri filepath;
    private String imageDownloadUrl;

    //Firebase
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_user);

        backBtn = findViewById(R.id.backBtn);
        saveBtn = findViewById(R.id.saveBtn);
        profileImg = findViewById(R.id.profileImg);
        emailEditText = findViewById(R.id.emailEditText);
        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        userNameEditText = findViewById(R.id.usernameEditText);
        ageEditText = findViewById(R.id.ageEditText);

        //Firebase
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseStorage = FirebaseStorage.getInstance();
        storageReference = firebaseStorage.getReference();

        final String userEmail = firebaseUser.getEmail();

        databaseReference.orderByChild("userEmail").equalTo(userEmail).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    String newEmailText = childSnapshot.child("userEmail").getValue(String.class);
                    String newUserNameText = childSnapshot.child("userName").getValue(String.class);
                    String imageUrl = childSnapshot.child("userImageUrl").getValue(String.class);
                    String newFirstName = childSnapshot.child("userFirstName").getValue(String.class);
                    String newLastName = childSnapshot.child("userLastName").getValue(String.class);
                    String newAge = childSnapshot.child("userAge").getValue(String.class);
                    emailEditText.setText(newEmailText);
                    userNameEditText.setText(newUserNameText);
                    firstNameEditText.setText(newFirstName);
                    lastNameEditText.setText(newLastName);
                    ageEditText.setText(newAge);
                    Glide.with(getApplicationContext()).load(imageUrl).into(profileImg);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.orderByChild("userEmail").equalTo(userEmail).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {

                            //Assign suitable data
                            final String userId = childSnapshot.child("userId").getValue(String.class);
                            final String userEmail = emailEditText.getText().toString();
                            final String userFirstName = firstNameEditText.getText().toString();
                            final String userLastName = lastNameEditText.getText().toString();
                            final String userAge = ageEditText.getText().toString();
                            final String userCity = EMPTY;
                            final String userState = EMPTY;
                            final String userZip = EMPTY;
                            final boolean userEmailVerified = false;
                            final String userRegistrationDate = childSnapshot.child("userRegistrationDate").getValue(String.class);
                            final String userVerificationCode = EMPTY;
                            final String userPhone = EMPTY;
                            final String userCountry = EMPTY;
                            final String userAddress = EMPTY;
                            final String userImageUrl = imageDownloadUrl;
                            final String userName = userNameEditText.getText().toString();

                            firebaseUser.updateEmail(userEmail);
                            updateUser(userId, userEmail, userFirstName, userLastName, userAge, userCity, userState, userZip, userEmailVerified, userRegistrationDate, userVerificationCode, userPhone, userCountry, userAddress, userName, userImageUrl);
                            uploadImage();
                            Toast.makeText(CompleteUserActivity.this, "User Data Updated", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        //Profile Image Listener
        profileImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }
        });

        //Back Button Listener
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Return to previous page
                finish();
            }
        });
    }

    private void updateUser(String userId, String userEmail, String userFirstName, String userLastName, String userAge, String userCity, String userState, String userZip,
                            boolean userEmailVerified, String userRegistrationDate, String userVerificationCode, String userPhone, String userCountry, String userAddress, String userName, String userImageUrl) {

        User user = new User(userId, userEmail, userFirstName, userLastName, userAge, userCity, userState, userZip, userEmailVerified, userRegistrationDate, userVerificationCode, userPhone, userCountry, userAddress, userName, userImageUrl);

        databaseReference.child(userId).setValue(user);
    }

    private void uploadImage() {
        if (filepath != null) {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            final StorageReference ref = storageReference.child("images/" + UUID.randomUUID().toString());

            ref.putFile(filepath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    if (!CompleteUserActivity.this.isFinishing() && progressDialog != null) {
                        progressDialog.dismiss();
                    }
                    Toast.makeText(CompleteUserActivity.this, "Uploaded", Toast.LENGTH_SHORT).show();

                    ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            imageDownloadUrl = uri.toString();
                        }
                    });
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    progressDialog.dismiss();
                    Toast.makeText(CompleteUserActivity.this, "Failed" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                    double progress = (100.0 * taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                    progressDialog.setMessage("Uploaded " + (int)progress + "%");
                }
            });
        }
    }

    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filepath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath);
                profileImg.setImageBitmap(bitmap);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}