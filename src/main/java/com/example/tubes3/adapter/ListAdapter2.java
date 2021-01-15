package com.example.tubes3.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tubes3.Model.songdata;
import com.example.tubes3.R;
import com.example.tubes3.presenter.presenter;

import java.util.ArrayList;
import java.util.Locale;

public class ListAdapter2 extends BaseAdapter {
    private Activity activity;
    private ArrayList<songdata> ListAdapter2;
    private TextView tvNama;
    private TextView score;

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
        this.tvNama.setText(this.ListAdapter2.get(position).getNama());
        this.score.setText(this.ListAdapter2.get(position).getArtis());
        return v;
    }

    public void add(String nama, String artis, String album, int rating, int listen, String desc, String release) {
        this.ListAdapter2.add(new songdata(nama, artis, album, rating, listen, desc, release));
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

}
