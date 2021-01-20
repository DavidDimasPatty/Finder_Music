package com.example.tubes3.Model;

public class songdata {
    private String nama;
    private String artis;
    private String album;
    private float rating;
    private int listen;
    private String image;

    public songdata(String nama, String artis, String album,float rating,int listen) {
        this.nama=nama;
        this.artis=artis;
        this.album=album;
        this.rating=rating;
        this.listen=listen;

    }


    public String getNama() {
        return nama;
    }

    public String getArtis() {
        return artis;
    }

    public String getAlbum() {
        return album;
    }

    public float getRating() {
        return rating;
    }



    public int getListen() {
        return listen;
    }



    public void setRating(float rating) { this.rating = rating; }


    public void setListen(int listen) { this.listen = listen; }

    public void setArtis(String artis) { this.artis = artis; }

    public void setAlbum(String album) { this.album = album; }
}
