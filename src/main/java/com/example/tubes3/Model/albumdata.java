package com.example.tubes3.Model;

public class albumdata {

    private String artis;
    private String album;
    private int rating;
    private int listen;
    private String desc;
    private String release;
    private boolean adaisi;
    private String image;

    public albumdata( String artis, String album,int rating,int listen,String desc,String release,boolean adaisi,String image) {

        this.artis=artis;
        this.album=album;
        this.rating=rating;
        this.listen=listen;
        this.desc=desc;
        this.release=release;
        this.adaisi=adaisi;
        this.image=image;

    }


    public String getArtis() {
        return artis;
    }

    public String getAlbum() {
        return album;
    }

    public int getRating() {
        return rating;
    }

    public int getListen() {
        return listen;
    }

    public String getDesc() { return  desc; }

    public String getrelease() {
        return release;
    }

    public boolean getradaisi() {
        return adaisi;
    }


    public void setadaisi(boolean isi) { this.adaisi=isi; }

    public void setRating(int rating) { this.rating = rating; }


    public String getimage() {
        return image;
    }


    public void setimage(String isi) { this.image=image; }
}
