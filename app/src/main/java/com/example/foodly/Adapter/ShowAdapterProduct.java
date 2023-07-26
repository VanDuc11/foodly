package com.example.foodly.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodly.Fragment.Home_Fragment;
import com.example.foodly.Model.Product;
import com.example.foodly.R;
import com.example.foodly.Server.SvrSelect;

import java.util.List;

import retrofit2.Callback;

public class ShowAdapterProduct extends RecyclerView.Adapter<ShowAdapterProduct.productViewHoder> {
    Context context;
    List<Product> list;

    public ShowAdapterProduct(Context context, List<Product> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public productViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_row_product,parent,false);
        return new productViewHoder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull productViewHoder holder, int position) {
        Product p = list.get(position);
        holder.tvName.setText(list.get(position).getName());
        holder.img.setImageResource(R.drawable.c);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public  class productViewHoder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tvName;
        public productViewHoder(@NonNull View v) {
            super(v);
            img = v.findViewById(R.id.item_row_prod_img);
            tvName = v.findViewById(R.id.item_row_prod_tvName);
        }
    }

}
