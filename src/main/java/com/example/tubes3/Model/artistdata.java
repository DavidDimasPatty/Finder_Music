package com.example.tubes3.Model;

public class artistdata {

    private String artis;
    private int rating;
    private int listen;
    private String desc;
    private String gambar;

    public artistdata(String artis,int rating,int listen,String desc,String gambar) {
        this.artis=artis;
        this.rating=rating;
        this.listen=listen;
        this.desc=desc;
        this.gambar=gambar;

    }



    public String getArtis() {
        return artis;
    }


    public int getRating() {
        return rating;
    }

    public int getListen() {
        return listen;
    }

    public String getDesc() { return  desc; }

    public String getGambar() { return  gambar; }

    public void setRating(int rating) { this.rating = rating; }
}
