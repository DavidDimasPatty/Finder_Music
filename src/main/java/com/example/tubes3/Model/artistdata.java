package com.example.tubes3.Model;

public class artistdata {

    private String artis;
    private float rating;
    private int listen;
    private String desc;
    private String gambar;

    public artistdata(String artis,float rating,int listen,String desc,String gambar) {
        this.artis=artis;
        this.rating=rating;
        this.listen=listen;
        this.desc=desc;
        this.gambar=gambar;
    }



    public String getArtis() {
        return artis;
    }


    public float getRating() {
        return rating;
    }

    public int getListen() {
        return listen;
    }

    public String getDesc() { return  desc; }

    public String getGambar() { return  gambar; }

    public void setRating(float rating) { this.rating = rating; }

    public void setimage( String image) { this.gambar = gambar; }
}
