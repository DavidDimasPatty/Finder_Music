package com.example.tubes3.fragmentView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.tubes3.R;

public class topalbum extends Fragment {

    public static topalbum newInstance(){
        topalbum fragment1 = new topalbum();
        return fragment1;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.topalbum,container,false);


        return view;
    }
}
