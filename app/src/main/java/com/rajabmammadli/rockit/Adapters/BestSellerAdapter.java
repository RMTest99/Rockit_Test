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

import com.rajabmammadli.rockit.Models.BestSellerModel;
import com.rajabmammadli.rockit.R;

import java.util.ArrayList;

public class BestSellerAdapter extends RecyclerView.Adapter<BestSellerAdapter.ViewHolder> {

    ArrayList<BestSellerModel> bestSellerModelArrayList;
    Context context;

    public BestSellerAdapter(ArrayList<BestSellerModel> bestSellerModelArrayList, Context context) {
        this.bestSellerModelArrayList = bestSellerModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recent_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.bestSellerProductImage.setImageResource(bestSellerModelArrayList.get(position).getBestSellerProductImage());
        holder.bestSellerProductName.setText(bestSellerModelArrayList.get(position).getBestSellerProductName());
        holder.bestSellerStoreName.setText(bestSellerModelArrayList.get(position).getBestSellerStoreName());
        holder.bestSellerPriceList.setText(bestSellerModelArrayList.get(position).getBestSellerPriceList());

    }

    @Override
    public int getItemCount() {
        return bestSellerModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView bestSellerProductImage;
        TextView bestSellerProductName;
        TextView bestSellerStoreName;
        TextView bestSellerPriceList;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bestSellerProductImage = itemView.findViewById(R.id.recentProductImg);
            bestSellerProductName = itemView.findViewById(R.id.recentProductName);
            bestSellerStoreName = itemView.findViewById(R.id.recentStoreName);
            bestSellerPriceList = itemView.findViewById(R.id.recentPriceList);
        }
    }
}
