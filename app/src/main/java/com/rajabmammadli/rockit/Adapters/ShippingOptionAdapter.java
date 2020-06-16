package com.rajabmammadli.rockit.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajabmammadli.rockit.Models.ShippingOptionModel;
import com.rajabmammadli.rockit.R;

import java.util.ArrayList;

public class ShippingOptionAdapter extends RecyclerView.Adapter<ShippingOptionAdapter.ViewHolder> {

    ArrayList<ShippingOptionModel> shippingOptionModels;
    Context context;

    public ShippingOptionAdapter(ArrayList<ShippingOptionModel> shippingOptionModels, Context context) {
        this.shippingOptionModels = shippingOptionModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shipping_option_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.optionDesc.setText(shippingOptionModels.get(position).getOptionDesc());
        holder.optionPrice.setText(shippingOptionModels.get(position).getOptionPrice());
    }

    @Override
    public int getItemCount() {
        return shippingOptionModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView optionDesc;
        TextView optionPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            optionDesc = itemView.findViewById(R.id.optionDesc);
            optionPrice = itemView.findViewById(R.id.optionPrice);
        }
    }
}
