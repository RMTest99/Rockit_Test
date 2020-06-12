package com.rajabmammadli.rockit.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.rajabmammadli.rockit.Models.RecentlyViewedModel;
import com.rajabmammadli.rockit.R;

import java.util.ArrayList;

public class RecentViewedAdapter extends RecyclerView.Adapter<RecentViewedAdapter.ViewHolder> {

    ArrayList<RecentlyViewedModel> recentlyViewedModelArrayList;
    Context context;

    public RecentViewedAdapter(ArrayList<RecentlyViewedModel> recentlyViewedModelArrayList, Context context) {
        this.recentlyViewedModelArrayList = recentlyViewedModelArrayList;
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

        holder.recentProductImg.setImageResource(recentlyViewedModelArrayList.get(position).getRecentBgImage());
        holder.recentProductName.setText(recentlyViewedModelArrayList.get(position).getRecentProductName());
        holder.recentStoreName.setText(recentlyViewedModelArrayList.get(position).getRecentStoreName());
        holder.recentPriceList.setText(recentlyViewedModelArrayList.get(position).getRecentPriceList());

    }

    @Override
    public int getItemCount() {
        return recentlyViewedModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView recentProductImg;
        TextView recentProductName;
        TextView recentStoreName;
        TextView recentPriceList;
        CardView recentCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            recentProductImg = itemView.findViewById(R.id.recentProductImg);
            recentProductName = itemView.findViewById(R.id.recentProductName);
            recentStoreName = itemView.findViewById(R.id.recentStoreName);
            recentPriceList = itemView.findViewById(R.id.recentPriceList);
            recentCardView = itemView.findViewById(R.id.recentCardView);
        }
    }
}
