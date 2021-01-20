package com.example.tubes3.fragmentView;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.tubes3.FragmentListener;
import com.example.tubes3.MainActivity;
import com.example.tubes3.R;
import com.example.tubes3.adapter.ListAdapter2;
import com.example.tubes3.presenter.presenterArtis;
import com.example.tubes3.presenter.presenterHistory;
import com.example.tubes3.presenter.presenterSong;

import java.util.ArrayList;

public class search extends Fragment implements View.OnClickListener{
    private ListAdapter2 adapter;
    private ListView list;
    private EditText edit;
    private Button search;
    private ArrayAdapter adapter2;
    private ArrayList <String>  listsearch;
    private ImageView clear;
    public static String song="";
    public static  String artis="";
    private  FragmentListener listener;
    public static search newInstance(){
        search fragment1 = new search();
        return fragment1;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.search,container,false);

            this.listsearch=new ArrayList<>();

        for(int i = 0; i < presenterSong.getTotalSize() ; i++){

           listsearch.add(presenterSong.getNama(i));

        }
        Log.d("TAG", "onCreateView: "+presenterSong.getTotalSize());
        this.adapter = new ListAdapter2((MainActivity) getActivity());
        this.list = view.findViewById(R.id.cari);
        this.edit=view.findViewById(R.id.searching);
        this.clear=view.findViewById(R.id.backsearch);
        this.clear.setOnClickListener(this);
        adapter2=new ArrayAdapter(getContext(),R.layout.list_view, R.id.text10,listsearch);
        Log.d("TAG", Integer.toString(listsearch.size()));

        this.list.setAdapter(this.adapter2);
        this.edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
              adapter2.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final TextView tv_id = (TextView) view.findViewById(R.id.text10);
                String txt = tv_id.getText().toString();
                presenterHistory.addToList(login.usernamelog,txt);
               for(int i=0;i<presenterSong.getTotalSize();i++) {
                   if(presenterSong.getNama(i)==txt) {
                       song = presenterSong.getNama(i);
                   break;
                   }
               }
                listener.changePage(16);
            }
        });
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v==this.search){

            for(int i = 0; i < presenterSong.getTotalSize() ; i++){
                if(this.edit.getText().toString().equals(presenterSong.getNama(i))) {
                    this.adapter.add(presenterSong.getNama(i), presenterSong.getArtis(i), presenterSong.getAlbum(i), presenterSong.getrating(i), presenterSong.getlisten(i));
                    Log.d("TAG", "onCreateView: ");
                }
                }

            this.list.setAdapter(this.adapter);
            this.adapter.notifyDataSetChanged();
        }

        if(v==this.clear){
            this.edit.setText("");
        }
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
