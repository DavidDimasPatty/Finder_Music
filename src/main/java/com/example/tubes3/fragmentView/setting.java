package com.example.tubes3.fragmentView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.tubes3.R;
import com.example.tubes3.fragmentView.dialog.dialog_ganti_password;
import com.example.tubes3.fragmentView.dialog.dialog_ganti_pp;
import com.example.tubes3.fragmentView.dialog.dialog_ganti_warna;

public class setting extends Fragment implements View.OnClickListener{
    private TextView gantibg;
    private TextView gantipp;
    private TextView gantipw;

    public static setting newInstance(){
        setting fragment1 = new setting();
        return fragment1;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.setting,container,false);

        this.gantipp=view.findViewById(R.id.gantipp);
        this.gantipw=view.findViewById(R.id.gantipw);
        this.gantipw.setOnClickListener(this);
        this.gantipp.setOnClickListener(this);



        return view;
    }

    @Override
    public void onClick(View v) {
        if(v==this.gantibg){
        openDialog3();
        }
        if(v==this.gantipp){
    openDialog2();
        }
        if(v==this.gantipw){
            openDialog();
        }
    }

    public void openDialog(){
        dialog_ganti_password exampleDialog=new dialog_ganti_password();
        exampleDialog.show(getFragmentManager(),"example dialog");
    }

    public void openDialog2(){
        dialog_ganti_pp exampleDialog2=new dialog_ganti_pp();
        exampleDialog2.show(getFragmentManager(),"example dialog");
    }

    public void openDialog3(){
        dialog_ganti_warna exampleDialog3=new dialog_ganti_warna();
        exampleDialog3.show(getFragmentManager(),"example dialog");
    }

}
