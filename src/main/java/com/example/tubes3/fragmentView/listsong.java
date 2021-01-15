package com.example.tubes3.fragmentView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.tubes3.MainActivity;
import com.example.tubes3.R;
import com.example.tubes3.adapter.ListAdapter2;
import com.example.tubes3.presenter.presenterArtis;
import com.example.tubes3.presenter.presenterHistory;
import com.example.tubes3.presenter.presenterSong;

public class listsong extends Fragment {

    private ListAdapter2 adapter;
    private ListView list;

    public static listsong newInstance(){
        listsong fragment1 = new listsong();
        return fragment1;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.listsong,container,false);
        this.list = view.findViewById(R.id.listsongg);
        this.adapter = new ListAdapter2((MainActivity) getActivity());

        this.list.setAdapter(this.adapter);

        for(int i = 0; i < presenterSong.getTotalSize() ; i++){

            this.adapter.add(presenterSong.getNama(i),presenterSong.getArtis(i),  presenterSong.getAlbum(i), presenterSong.getrating(i), presenterSong.getlisten(i), presenterSong.getdesc(i), presenterSong.getrelease(i));
            Log.d("TAG", "onCreateView: ");
        }

        this.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                presenterHistory.addToList(login.usernamelog,presenterSong.getNama(position));
            }
        });

        return view;
    }


}
