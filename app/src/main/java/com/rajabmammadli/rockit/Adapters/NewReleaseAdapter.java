package com.rajabmammadli.rockit.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.rajabmammadli.rockit.Models.NewReleaseListModel;
import com.rajabmammadli.rockit.ProductActivity;
import com.rajabmammadli.rockit.R;

import java.util.ArrayList;

public class NewReleaseAdapter extends RecyclerView.Adapter<NewReleaseAdapter.ViewHolder> {

    ArrayList<NewReleaseListModel> newReleaseListModels;
    Context context;

    public NewReleaseAdapter(ArrayList<NewReleaseListModel> newReleaseListModels, Context context) {
        this.newReleaseListModels = newReleaseListModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_release_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.productImg.setImageResource(newReleaseListModels.get(position).getBgImage());
        holder.productName.setText(newReleaseListModels.get(position).getProductName());
        holder.storeName.setText(newReleaseListModels.get(position).getStoreName());
        holder.priceList.setText(newReleaseListModels.get(position).getPriceList());

        //Set OnClickListener
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductActivity.class);
                intent.putExtra("productImage", newReleaseListModels.get(position).getBgImage());
                intent.putExtra("productName", newReleaseListModels.get(position).getProductName());
                intent.putExtra("storeName", newReleaseListModels.get(position).getStoreName());
                intent.putExtra("priceList", newReleaseListModels.get(position).getPriceList());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return newReleaseListModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView productImg;
        TextView productName;
        TextView storeName;
        TextView priceList;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productImg = itemView.findViewById(R.id.productImg);
            productName = itemView.findViewById(R.id.productName);
            storeName = itemView.findViewById(R.id.storeName);
            priceList = itemView.findViewById(R.id.priceList);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
