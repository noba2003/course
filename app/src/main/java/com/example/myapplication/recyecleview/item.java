package com.example.myapplication.recyecleview;

public class item {
   private String title,auther,adresseSite,about;

    public item(String title, String auther, String adresseSite, String about) {
        this.title = title;
        this.auther = auther;
        this.adresseSite = adresseSite;
        this.about = about;
    }

    public item() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public String getAdresseSite() {
        return adresseSite;
    }

    public void setAdresseSite(String adresseSite) {
        this.adresseSite = adresseSite;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
