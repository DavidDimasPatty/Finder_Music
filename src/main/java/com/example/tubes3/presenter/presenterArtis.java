package com.example.tubes3.presenter;

import com.example.tubes3.Model.artistdata;

import java.util.ArrayList;

public class presenterArtis {
    static ArrayList<artistdata> alData = new ArrayList<artistdata>();
   public static void addToList(String artis,int rating,int listen,String desc,String gambar){
         alData.add(new artistdata(artis,rating, listen,desc, gambar));
     }
    public static String getArtis(int position){
        return alData.get(position).getArtis();
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

    public static String getimage(int position){
        return alData.get(position).getGambar();
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
