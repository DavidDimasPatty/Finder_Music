package com.example.tubes3.fragmentView.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tubes3.FragmentListener;
import com.example.tubes3.R;
import com.example.tubes3.fragmentView.profile;

import static android.app.Activity.RESULT_OK;

public class dialog_ganti_pp extends AppCompatDialogFragment implements FragmentListener,View.OnClickListener {
    private static final int REQUEST_IMAGE_CAPTURE = 0;
    private Button gallery;
    private Button ganti;
    private ImageView image;
    private Bitmap imageBitmap;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater= getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.dialog_ganti_pp,null);

        this.ganti=view.findViewById(R.id.foto);
        this.image=view.findViewById(R.id.image_view);
        this.ganti.setOnClickListener(this);

        builder.setView(view).setTitle("Ganti Photo Profile").setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("oke", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                profile.img.setImageBitmap(imageBitmap);
            }
        });

        return builder.create();

    }

    @Override
    public void changePage(int page) {

    }

    @Override
    public void onClick(View v) {
        if(v==this.ganti){
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

        }
    }

    @Override
   public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            this.imageBitmap = (Bitmap) extras.get("data");
            this.image.setImageBitmap(imageBitmap);
            profile.img.setImageBitmap(imageBitmap);
        }
    }
}
