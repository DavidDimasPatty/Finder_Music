package com.example.tubes3.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tubes3.Model.albumdata;
import com.example.tubes3.R;
import com.example.tubes3.presenter.presenter;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListAdapterTopAlbum extends BaseAdapter {
    private Activity activity;
    private ArrayList<albumdata> ListAdapterTopAlbum ;
    private TextView tvNama;
    private TextView score;
    private CircleImageView image;

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
        //this.image=v.findViewById(R.id.imagee);
        this.tvNama.setText(this.ListAdapterTopAlbum .get(position).getAlbum());
        this.score.setText(this.ListAdapterTopAlbum .get(position).getArtis());
        return v;
    }

    public void add(String artis, String album,int rating,int listen,String desc,String release){
        this.ListAdapterTopAlbum .add(new albumdata( artis,album,rating, listen, desc,release));
        this.notifyDataSetChanged();
    }

    public void delete(int position){
        updatePresenter(position);
        this.ListAdapterTopAlbum .remove(position);
        this.notifyDataSetChanged();
    }

    public static void updatePresenter(int position){
        presenter.remove(position);
    }

}
