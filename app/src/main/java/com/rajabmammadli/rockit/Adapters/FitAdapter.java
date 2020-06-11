package com.rajabmammadli.rockit.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajabmammadli.rockit.Models.FitModel;
import com.rajabmammadli.rockit.R;

import java.util.ArrayList;

public class FitAdapter extends RecyclerView.Adapter<FitAdapter.ViewHolder> {

    ArrayList<FitModel> fitModels;
    Context context;

    public FitAdapter(ArrayList<FitModel> fitModels, Context context) {
        this.fitModels = fitModels;
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
        holder.productPhoto.setImageResource(fitModels.get(position).getProductPhoto());
    }

    @Override
    public int getItemCount() {
        return fitModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView productPhoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productPhoto = itemView.findViewById(R.id.productPhoto);
        }
    }
}
