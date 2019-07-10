package com.example.panda.Models;

public class Product {

    private String name;
    private String unit;
    private int price;
    private String urlhinh;

    public Product(){
    }

    public Product(String name, String unit, int price, String urlhinh) {
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.urlhinh = urlhinh;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUrlhinh() {
        return urlhinh;
    }

    public void setUrl(String url) {
        this.urlhinh = url;
    }
}
