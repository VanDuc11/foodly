package com.example.foodly.Interface;

import com.example.foodly.Server.SvrSelect;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfaceSelect {
    @GET("get_all_product.php")
    Call<SvrSelect> select();
}
