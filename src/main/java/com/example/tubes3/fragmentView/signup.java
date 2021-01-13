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

public class signup extends Fragment implements View.OnClickListener{
    private EditText username;
    private EditText password;
    private EditText retype;
    private EditText email;
    private EditText phone;
    private Button singup;
    private FragmentListener listener;

    public static signup newInstance(){
        signup fragment1 = new signup();
        return fragment1;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.signup,container,false);
        this.username=view.findViewById(R.id.usernamesign);
        this.password=view.findViewById(R.id.password);
        this.retype=view.findViewById(R.id.retype);
        this.email=view.findViewById(R.id.email);
        this.phone=view.findViewById(R.id.phone);
        this.singup=view.findViewById(R.id.signupp);
        this.singup.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v==this.singup){
            if(!username.getText().toString().equals("")&&!password.getText().toString().equals("")&&!retype.getText().toString().equals("")&&!email.getText().toString().equals("")&&!phone.getText().toString().equals("")){

                    if(this.password.getText().toString().equals(this.retype.getText().toString())){
                        MainActivity.addUser(0,this.username.getText().toString(),this.password.getText().toString(),this.email.getText().toString(),this.phone.getText().toString());
                        listener.changePage(8);
                        Log.d("TAG", "berhasil");
                    }
            }
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
