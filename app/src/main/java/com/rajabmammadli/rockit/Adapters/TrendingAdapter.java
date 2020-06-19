package com.rajabmammadli.rockit.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajabmammadli.rockit.Models.TrendingModel;
import com.rajabmammadli.rockit.R;

import java.util.ArrayList;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.ViewHolder> {

    ArrayList<TrendingModel> trendingModelArrayList;
    Context context;

    public TrendingAdapter(ArrayList<TrendingModel> trendingModelArrayList, Context context) {
        this.trendingModelArrayList = trendingModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_release_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.trendingProductImage.setImageResource(trendingModelArrayList.get(position).getProductImage());
        holder.trendingProductName.setText(trendingModelArrayList.get(position).getProductName());
        holder.trendingStoreName.setText(trendingModelArrayList.get(position).getStoreName());
        holder.trendingPriceList.setText(trendingModelArrayList.get(position).getPriceList());

    }

    @Override
    public int getItemCount() {
        return trendingModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView trendingProductImage;
        TextView trendingProductName;
        TextView trendingStoreName;
        TextView trendingPriceList;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            trendingProductImage = itemView.findViewById(R.id.productImg);
            trendingProductName = itemView.findViewById(R.id.productName);
            trendingStoreName = itemView.findViewById(R.id.storeName);
            trendingPriceList = itemView.findViewById(R.id.priceList);
        }
    }
}
