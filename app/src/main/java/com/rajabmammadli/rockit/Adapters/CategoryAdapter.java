package com.rajabmammadli.rockit.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajabmammadli.rockit.Models.CategoryListModel;
import com.rajabmammadli.rockit.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    ArrayList<CategoryListModel> categoryListModels;
    Context context;

    public CategoryAdapter(Context context, ArrayList<CategoryListModel> categoryListModels) {
        this.context = context;
        this.categoryListModels = categoryListModels;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bgColor.setImageResource(categoryListModels.get(position).getBgColor());
        holder.categoryDescription.setText(categoryListModels.get(position).getCategoryDesc());
    }

    @Override
    public int getItemCount() {
        return categoryListModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView bgColor;
        TextView categoryDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bgColor = itemView.findViewById(R.id.bgColor);
            categoryDescription = itemView.findViewById(R.id.categoryDescription);
        }
    }
}
