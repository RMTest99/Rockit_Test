package com.rajabmammadli.rockit.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajabmammadli.rockit.Models.SearchTagModel;
import com.rajabmammadli.rockit.R;

import java.util.ArrayList;

public class SearchTagAdapter extends RecyclerView.Adapter<SearchTagAdapter.ViewHolder> {

    ArrayList<SearchTagModel> searchTagModels;
    Context context;

    public SearchTagAdapter(ArrayList<SearchTagModel> searchTagModels, Context context) {
        this.searchTagModels = searchTagModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tag_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tagText.setText(searchTagModels.get(position).getSearchTag());

    }

    @Override
    public int getItemCount() {
        return searchTagModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tagText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tagText = itemView.findViewById(R.id.tagText);
        }
    }
}
