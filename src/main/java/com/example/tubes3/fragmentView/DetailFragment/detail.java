package com.example.tubes3.fragmentView.DetailFragment;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.tubes3.R;
import com.example.tubes3.adapter.ListAdapterTopAlbum;
import com.example.tubes3.fragmentView.homepage;
import com.example.tubes3.presenter.presenterArtis;
import com.example.tubes3.presenter.presenterSong;

public class detail extends Fragment implements View.OnClickListener{
    public static TextView artisl;
    public static  TextView descl;
    private ImageView gambar;
    private ImageView gambar2;
    private String img;
    private RatingBar rate;
    private Button but;
    private int pos;
    public static detail newInstance(){
       detail fragment1 = new detail();
        return fragment1;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
       View view = inflater.inflate(R.layout.detail,container,false);
        this.artisl=view.findViewById(R.id.judullagu);
        this.descl=view.findViewById(R.id.deskripsi);
        this.artisl.setText(homepage.artis);
        this.descl.setText(homepage.desc );
        this.gambar=view.findViewById(R.id.gambar_artis);
        this.gambar2=view.findViewById(R.id.gambar);
        this.rate=view.findViewById(R.id.rating);
        this.but=view.findViewById(R.id.rat);
        but.setOnClickListener(this);
        for(int i=0;i< presenterArtis.getTotalSize();i++){
            if(presenterArtis.getArtis(i).equals(homepage.artis)){
                this.img=presenterArtis.getimage(i);
                this.pos=i;
                break;
            }
        }

        this.descl.setText(homepage.desc +" mempunyai rating "+presenterArtis.getrating(pos));
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            this.gambar.setImageBitmap(ListAdapterTopAlbum.getBitmapFromURL(img));

            this.gambar2.setImageBitmap(ListAdapterTopAlbum.getBitmapFromURL(img));
        }


        return view;
    }


    @Override
    public void onClick(View v) {
        if(v==this.but){
            for(int i=0;i< presenterArtis.getTotalSize();i++){
                if(presenterArtis.getArtis(i).equals(artisl.getText().toString())){
                    presenterArtis.setRating(i,rate.getRating()+presenterArtis.getrating(i)/2);
                    rate.setRating(0);
                    rate.setVisibility(View.GONE);
                    this.descl.setText(homepage.desc +" mempunyai rating "+presenterArtis.getrating(i));
                    break;
                }
            }

        }
    }
}
