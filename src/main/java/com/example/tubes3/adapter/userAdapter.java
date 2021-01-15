package com.example.tubes3.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tubes3.Model.songdata;
import com.example.tubes3.Model.userdata;
import com.example.tubes3.R;
import com.example.tubes3.presenter.presenter;

import java.util.ArrayList;

public class userAdapter {
    private ArrayList<userdata> userAdapter;
    public userAdapter(){
        this.userAdapter = new ArrayList<userdata>();
    }
    public void add(int id,String username,String password,String email,String phone){
        this.userAdapter.add(new userdata( id,username, password, email, phone));
    }




}
