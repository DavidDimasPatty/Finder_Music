package com.example.tubes3.presenter;

import com.example.tubes3.Model.songdata;
import com.example.tubes3.Model.userdata;

import java.util.ArrayList;

public class presenterUser {
    static ArrayList<userdata> alData = new ArrayList<userdata>();
    public static void addToList(int id,String username,String password,String email,String phone){
        alData.add(new userdata(id,username,  password, email, phone));
    }

    public static String getUsername(int position){
        return alData.get(position).getUsername();
    }
    public static int getid(int position){
        return alData.get(position).getIdd();
    }
    public static String getemail(int position){
        return alData.get(position).getEmail();
    }

    public static String getphone(int position){
        return alData.get(position).getPhone();
    }
    public static String getpassword(int position){
        return alData.get(position).getPassword();
    }
    public static void setpw(int position,String pass){
        alData.get(position).setPassword(pass);
    }
    public static int getTotalSize(){
        return alData.size();
    }


}
