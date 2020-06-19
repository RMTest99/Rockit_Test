package com.rajabmammadli.rockit.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajabmammadli.rockit.CategoryDetailActivity;
import com.rajabmammadli.rockit.Models.CategoryListModel;
import com.rajabmammadli.rockit.Models.CategoryModel;
import com.rajabmammadli.rockit.ProductActivity;
import com.rajabmammadli.rockit.R;

import java.util.ArrayList;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {

    ArrayList<CategoryModel> categoryListModelArrayList;
    Context context;

    public CategoryListAdapter(ArrayList<CategoryModel> categoryListModelArrayList, Context context) {
        this.categoryListModelArrayList = categoryListModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list_item, parent, false);
        return new CategoryListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.categoryName.setText(categoryListModelArrayList.get(position).getCategoryName());

        //Set OnClickListener
        holder.categoryListMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CategoryDetailActivity.class);
                intent.putExtra("categoryName", categoryListModelArrayList.get(position).getCategoryName());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryListModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView categoryName;
        LinearLayout categoryListMain;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryName = itemView.findViewById(R.id.categoryListName);
            categoryListMain = itemView.findViewById(R.id.categoryListMain);
        }
    }
}
