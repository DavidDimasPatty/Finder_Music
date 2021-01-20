package com.example.tubes3.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tubes3.Model.albumdata;
import com.example.tubes3.R;
import com.example.tubes3.presenter.presenter;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListAdapterTopAlbum extends BaseAdapter {
    private Activity activity;
    private ArrayList<albumdata> ListAdapterTopAlbum ;
    private TextView tvNama;
    private TextView score;
    private CircleImageView image;
private Bitmap gambar;

    public ListAdapterTopAlbum(Activity activity){
        this.activity = activity;
        this.ListAdapterTopAlbum  = new ArrayList<albumdata>();
    }

    @Override
    public int getCount() {
        return this.ListAdapterTopAlbum .size();
    }

    @Override
    public Object getItem(int position) {
        return this.ListAdapterTopAlbum .get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
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
        this.tvNama.setText(this.ListAdapterTopAlbum .get(position).getAlbum());
        this.score.setText(this.ListAdapterTopAlbum .get(position).getArtis());

        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            this.image.setImageBitmap(getBitmapFromURL(this.ListAdapterTopAlbum .get(position).getimage()));
        }


        return v;
    }

    public void add(String artis, String album,int rating,int listen,String desc,String release,boolean isi,String image){
        this.ListAdapterTopAlbum .add(new albumdata( artis,album,rating, listen, desc,release,isi,image));
        this.notifyDataSetChanged();
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
