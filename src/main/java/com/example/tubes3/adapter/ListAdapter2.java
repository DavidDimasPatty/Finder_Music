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
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListAdapter2 extends BaseAdapter {
    private Activity activity;
    private ArrayList<songdata> ListAdapter2;
    private TextView tvNama;
    private TextView score;
    private CircleImageView image;

    private String urg="";

    public ListAdapter2(Activity activity) {
        this.activity = activity;
        this.ListAdapter2 = new ArrayList<songdata>();
    }

    @Override
    public int getCount() {
        return this.ListAdapter2.size();
    }

    @Override
    public Object getItem(int position) {
        return this.ListAdapter2.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        if (convertView == null) {
            v = this.activity.getLayoutInflater().inflate(R.layout.listviewkotak, null);
        } else {
            v = convertView;
        }
        this.tvNama = v.findViewById(R.id.textView2);
        this.score = v.findViewById(R.id.textView3);

        this.image=v.findViewById(R.id.imagee);
        this.tvNama.setText(this.ListAdapter2.get(position).getNama());
        this.score.setText(this.ListAdapter2.get(position).getArtis());
        this.urg="";
        for(int i = 0; i< presenterArtis.getTotalSize(); i++){
            if(this.ListAdapter2.get(position).getArtis().equals(presenterArtis.getArtis(i))){
                this.urg=presenterArtis.getimage(i);
                Log.d("TAG", "urg: "+urg);
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

    public void add(String nama, String artis, String album,float rating, int listen) {
        this.ListAdapter2.add(new songdata(nama, artis, album, rating, listen));
        this.notifyDataSetChanged();
    }

    public void delete(int position) {
        updatePresenter(position);
        this.ListAdapter2.remove(position);
        this.notifyDataSetChanged();
    }

    public static void updatePresenter(int position) {
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
