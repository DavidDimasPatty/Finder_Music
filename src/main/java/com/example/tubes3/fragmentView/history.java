package com.example.tubes3.fragmentView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.tubes3.MainActivity;
import com.example.tubes3.R;
import com.example.tubes3.adapter.ListAdapter2;
import com.example.tubes3.presenter.presenterHistory;
import com.example.tubes3.presenter.presenterSong;

public class history extends Fragment {
    private ListView list;
    private ListAdapter2 adapter;

    public static history newInstance(){
        history fragment1 = new history();
        return fragment1;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.history,container,false);
        this.list=view.findViewById(R.id.listhistory);
        this.adapter = new ListAdapter2((MainActivity) getActivity());

        for(int i = 0; i < presenterHistory.getTotalSize() ; i++){
                if(presenterHistory.getUser(i).equals(login.usernamelog)){
                    for(int j = 0; j < presenterSong.getTotalSize() ; j++){
                            if(presenterHistory.getSong(i).equals(presenterSong.getNama(j))) {
                                Log.d("TAG", "onCreateView: "+presenterHistory.getSong(i)+presenterSong.getNama(j));

                                this.adapter.add(presenterSong.getNama(j),presenterSong.getArtis(j),  presenterSong.getAlbum(j), presenterSong.getrating(j), presenterSong.getlisten(j), presenterSong.getdesc(j), presenterSong.getrelease(j));
                                break;
                            }
                            }
                       }
                }

        this.list.setAdapter(this.adapter);
        return view;

}

}
