package com.rajabmammadli.rockit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    ListView aboutListView;
    String mTitle[] = {"Automatically update Rockit", "Use mobile data for updates", "Notify when update available", "Notify when update installed"};

    ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        aboutListView = findViewById(R.id.aboutListView);
        backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        AboutAdapter adapter = new AboutAdapter(this, mTitle);
        aboutListView.setAdapter(adapter);
    }

    class AboutAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];


        public AboutAdapter(Context context, String title[]) {
            super(context, R.layout.about_row, title);
            this.context = context;
            this.rTitle = title;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.about_row, parent, false);
            TextView title = row.findViewById(R.id.title);

            title.setText(rTitle[position]);


            return row;
        }
    }

}