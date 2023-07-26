package com.example.foodly.Model;

public class Product {
    private String name,image ,soluong,status ,price,loai;



    public Product() {
    }

    public Product(String name, String image, String soluong, String status, String price, String loai) {
        this.name = name;
        this.image = image;
        this.soluong = soluong;
        this.status = status;
        this.price = price;
        this.loai = loai;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
}
