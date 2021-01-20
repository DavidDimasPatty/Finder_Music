package com.example.tubes3.presenter;

import com.example.tubes3.Model.albumdata;

import java.util.ArrayList;

public class presenterAlbum {
    static ArrayList<albumdata> alData = new ArrayList<albumdata>();
    public static void addToList(String artis, String album,int rating,int listen,String desc,String release,boolean isi,String image){
        alData.add(new albumdata( artis, album, rating, listen, desc, release,isi,image));
    }
    public static String getArtis(int position){
        return alData.get(position).getArtis();
    }

    public static String getAlbum(int position){
        return alData.get(position).getAlbum();
    }
    public static String getdesc(int position){
        return alData.get(position).getDesc();
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

    public static String getimage(int position){
        return alData.get(position).getimage();
    }
    public static void setimage(int position,String image){
        alData.get(position).setimage(image);
    }
    public static Boolean getadaisi(int position){
        return alData.get(position).getradaisi();
    }
    public static void setadaisi(int position,boolean isi){
       alData.get(position).setadaisi(isi);
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
