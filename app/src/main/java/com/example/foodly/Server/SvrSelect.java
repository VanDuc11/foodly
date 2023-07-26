package com.example.foodly.Server;

import com.example.foodly.Model.Product;

public class SvrSelect {
    private Product[] products;
    private String messager;

    public SvrSelect(Product[] products, String messager) {
        this.products = products;
        this.messager = messager;
    }

    public Product[] getProducts() {
        return products;
    }

    public String getMessager() {
        return messager;
    }
}
