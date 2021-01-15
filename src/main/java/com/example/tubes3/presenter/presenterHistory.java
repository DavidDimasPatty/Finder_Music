package com.example.tubes3.presenter;

import com.example.tubes3.Model.artistdata;
import com.example.tubes3.Model.history;

import java.util.ArrayList;

public class presenterHistory {

    static ArrayList<history> alData = new ArrayList<history>();
    public static void addToList(String user,String song){
        alData.add(new history(user,song));
    }
    public static String getUser(int position){
        return alData.get(position).getUser();
    }
    public static String getSong(int position){
        return alData.get(position).getSong();
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
