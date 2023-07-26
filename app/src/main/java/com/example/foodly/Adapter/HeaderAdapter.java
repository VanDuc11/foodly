package com.example.foodly.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodly.Model.HomeHorHeader;
import com.example.foodly.R;

import java.util.List;

public class HeaderAdapter extends RecyclerView.Adapter<HeaderAdapter.viewHoder>{
    public Context context;
    List<HomeHorHeader> list;

    public HeaderAdapter(Context context, List<HomeHorHeader> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_header,parent,false);
        return new viewHoder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHoder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImg());
        holder.textView.setText(list.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHoder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public viewHoder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_header_img);
            textView = itemView.findViewById(R.id.item_header_tvname);
        }
    }
}
