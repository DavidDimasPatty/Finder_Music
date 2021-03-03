package com.example.tubes3.fragmentView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.tubes3.FragmentListener;
import com.example.tubes3.MainActivity;
import com.example.tubes3.R;
import com.example.tubes3.adapter.ListAdapter;
import com.example.tubes3.adapter.userAdapter;
import com.example.tubes3.presenter.presenterAlbum;
import com.example.tubes3.presenter.presenterUser;

public class login  extends Fragment implements View.OnClickListener {
private EditText username;
private EditText password;
private Button  login;
private userAdapter ua;
private Button singup;
private FragmentListener listener;
public static String usernamelog;
public static String emaillog;
public static String pwlog;
public static int idlog;
public static String phonelog;

    public static login newInstance(){
        login fragment1 = new login();
        return fragment1;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.login,container,false);
        this.username=view.findViewById(R.id.username2);
        this.password=view.findViewById(R.id.password);
        this.singup=view.findViewById(R.id.signup);
        this.login=view.findViewById(R.id.login);
        this.login.setOnClickListener(this);
        this.singup.setOnClickListener(this);
        this.ua = new userAdapter();

        MainActivity.bottomNav.setVisibility(View.GONE);

        Log.d("TAG", "onCreateView: "+presenterUser.getTotalSize());
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v==this.login){
            for(int i = 0; i < presenterUser.getTotalSize() ; i++){
                if(username.getText().toString().equals(presenterUser.getUsername(i))&&password.getText().toString().equals(presenterUser.getpassword(i))){
                    listener.changePage(1);
                    this.username.setText("");
                    this.password.setText("");
                }
                usernamelog=presenterUser.getUsername(i);
                emaillog=presenterUser.getemail(i);
                idlog=presenterUser.getid(i);
                pwlog=presenterUser.getpassword(i);
                phonelog=presenterUser.getphone(i);

            }
        }

        if(v==this.singup){
            listener.changePage(12);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentListener){
            this.listener = (FragmentListener) context;
        } else{
            throw new ClassCastException(context.toString()
                    + " must implement FragmentListener");
        }
    }



}
