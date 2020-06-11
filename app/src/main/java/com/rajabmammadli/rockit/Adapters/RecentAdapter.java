package com.rajabmammadli.rockit.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajabmammadli.rockit.Models.RecentModel;
import com.rajabmammadli.rockit.R;

import java.util.ArrayList;

public class RecentAdapter extends RecyclerView.Adapter<RecentAdapter.ViewHolder> {

    ArrayList<RecentModel> recentModels;
    Context context;

    public RecentAdapter(ArrayList<RecentModel> recentModels, Context context) {
        this.recentModels = recentModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fit_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.recentProductPhoto.setImageResource(recentModels.get(position).getRecentProductPhoto());
    }

    @Override
    public int getItemCount() {
        return recentModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView recentProductPhoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            recentProductPhoto = itemView.findViewById(R.id.productPhoto);
        }
    }
}
