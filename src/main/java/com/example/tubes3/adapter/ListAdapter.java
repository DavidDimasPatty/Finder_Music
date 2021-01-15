package com.example.tubes3.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tubes3.Model.artistdata;
import com.example.tubes3.R;
import com.example.tubes3.presenter.presenter;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<artistdata> ListAdapter;
    private TextView tvNama;
    private TextView score;
    private CircleImageView image;

    public ListAdapter(Activity activity){
        this.activity = activity;
        this.ListAdapter = new ArrayList<artistdata>();
    }

    @Override
    public int getCount() {
        return this.ListAdapter.size();
    }

    @Override
    public Object getItem(int position) {
        return this.ListAdapter.get(position);
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
        this.tvNama.setText(this.ListAdapter.get(position).getArtis());
        this.score.setText(Integer.toString(this.ListAdapter.get(position).getListen()));
        return v;
    }

    public void add(String artis,int rating,int listen,String desc,String gambar){
        this.ListAdapter.add(new artistdata( artis,rating, listen, desc, gambar));
        this.notifyDataSetChanged();
    }

    public void delete(int position){
        updatePresenter(position);
        this.ListAdapter.remove(position);
        this.notifyDataSetChanged();
    }

    public static void updatePresenter(int position){
        presenter.remove(position);
    }

}