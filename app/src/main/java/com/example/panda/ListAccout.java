package com.example.panda;

public class ListAccout {

        private String name;
        private String email;
        private String sdt;
        private int imv;

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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getImv() {
        return imv;
    }

    public void setImv(int imv) {
        this.imv = imv;
    }

    public ListAccout(String name, String email, String sdt, int imv) {
        this.name = name;
        this.email = email;
        this.sdt = sdt;
        this.imv = imv;
    };





}
