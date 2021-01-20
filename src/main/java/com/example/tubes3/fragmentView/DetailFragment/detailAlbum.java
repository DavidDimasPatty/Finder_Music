package com.example.tubes3.fragmentView.DetailFragment;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.tubes3.FragmentListener;
import com.example.tubes3.MainActivity;
import com.example.tubes3.R;
import com.example.tubes3.adapter.ListAdapter2;
import com.example.tubes3.adapter.ListAdapterDetailAlbum;
import com.example.tubes3.adapter.ListAdapterTopAlbum;
import com.example.tubes3.fragmentView.homepage;
import com.example.tubes3.fragmentView.login;
import com.example.tubes3.presenter.presenterAlbum;
import com.example.tubes3.presenter.presenterArtis;
import com.example.tubes3.presenter.presenterHistory;
import com.example.tubes3.presenter.presenterSong;

public class detailAlbum extends Fragment {
    private  TextView judulAlbum;
    private  TextView descAlbum;
    private ListView song;
    private FragmentListener listener;
    public static String song2="";
    public static  String artis="";
    private ImageView img;

    private ListAdapterDetailAlbum adapter;

    public static detailAlbum newInstance(){
        detailAlbum fragment1 = new detailAlbum();
        return fragment1;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.detail_album,container,false);
        this.judulAlbum=view.findViewById(R.id.songal);
        this.judulAlbum.setText(homepage.judulAlbum);
        this.img=view.findViewById(R.id.bgal);
        for(int i=0;i< presenterAlbum.getTotalSize();i++) {
                if(presenterAlbum.getAlbum(i).equals(homepage.judulAlbum)) {
                    this.img.setImageBitmap(ListAdapterTopAlbum.getBitmapFromURL(presenterAlbum.getimage(i)));

                }
        }

        this.adapter = new ListAdapterDetailAlbum((MainActivity) getActivity());
        this.song = view.findViewById(R.id.libal);
        this.song.setAdapter(this.adapter);
        for(int i = 0; i < presenterSong.getTotalSize() ; i++){
            if(presenterSong.getAlbum(i)==homepage.judulAlbum) {
                this.adapter.add(presenterSong.getNama(i), presenterSong.getArtis(i), presenterSong.getAlbum(i), presenterSong.getrating(i), presenterSong.getlisten(i));
            }
        }
        this.song.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final TextView tv_id = (TextView) view.findViewById(R.id.textView2);
                String txt = tv_id.getText().toString();
                presenterHistory.addToList(login.usernamelog,txt);
                song2= txt;
                listener.changePage(16);
            }
        });

        Log.d("TAG", "onCreateView: "+presenterHistory.getTotalSize());
        Log.d("TAG", "onCreateView: "+presenterSong.getTotalSize());
        return view;
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
