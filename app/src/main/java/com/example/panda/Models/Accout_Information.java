package com.example.panda.Models;

import android.content.Context;

public class Accout_Information {

    private  int id;
    private String name;
    private String email;
    private String phone;
    private byte[] image;
    private Context context;

    public Accout_Information(){
    }

    public Accout_Information(int id, String name, String email, String phone, byte[] image) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.image = image;
    }

    public Accout_Information( String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }


}
