package com.rajabmammadli.rockit.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajabmammadli.rockit.Models.StoreListModel;
import com.rajabmammadli.rockit.Models.StoreTagModel;
import com.rajabmammadli.rockit.R;

import java.util.ArrayList;

public class StoreTagAdapter extends RecyclerView.Adapter<StoreTagAdapter.ViewHolder> {

    ArrayList<StoreTagModel> storeTagModels;
    Context context;

    public StoreTagAdapter(ArrayList<StoreTagModel> storeTagModels, Context context) {
        this.storeTagModels = storeTagModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tag_row, parent, false);
        return new StoreTagAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tagText.setText(storeTagModels.get(position).getStoreTag());
    }

    @Override
    public int getItemCount() {
        return storeTagModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tagText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tagText = itemView.findViewById(R.id.tagText);
        }
    }
}
