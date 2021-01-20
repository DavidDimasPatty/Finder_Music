package com.example.tubes3.presenter;

import com.example.tubes3.Model.songdata;

import java.util.ArrayList;


public class presenter {
    static ArrayList<songdata> alData = new ArrayList<songdata>();
   /* public static void addToList(String nama, int score){
        alData.add(new data(nama,score));
    }*/
    public static String getNama(int position){
        return alData.get(position).getNama();
    }
    public static String getArtis(int position){
        return alData.get(position).getArtis();
    }
    public static String getalbum(int position){
        return alData.get(position).getAlbum();
    }


    public static int getlisten(int position){
        return alData.get(position).getListen();
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
