package com.example.tubes3.fragmentView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.tubes3.FragmentListener;
import com.example.tubes3.MainActivity;
import com.example.tubes3.R;

public class profile extends Fragment implements View.OnClickListener{

    private TextView username;
    private TextView idUser;
    private TextView email;
    private TextView phone;
    private Button setting;
    private Button history;
    private Button logout;
    private FragmentListener listener;
    public static ImageView img;
    public static profile newInstance(){
        profile fragment1 = new profile();
        return fragment1;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.profile,container,false);

        MainActivity.bottomNav.setVisibility(View.VISIBLE);
        this.username=view.findViewById(R.id.username2);
        this.idUser=view.findViewById(R.id.iduser);
        this.email=view.findViewById(R.id.email);
        this.phone=view.findViewById(R.id.phonenum);
        this.setting=view.findViewById(R.id.setting);
        this.history=view.findViewById(R.id.history);
        this.logout=view.findViewById(R.id.Logout);
        this.img=view.findViewById(R.id.profilebg);

        this.username.setText(login.usernamelog);
        this.idUser.setText(Integer.toString(login.idlog));
        this.email.setText(login.emaillog);
        this.phone.setText(login.phonelog);
        this.setting.setOnClickListener(this);
        this.history.setOnClickListener(this);
        this.logout.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v==this.setting){

            listener.changePage(11);

        }
        if(v==this.history){

            listener.changePage(6);

        }
        if(v==this.logout){

            listener.changePage(8);

        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof  FragmentListener){
            this.listener = (FragmentListener) context;
        } else{
            throw new ClassCastException(context.toString()
                    + " must implement FragmentListener");
        }
    }
}
