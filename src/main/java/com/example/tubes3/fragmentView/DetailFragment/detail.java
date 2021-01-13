package com.example.tubes3.fragmentView.DetailFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.tubes3.R;
import com.example.tubes3.fragmentView.homepage;

public class detail extends Fragment {
    public static TextView artisl;
    public static  TextView descl;

    public static detail newInstance(){
       detail fragment1 = new detail();
        return fragment1;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
       View view = inflater.inflate(R.layout.detail,container,false);
        this.artisl=view.findViewById(R.id.judullagu);
        this.descl=view.findViewById(R.id.deskripsi);
        this.artisl.setText(homepage.artis);
        this.descl.setText(homepage.desc);

        return view;
    }


}
