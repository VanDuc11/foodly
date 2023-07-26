package com.example.foodly.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodly.Model.Product;
import com.example.foodly.R;

import java.util.List;

public class ShowAdapterProduct2 extends RecyclerView.Adapter<ShowAdapterProduct2.productViewHoder2> {
    Context context;
    List<Product> list;

    public ShowAdapterProduct2(Context context, List<Product> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public productViewHoder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_row_product2,parent,false);
        return new productViewHoder2(v);
    }

    @Override
    public void onBindViewHolder(@NonNull productViewHoder2 holder, int position) {
        Product p = list.get(position);
        holder.tv.setText(list.get(position).getName());
        holder.img.setImageResource(R.drawable.tra);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class productViewHoder2 extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tv;
        public productViewHoder2(@NonNull View v) {
            super(v);
            img = v.findViewById(R.id.item_row_prod_img2);
            tv = v.findViewById(R.id.item_row_prod_tv2);
        }
    }
}
