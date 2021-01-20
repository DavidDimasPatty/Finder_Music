package com.example.tubes3.fragmentView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tubes3.FragmentListener;
import com.example.tubes3.MainActivity;
import com.example.tubes3.R;
import com.example.tubes3.adapter.ListAdapter;
import com.example.tubes3.adapter.ListAdapterTopAlbum;
import com.example.tubes3.adapter.ListAdapterTopArtist;
import com.example.tubes3.adapter.RecyclerViewAdapter;
import com.example.tubes3.presenter.presenter;
import com.example.tubes3.presenter.presenterAlbum;
import com.example.tubes3.presenter.presenterArtis;
import com.example.tubes3.presenter.presenterHistory;
import com.example.tubes3.presenter.presenterSong;
import com.example.tubes3.webService.fetchData;

import java.util.ArrayList;

public class homepage  extends Fragment implements View.OnClickListener {
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private RecyclerView recyclerView;
    private View view;
    private FragmentListener listener;
    private ListAdapterTopArtist adapter2;
    private ListView list;
    private ListAdapterTopAlbum lat;
    public static String artis;
    public static String desc;
    public static String dm;
    public static String leak;

    public static String judulAlbum;
    public static String descAlbum;

    public static String imageal;

    private ListView la;

    public static homepage newInstance() {
        homepage fragment1 = new homepage();
        return fragment1;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.homepage, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false);
        this.recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this.getContext(), mNames, mImageUrls);
        recyclerView.setAdapter(adapter);

        recyclerView.setOnClickListener(this);

        MainActivity.bottomNav.setVisibility(View.VISIBLE);
        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Relax");

        mImageUrls.add("https://pbs.twimg.com/media/EB8eNtUUcAEId_R.jpg");
        mNames.add("Rap");

        mImageUrls.add("data:image/jpeg;base64,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");
        mNames.add("Rock");





        albumsong();
        this.adapter2 = new ListAdapterTopArtist((MainActivity) getActivity());
        this.list = view.findViewById(R.id.topsong);

        this.lat = new ListAdapterTopAlbum((MainActivity) getActivity());
        this.la = view.findViewById(R.id.topalbum);


        Log.d("TAG", "onCreate: " + presenterSong.getAlbum(0));

        Log.d("TAG", "lagu: " + presenterSong.getTotalSize());

        Log.d("TAG", "album: " + presenterAlbum.getTotalSize());

        for (int i = 0; i < presenterArtis.getTotalSize(); i++) {

            this.adapter2.add(presenterArtis.getArtis(i), presenterArtis.getrating(i), presenterArtis.getlisten(i), presenterArtis.getdesc(i), presenterArtis.getimage(i));

        }

        for (int i = 0; i < presenterAlbum.getTotalSize(); i++) {
            if (presenterAlbum.getadaisi(i) == true) {
                this.lat.add(presenterAlbum.getArtis(i), presenterAlbum.getAlbum(i), presenterAlbum.getrating(i), presenterAlbum.getlisten(i), presenterAlbum.getdesc(i), presenterAlbum.getrelease(i), presenterAlbum.getadaisi(i),presenterAlbum.getimage(i));
            }
        }
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                artis = presenterArtis.getArtis(position);
                desc = presenterArtis.getdesc(position);
                listener.changePage(2);
            }
        });

        la.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final TextView tv_id = (TextView) view.findViewById(R.id.textView2);
                String txt = tv_id.getText().toString();
                judulAlbum = txt;
                listener.changePage(15);


            }
        });
        this.list.setAdapter(this.adapter2);
        this.la.setAdapter(this.lat);
        Log.d("TAG", "onCreate: " + presenterSong.getNama(0));

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentListener) {
            this.listener = (FragmentListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement FragmentListener");
        }
    }


    @Override
    public void onClick(View v) {
        if (v == this.recyclerView) {
            int itemPosition = recyclerView.getChildLayoutPosition(view);
            listener.changePage(15);
            Log.d("TAG", "onClick: " + "tes");
        }
    }

    public static void albumsong() {
        Log.d("TAG", "albumsong: " + presenterSong.getTotalSize());
        for (int i = 0; i < presenterSong.getTotalSize(); i++) {
            if (presenterSong.getArtis(i).equals("Wiz Khalifa")) {
                int j = 0;
                for (j = 0; j < presenterAlbum.getTotalSize(); j++) {
                    if (presenterAlbum.getArtis(j).equals("Wiz Khalifa")) {
                        presenterSong.setAlbum(i, presenterAlbum.getAlbum(j));
                        presenterAlbum.setadaisi(j, true);
                        break;
                    }
                }
                j++;
            }
            if (presenterSong.getArtis(i).equals("Snoop Dogg")) {
                int j = 0;
                for (j = 0; j < presenterAlbum.getTotalSize(); j++) {
                    if (presenterAlbum.getArtis(j).equals("Snoop Dogg")) {
                        presenterSong.setAlbum(i, presenterAlbum.getAlbum(j));
                        presenterAlbum.setadaisi(j, true);
                        break;
                    }
                }
                j++;
            }
            if (presenterSong.getArtis(i).equals("Radio Head")) {
                int j = 0;
                for (j = 0; j < presenterAlbum.getTotalSize(); j++) {
                    if (presenterAlbum.getArtis(j).equals("Radio Head")) {
                        presenterSong.setAlbum(i, presenterAlbum.getAlbum(j));
                        presenterAlbum.setadaisi(j, true);
                        break;
                    }
                }
                j++;
            }
            if (presenterSong.getArtis(i).equals("Coldplay")) {
                int j = 0;
                for (j = 0; j < presenterAlbum.getTotalSize(); j++) {
                    if (presenterAlbum.getArtis(j).equals("Coldplay")) {
                        presenterSong.setAlbum(i, presenterAlbum.getAlbum(j));
                        presenterAlbum.setadaisi(j, true);
                        break;
                    }
                }
                j++;
            }
        }
    }
}



