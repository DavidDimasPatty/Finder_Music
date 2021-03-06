package com.example.tubes3.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tubes3.Model.songdata;
import com.example.tubes3.R;
import com.example.tubes3.presenter.presenter;
import com.example.tubes3.presenter.presenterArtis;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListAdapterDetailAlbum extends BaseAdapter {
    private Activity activity;
    private ArrayList<songdata> ListAdapterDetailAlbum;
    private TextView tvNama;
    private TextView score;
    private String urg="";

    private CircleImageView image;

    public ListAdapterDetailAlbum(Activity activity){
        this.activity = activity;
        this.ListAdapterDetailAlbum = new ArrayList<songdata>();
    }

    @Override
    public int getCount() {
        return this.ListAdapterDetailAlbum.size();
    }

    @Override
    public Object getItem(int position) {
        return this.ListAdapterDetailAlbum.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        if(convertView == null){
            v = this.activity.getLayoutInflater().inflate(R.layout.listviewkotak, null);
        }
        else{
            v = convertView;
        }
        this.tvNama = v.findViewById(R.id.textView2);
        this.score=v.findViewById(R.id.textView3);

        this.image=v.findViewById(R.id.imagee);
        this.tvNama.setText(this.ListAdapterDetailAlbum.get(position).getNama());
        this.score.setText(this.ListAdapterDetailAlbum.get(position).getArtis());
        this.urg="";
        for(int i=0;i< presenterArtis.getTotalSize();i++){
            if(this.ListAdapterDetailAlbum.get(position).getArtis().equals(presenterArtis.getArtis(i))){
                this.urg=presenterArtis.getimage(i);
                break;
            }
        }

        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            this.image.setImageBitmap(getBitmapFromURL(urg));
        }
        return v;
    }

    public void add(String nama, String artis, String album,float rating,int listen){
        this.ListAdapterDetailAlbum.add(new songdata( nama,  artis, album, rating, listen));
        this.notifyDataSetChanged();
    }

    public void delete(int position){
        updatePresenter(position);
        this.ListAdapterDetailAlbum.remove(position);
        this.notifyDataSetChanged();
    }

    public static void updatePresenter(int position){
        presenter.remove(position);
    }
    public static Bitmap getBitmapFromURL(String src) {

        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            // Log exception
            return null;
        }
    }
}
