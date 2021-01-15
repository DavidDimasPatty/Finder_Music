package com.example.tubes3.presenter;

import com.example.tubes3.Model.songdata;

import java.util.ArrayList;

public class presenterSong {
    public static ArrayList<songdata> alData = new ArrayList<songdata>();
    public static void addToList(String nama, String artis, String album,int rating,int listen,String desc,String release){
        alData.add(new songdata(nama,artis,  album, rating, listen, desc, release));
    }

    public static String getNama(int position){
        return alData.get(position).getNama();
    }
    public static String getArtis(int position){
        return alData.get(position).getArtis();
    }
    public static String getdesc(int position){
        return alData.get(position).getDesc();
    }

    public static String getAlbum(int position){
        return alData.get(position).getAlbum();
    }
    public static int getlisten(int position){
        return alData.get(position).getListen();
    }
    public static int getrating(int position){
        return alData.get(position).getRating();
    }

    public static String getrelease(int position){
        return alData.get(position).getrelease();
    }
    public static int getTotalSize(){
        return alData.size();
    }
    /* public static int setRating(int position,){
         return alData.get(position).getScore();
     }*/
    public static void remove(int position){
        alData.remove(position);
    }
}
