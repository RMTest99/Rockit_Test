package com.rajabmammadli.rockit.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajabmammadli.rockit.CategoryDetailActivity;
import com.rajabmammadli.rockit.Models.StoreListModel;
import com.rajabmammadli.rockit.R;
import com.rajabmammadli.rockit.StoreDetailActivity;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {

    ArrayList<StoreListModel> storeListModels;
    Context context;

    public StoreAdapter(ArrayList<StoreListModel> storeListModels, Context context) {
        this.storeListModels = storeListModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.storeImage.setImageResource(storeListModels.get(position).getStoreImage());
        holder.storeName.setText(storeListModels.get(position).getStoreNames());

        //Set OnClickListener
        holder.storeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StoreDetailActivity.class);
                intent.putExtra("storeImage", storeListModels.get(position).getStoreImage());
                intent.putExtra("storeName", storeListModels.get(position).getStoreNames());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return storeListModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView storeImage;
        TextView storeName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            storeImage = itemView.findViewById(R.id.storeImg);
            storeName = itemView.findViewById(R.id.storeName);
        }
    }
}
