package com.rajabmammadli.rockit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.rajabmammadli.rockit.Adapters.CategoryListAdapter;
import com.rajabmammadli.rockit.Adapters.OverviewAdapter;
import com.rajabmammadli.rockit.Models.CategoryModel;

import java.util.ArrayList;

public class CategoryListActivity extends AppCompatActivity {

    RecyclerView categoryListRecyclerView;
    ArrayList<CategoryModel> categoryModelArrayList;
    CategoryListAdapter categoryListAdapter;

    ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);

        categoryListRecyclerView = findViewById(R.id.categoryListRecyclerView);

        backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String[] categoryName = {"Art", "Books", "Clothing", "Electronics", "Furniture", "Household", "Nutrition", "Office supplies", "Photography"};

        categoryModelArrayList = new ArrayList<>();
        for (int i = 0; i < categoryName.length; i++) {
            CategoryModel model = new CategoryModel(categoryName[i]);
            categoryModelArrayList.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        categoryListRecyclerView.setLayoutManager(layoutManager);
        categoryListRecyclerView.setItemAnimator(new DefaultItemAnimator());

        categoryListAdapter = new CategoryListAdapter(categoryModelArrayList, getApplicationContext());
        categoryListRecyclerView.setAdapter(categoryListAdapter);

        DividerItemDecoration itemDecorator = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.divider));

        categoryListRecyclerView.addItemDecoration(itemDecorator);

    }
}