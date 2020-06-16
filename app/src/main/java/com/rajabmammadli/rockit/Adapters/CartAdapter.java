package com.rajabmammadli.rockit.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajabmammadli.rockit.Models.CartModel;
import com.rajabmammadli.rockit.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    ArrayList<CartModel> cartModelArrayList;
    Context context;

    public CartAdapter(ArrayList<CartModel> cartModelArrayList, Context context) {
        this.cartModelArrayList = cartModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.cartProductImage.setImageResource(cartModelArrayList.get(position).getCartProductImage());
        holder.cartProductName.setText(cartModelArrayList.get(position).getCartProductName());
        holder.cartProductPrice.setText(cartModelArrayList.get(position).getCartProductPrice());
        holder.cartProductSize.setText(cartModelArrayList.get(position).getCartProductSize());
        holder.cartProductColor.setText(cartModelArrayList.get(position).getCartProductColor());

    }

    @Override
    public int getItemCount() {
        return cartModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView cartProductImage;
        TextView cartProductName;
        TextView cartProductSize;
        TextView cartProductColor;
        TextView cartProductPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cartProductImage = itemView.findViewById(R.id.cartProductImage);
            cartProductName = itemView.findViewById(R.id.cartProductName);
            cartProductSize = itemView.findViewById(R.id.cartProductSize);
            cartProductColor = itemView.findViewById(R.id.cartProductColor);
            cartProductPrice = itemView.findViewById(R.id.cartProductPrice);
        }
    }
}
