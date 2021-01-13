package com.example.tubes3.fragmentView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.tubes3.R;

public class topsong extends Fragment {
    public static topsong newInstance(){
        topsong fragment1 = new topsong();
        return fragment1;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.topsongs,container,false);


        return view;
    }
}
