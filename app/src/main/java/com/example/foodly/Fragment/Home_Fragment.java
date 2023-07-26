package com.example.foodly.Fragment;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.Toast;

import com.example.foodly.Adapter.HeaderAdapter;
import com.example.foodly.Adapter.ShowAdapterProduct;
import com.example.foodly.Adapter.ShowAdapterProduct2;
import com.example.foodly.Interface.InterfaceSelect;
import com.example.foodly.Model.HomeHorHeader;
import com.example.foodly.Model.Product;
import com.example.foodly.R;
import com.example.foodly.Server.SvrSelect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Home_Fragment extends Fragment {
    ImageView imageView;
    RecyclerView reyHor,rey,rey2;
    List<HomeHorHeader> listHor;
    ShowAdapterProduct adapterProduct;
    ShowAdapterProduct2 adapterProduct2;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_home_, container, false);
        reyHor = v.findViewById(R.id.frag_home_header_rey);
        rey = v.findViewById(R.id.frag_home_rey1);
        rey2 = v.findViewById(R.id.frag_home_rey2);
        reyHor.setHasFixedSize(true);
        reyHor.setNestedScrollingEnabled(false);

        rey.setHasFixedSize(true);
        rey.setNestedScrollingEnabled(false);

        rey2.setHasFixedSize(true);
        rey2.setNestedScrollingEnabled(false);
        listHor = new ArrayList<>();
        listHor.add(new HomeHorHeader(R.drawable.a,"Cafe"));
        listHor.add(new HomeHorHeader(R.drawable.a,"Trà"));
        listHor.add(new HomeHorHeader(R.drawable.a,"Trà sữa"));
        listHor.add(new HomeHorHeader(R.drawable.a,"Pizza"));
        listHor.add(new HomeHorHeader(R.drawable.a,"Bánh"));

        HeaderAdapter adapter = new HeaderAdapter(getContext(),listHor);
        reyHor.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        reyHor.setAdapter(adapter);

        return v;
    }
    List<Product> list;
    private void loadData(){
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl("https://batdongsanabc.000webhostapp.com/mob403lab4/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        InterfaceSelect interfaceSelect = retrofit.create(InterfaceSelect.class);
        Call<SvrSelect> call = interfaceSelect.select();
        call.enqueue(new Callback<SvrSelect>() {
            @Override
            public void onResponse(Call<SvrSelect> call, Response<SvrSelect> response) {
                SvrSelect select = response.body();
                list = new ArrayList<>(Arrays.asList(select.getProducts()));


                rey.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
                adapterProduct = new ShowAdapterProduct(getContext(),list);
                rey.setAdapter(adapterProduct);
            }

            @Override
            public void onFailure(Call<SvrSelect> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    List<Product> list2;
    private void loadData2(){
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl("https://batdongsanabc.000webhostapp.com/mob403lab4/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        InterfaceSelect interfaceSelect = retrofit.create(InterfaceSelect.class);
        Call<SvrSelect> call = interfaceSelect.select();
        call.enqueue(new Callback<SvrSelect>() {
            @Override
            public void onResponse(Call<SvrSelect> call, Response<SvrSelect> response) {
                SvrSelect select = response.body();
                list2 = new ArrayList<>(Arrays.asList(select.getProducts()));



                rey2.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
                adapterProduct2 = new ShowAdapterProduct2(getContext(),list2);
                rey2.setAdapter(adapterProduct2);
            }

            @Override
            public void onFailure(Call<SvrSelect> call, Throwable t) {
                System.out.println("ERROOO"+t.getMessage());
            }
        });
    }


    @Override
    public void onStart() {
        super.onStart();
        loadData();
        loadData2();
    }
}