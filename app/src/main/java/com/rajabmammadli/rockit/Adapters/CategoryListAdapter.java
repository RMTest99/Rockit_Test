package com.rajabmammadli.rockit.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajabmammadli.rockit.Models.CategoryListModel;
import com.rajabmammadli.rockit.Models.CategoryModel;
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.categoryName.setText(categoryListModelArrayList.get(position).getCategoryName());
    }

    @Override
    public int getItemCount() {
        return categoryListModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView categoryName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryName = itemView.findViewById(R.id.categoryListName);
        }
    }
}
