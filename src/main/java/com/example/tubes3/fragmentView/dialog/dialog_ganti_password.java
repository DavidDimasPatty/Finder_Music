package com.example.tubes3.fragmentView.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.Fragment;

import com.example.tubes3.FragmentListener;
import com.example.tubes3.R;
import com.example.tubes3.fragmentView.login;
import com.example.tubes3.presenter.presenterUser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class dialog_ganti_password extends AppCompatDialogFragment implements FragmentListener {

    private EditText passnow;
    private EditText passbar;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater= getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.dialog_ganti_password,null);

       this.passnow=view.findViewById(R.id.passwordsek);
       this.passbar=view.findViewById(R.id.Passwordbar);


        builder.setView(view).setTitle("Tambah Makanan").setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("oke", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(passnow.getText().toString().equals(login.pwlog)&&!passnow.getText().toString().equals("")){
                    for(int i = 0; i< presenterUser.getTotalSize(); i++){
                        if(presenterUser.getUsername(i).equals(login.usernamelog)){
                            presenterUser.setpw(i,passbar.getText().toString());
                            break;
                        }
                    }
                }
            }
        });
        Log.d("TAG", "onCreateDialog: "+presenterUser.getpassword(0));
        return builder.create();

    }

    @Override
    public void changePage(int page) {

    }
}
