package com.example.tubes3.fragmentView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.tubes3.FragmentListener;
import com.example.tubes3.MainActivity;
import com.example.tubes3.R;
import com.example.tubes3.adapter.ListAdapter2;
import com.example.tubes3.adapter.RecyclerViewAdapter;
import com.example.tubes3.presenter.presenterArtis;
import com.example.tubes3.presenter.presenterHistory;
import com.example.tubes3.presenter.presenterSong;

public class listsong extends Fragment {
    private  FragmentListener listener;
    private ListAdapter2 adapter;
    private ListView list;
    private TextView judul;
    public static String songdari;

    public static listsong newInstance(){
        listsong fragment1 = new listsong();
        return fragment1;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.listsong,container,false);
        this.list = view.findViewById(R.id.listsongg);
        this.adapter = new ListAdapter2((MainActivity) getActivity());
        this.judul=view.findViewById(R.id.listsongjudul);
        this.judul.setText(homepage.dm);
        this.list.setAdapter(this.adapter);

        for(int i = 0; i < presenterSong.getTotalSize() ; i++){
            if(presenterSong.getArtis(i).equals(homepage.leak)) {
                this.adapter.add(presenterSong.getNama(i), presenterSong.getArtis(i), presenterSong.getAlbum(i), presenterSong.getrating(i), presenterSong.getlisten(i));

            }
            }
        Log.d("TAG", "onCreateView: "+presenterSong.getTotalSize());
        this.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final TextView tv_id = (TextView) view.findViewById(R.id.textView2);
                String txt = tv_id.getText().toString();
                songdari=txt;
                presenterHistory.addToList(login.usernamelog,songdari);
              listener.changePage(16);
            }
        });

        return view;
    }
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentListener) {
            this.listener = (FragmentListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement FragmentListener");
        }
    }

}
