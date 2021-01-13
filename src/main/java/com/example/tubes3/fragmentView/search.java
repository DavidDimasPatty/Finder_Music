package com.example.tubes3.fragmentView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.tubes3.MainActivity;
import com.example.tubes3.R;
import com.example.tubes3.adapter.ListAdapter2;
import com.example.tubes3.presenter.presenterSong;

import java.util.ArrayList;

public class search extends Fragment implements View.OnClickListener{
    private ListAdapter2 adapter;
    private ListView list;
    private EditText edit;
    private Button search;
    private ArrayAdapter adapter2;
    private ArrayList <String>  listsearch;
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

        this.adapter = new ListAdapter2((MainActivity) getActivity());
        this.list = view.findViewById(R.id.cari);
        this.edit=view.findViewById(R.id.searching);
        this.search=view.findViewById(R.id.butsearch);
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
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v==this.search){

            for(int i = 0; i < presenterSong.getTotalSize() ; i++){
                if(this.edit.getText().toString().equals(presenterSong.getNama(i))) {
                    this.adapter.add(presenterSong.getNama(i), presenterSong.getArtis(i), presenterSong.getAlbum(i), presenterSong.getrating(i), presenterSong.getlisten(i), presenterSong.getdesc(i), presenterSong.getrelease(i));
                    Log.d("TAG", "onCreateView: ");
                }
                }

            this.list.setAdapter(this.adapter);
            this.adapter.notifyDataSetChanged();
        }
    }
}
