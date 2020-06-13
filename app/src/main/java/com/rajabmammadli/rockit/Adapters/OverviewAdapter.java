package com.rajabmammadli.rockit.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajabmammadli.rockit.Models.OverviewModel;
import com.rajabmammadli.rockit.R;

import java.util.ArrayList;

public class OverviewAdapter extends RecyclerView.Adapter<OverviewAdapter.ViewHolder> {

    ArrayList<OverviewModel> overviewModelArrayList;
    Context context;

    public OverviewAdapter(ArrayList<OverviewModel> overviewModelArrayList, Context context) {
        this.overviewModelArrayList = overviewModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.overview_item, parent, false);
        return new OverviewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.overviewProductImage.setImageResource(overviewModelArrayList.get(position).getOverviewProductImage());
        holder.overviewProductName.setText(overviewModelArrayList.get(position).getOverviewProductName());
        holder.overviewStoreName.setText(overviewModelArrayList.get(position).getOverviewStoreName());
        holder.overviewPriceList.setText(overviewModelArrayList.get(position).getOverviewPriceList());
    }

    @Override
    public int getItemCount() {
        return overviewModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView overviewProductImage;
        TextView overviewProductName;
        TextView overviewStoreName;
        TextView overviewPriceList;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            overviewProductImage = itemView.findViewById(R.id.overviewProductImage);
            overviewProductName = itemView.findViewById(R.id.overviewProductName);
            overviewStoreName = itemView.findViewById(R.id.overviewStoreName);
            overviewPriceList = itemView.findViewById(R.id.overviewPriceList);
        }
    }
}
