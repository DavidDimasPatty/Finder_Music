package com.example.tubes3.webService;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.tubes3.MainActivity;
import com.example.tubes3.presenter.presenterAlbum;
import com.example.tubes3.presenter.presenterArtis;
import com.example.tubes3.presenter.presenterSong;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class webServiceArtis {

    public webServiceArtis(){


    }

    public static  void jsonParse() {
        ArrayList<String> urllist = new ArrayList<>();
        ArrayList<RequestQueue> mque = new ArrayList<>();

        ArrayList<JsonObjectRequest> req = new ArrayList<>();
        String url = "http://musicbrainz.org/ws/2/artist/a74b1b7f-71a5-4011-9441-d0b5e4122711?inc=release-groups&fmt=json";
        String url2 = "http://musicbrainz.org/ws/2/artist/f5dfa020-ad69-41cd-b3d4-fd7af0414e94?inc=release-groups&fmt=json";

        String url3 = "http://musicbrainz.org/ws/2/artist/f90e8b26-9e52-4669-a5c9-e28529c47894?inc=release-groups&fmt=json";

        String url4 = "http://musicbrainz.org/ws/2/artist/cc197bad-dc9c-440d-a5b5-d52ba2e14234?inc=release-groups&fmt=json";
        urllist.add(url);
        urllist.add(url2);
        urllist.add(url3);
        urllist.add(url4);

        mque.add(MainActivity.mQueue10);

        mque.add(MainActivity.mQueue11);

        mque.add(MainActivity.mQueue12);

        mque.add(MainActivity.mQueue13);

        Log.d("TAG", "jsonParse: "+urllist.size());

        for (int i = 0; i < urllist.size(); i++) {
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, urllist.get(i), null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {




                                JSONObject song = response.getJSONObject("begin-area");
                                String artis = response.getString("name");

                                   add(artis,0,0, artis+" adalah "+response.getString("type")+" yang berasal dari "+song.getString("sort-name"),"");


                                  } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {


                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                    Log.d("TAG", "onErrorResponse: " + "error");
                }
            });
            mque.get(i).add(request);

        }

        Log.d("TAG", "onCreate: "+ presenterSong.getTotalSize());
    }



    public static void add(String artis,int rating,int listen,String desc,String gambar){
        presenterArtis.addToList( artis, rating, listen,desc, gambar);
    }

}
