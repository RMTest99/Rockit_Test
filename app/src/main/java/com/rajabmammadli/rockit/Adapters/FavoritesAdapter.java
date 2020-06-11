package com.rajabmammadli.rockit.Adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajabmammadli.rockit.Models.FavoritesModel;
import com.rajabmammadli.rockit.R;

import java.util.ArrayList;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewHolder> {

    ArrayList<FavoritesModel> favoritesModels;
    Context context;

    public FavoritesAdapter(ArrayList<FavoritesModel> favoritesModels, Context context) {
        this.favoritesModels = favoritesModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorites_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.productImg.setImageResource(favoritesModels.get(position).getProductImg());
        holder.productName.setText(favoritesModels.get(position).getProductName());
        holder.storeName.setText(favoritesModels.get(position).getStoreName());
        holder.priceList.setText(favoritesModels.get(position).getPriceList());

    }

    @Override
    public int getItemCount() {
        return favoritesModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView productImg;
        TextView productName;
        TextView storeName;
        TextView priceList;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productImg = itemView.findViewById(R.id.productImg);
            productName = itemView.findViewById(R.id.productName);
            storeName = itemView.findViewById(R.id.storeName);
            priceList = itemView.findViewById(R.id.priceList);
        }
    }
}
