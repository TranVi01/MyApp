package com.example.panda;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;




public class InformationAccout  {

    private  String name = "tran hoai vi";
    private String email = "fsda@gmail.com";
    private int phone =  123456789 ;
    private ImageView image ;

    public InformationAccout (){
    }

    public  InformationAccout(String name, String email, int phone ) {
        this.name = name;
        this.email = email;
        this.phone = phone;
//        this.image = image;
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

    public int getPhone() {

        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    public void setImage(ImageView image) {
        this.image = image;
    }

    public ImageView getImage() {
        image.setImageResource(Integer.parseInt("@drawable/ic_person_black_24dp.xml"));
        return image;
    }

}
