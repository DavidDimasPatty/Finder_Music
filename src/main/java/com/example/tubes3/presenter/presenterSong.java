package com.example.tubes3.presenter;

import com.example.tubes3.Model.songdata;

import java.util.ArrayList;

public class presenterSong {
    public static ArrayList<songdata> alData = new ArrayList<songdata>();
    public static void addToList(String nama, String artis, String album,float rating,int listen){
        alData.add(new songdata(nama,artis,  album, rating, listen));
    }

    public static String getNama(int position){
        return alData.get(position).getNama();
    }
    public static String getArtis(int position){
        return alData.get(position).getArtis();
    }


    public static String getAlbum(int position){
        return alData.get(position).getAlbum();
    }
    public static int getlisten(int position){
        return alData.get(position).getListen();
    }
    public static float getrating(int position){
        return alData.get(position).getRating();
    }
    public static void setAlbum(int position,String album){
       alData.get(position).setAlbum(album);
    }

    public static void setRating(int position,float rating){
        alData.get(position).setRating(rating);
    }
    public static int getTotalSize(){
        return alData.size();
    }

    public static void remove(int position){
        alData.remove(position);
    }
}
