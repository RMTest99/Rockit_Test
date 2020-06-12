package com.rajabmammadli.rockit.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajabmammadli.rockit.Models.StoreListModel;
import com.rajabmammadli.rockit.R;

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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.storeImage.setImageResource(storeListModels.get(position).getStoreImage());
        holder.storeName.setText(storeListModels.get(position).getStoreNames());

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
