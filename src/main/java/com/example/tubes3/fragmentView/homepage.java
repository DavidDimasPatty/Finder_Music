package com.example.tubes3.fragmentView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tubes3.FragmentListener;
import com.example.tubes3.MainActivity;
import com.example.tubes3.R;
import com.example.tubes3.adapter.ListAdapter;
import com.example.tubes3.adapter.ListAdapterTopAlbum;
import com.example.tubes3.adapter.RecyclerViewAdapter;
import com.example.tubes3.presenter.presenter;
import com.example.tubes3.presenter.presenterAlbum;
import com.example.tubes3.presenter.presenterArtis;
import com.example.tubes3.presenter.presenterHistory;

import java.util.ArrayList;

public class homepage  extends Fragment{
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private RecyclerView recyclerView;
    private View view;
    private FragmentListener listener;
    private ListAdapter adapter2;
    private ListView list;
    private ListAdapterTopAlbum lat;
   public static String artis;
    public static String desc;

    public static String judulAlbum;
    public static String descAlbum;

    private ListView la;

    public static homepage newInstance(){
        homepage fragment1 = new homepage();
        return fragment1;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
       this.view = inflater.inflate(R.layout.homepage,container,false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false);
        this.recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this.getContext(), mNames, mImageUrls);
        recyclerView.setAdapter(adapter);

        mImageUrls.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        mNames.add("Havasu Falls");

        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Trondheim");

        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Portugal");

        mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        mNames.add("Rocky Mountain National Park");


        mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mNames.add("Mahahual");

        mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        mNames.add("Frozen Lake");


        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        mNames.add("White Sands Desert");

        mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        mNames.add("Austrailia");

        mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        mNames.add("Washington");


        this.adapter2 = new ListAdapter((MainActivity) getActivity());
        this.list = view.findViewById(R.id.topsong);

        this.lat = new ListAdapterTopAlbum((MainActivity) getActivity());
        this.la = view.findViewById(R.id.topalbum);




        for(int i = 0; i < presenterArtis.getTotalSize() ; i++){

            this.adapter2.add(presenterArtis.getArtis(i),presenterArtis.getrating(i), presenterArtis.getlisten(i),presenterArtis.getdesc(i),presenterArtis.getimage(i));

        }

        for(int i = 0; i < presenterAlbum.getTotalSize() ; i++){

            this.lat.add(presenterAlbum.getArtis(i), presenterAlbum.getAlbum(i), presenterAlbum.getrating(i), presenterAlbum.getlisten(i), presenterAlbum.getdesc(i),presenterAlbum.getrelease(i));
        }
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               artis=presenterArtis.getArtis(position);
                desc=presenterArtis.getdesc(position);
                listener.changePage(2);
            }
        });

        la.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                judulAlbum=presenterAlbum.getAlbum(position);
                descAlbum=presenterAlbum.getdesc(position);
                listener.changePage(15);
            }
        });
        this.list.setAdapter(this.adapter2);
        this.la.setAdapter(this.lat);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof  FragmentListener){
            this.listener = (FragmentListener) context;
        } else{
            throw new ClassCastException(context.toString()
                    + " must implement FragmentListener");
        }
    }


}

