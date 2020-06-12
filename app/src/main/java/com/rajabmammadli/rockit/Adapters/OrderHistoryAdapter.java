package com.rajabmammadli.rockit.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajabmammadli.rockit.Models.OrderListModel;
import com.rajabmammadli.rockit.R;

import java.util.ArrayList;

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.ViewHolder> {

    ArrayList<OrderListModel> orderListModels;
    Context context;

    public OrderHistoryAdapter(ArrayList<OrderListModel> orderListModels, Context context) {
        this.orderListModels = orderListModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_history_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.orderProductImage.setImageResource(orderListModels.get(position).getOrderProductImage());
        holder.orderProductName.setText(orderListModels.get(position).getOrderProductName());
        holder.orderDate.setText(orderListModels.get(position).getOrderDate());

    }

    @Override
    public int getItemCount() {
        return orderListModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView orderProductImage;
        TextView orderProductName;
        TextView orderDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            orderProductImage = itemView.findViewById(R.id.orderProductImage);
            orderProductName = itemView.findViewById(R.id.orderProductName);
            orderDate = itemView.findViewById(R.id.orderDate);
        }
    }
}
