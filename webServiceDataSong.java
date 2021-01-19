package com.example.tubes3.webService;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.tubes3.MainActivity;
import com.example.tubes3.presenter.presenterAlbum;
import com.example.tubes3.presenter.presenterSong;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class webServiceDataSong {
    public webServiceDataSong(){


    }

    public static  void jsonParse() {
        ArrayList<String> urllist = new ArrayList<>();
        ArrayList<RequestQueue> mque = new ArrayList<>();

        ArrayList< JsonObjectRequest> req = new ArrayList<>();
        String url2 = "http://musicbrainz.org/ws/2/artist/f5dfa020-ad69-41cd-b3d4-fd7af0414e94?inc=release-groups&fmt=json";

        String url3 = "http://musicbrainz.org/ws/2/artist/f90e8b26-9e52-4669-a5c9-e28529c47894?inc=release-groups&fmt=json";

        String url4 = "http://musicbrainz.org/ws/2/artist/cc197bad-dc9c-440d-a5b5-d52ba2e14234?inc=release-groups&fmt=json";

        urllist.add(url2);
        urllist.add(url3);
        urllist.add(url4);

        mque.add(MainActivity.mQueue2);

        mque.add(MainActivity.mQueue3);

        mque.add(MainActivity.mQueue4);

        mque.add(MainActivity.mQueue5);

        Log.d("TAG", "jsonParse: "+urllist.size());

        for (int i = 0; i < urllist.size(); i++) {
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, urllist.get(i), null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {

                                JSONArray jsonArray = response.getJSONArray("release-groups");

                                String artis = response.getString("name");
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject song = jsonArray.getJSONObject(i);
                                    addAlbum(artis, song.getString("title"), 0, 0, "", song.getString("first-release-date"),false);

                                     }
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

        Log.d("TAG", "onCreate: "+presenterSong.getTotalSize());
    }



    public static void addAlbum(String artis, String album,int rating,int listen,String desc,String release,boolean isi){
        presenterAlbum.addToList( artis,  album,rating, listen, desc, release,isi);
    }


}
