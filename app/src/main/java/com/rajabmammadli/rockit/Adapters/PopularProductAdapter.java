package com.rajabmammadli.rockit.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajabmammadli.rockit.Models.PopularProductModel;
import com.rajabmammadli.rockit.R;

import java.util.ArrayList;

public class PopularProductAdapter extends RecyclerView.Adapter<PopularProductAdapter.ViewHolder> {

    ArrayList<PopularProductModel> popularProductModelArrayList;
    Context context;

    public PopularProductAdapter(ArrayList<PopularProductModel> popularProductModelArrayList, Context context) {
        this.popularProductModelArrayList = popularProductModelArrayList;
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

        holder.popularProductImage.setImageResource(popularProductModelArrayList.get(position).getPopularProductImage());
        holder.popularProductName.setText(popularProductModelArrayList.get(position).getPopularProductName());
        holder.popularStoreName.setText(popularProductModelArrayList.get(position).getPopularStoreName());
        holder.popularPriceList.setText(popularProductModelArrayList.get(position).getPopularPriceList());
    }

    @Override
    public int getItemCount() {
        return popularProductModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView popularProductImage;
        TextView popularProductName;
        TextView popularStoreName;
        TextView popularPriceList;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            popularProductImage = itemView.findViewById(R.id.productImg);
            popularProductName = itemView.findViewById(R.id.productName);
            popularStoreName = itemView.findViewById(R.id.storeName);
            popularPriceList = itemView.findViewById(R.id.priceList);
        }
    }
}
