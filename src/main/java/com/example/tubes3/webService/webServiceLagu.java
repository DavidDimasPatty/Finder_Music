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

public class webServiceLagu {

    public webServiceLagu(){


    }

    public static  void jsonParse() {
        ArrayList<String> urllist = new ArrayList<>();
        ArrayList<RequestQueue> mque = new ArrayList<>();
        ArrayList<String> artislis= new ArrayList<>();
        ArrayList<JsonObjectRequest> req = new ArrayList<>();
        String url = "http://musicbrainz.org/ws/2/release/be5375c6-38aa-4258-a11d-30d9fde88383?inc=recordings&fmt=json";
        String url2 = "http://musicbrainz.org/ws/2/release/9193f3bc-ef31-3b9c-a778-3feffcfc33c8?inc=recordings&fmt=json";
        String url3 = "http://musicbrainz.org/ws/2/release/3c623574-f027-3b61-b232-4fa99ef0e8ee?inc=recordings&fmt=json";
        String url4 = "http://musicbrainz.org/ws/2/release/435fc965-9121-461e-b8da-d9b505c9dc9b?inc=recordings&fmt=json";
        artislis.add("Snoop Dogg");
        artislis.add("Wiz Khalifa");
        artislis.add("Radiohead");
        artislis.add("Coldplay");

        urllist.add(url);

        urllist.add(url2);

        urllist.add(url3);

        urllist.add(url4);

        mque.add(MainActivity.mQueue6);

        mque.add(MainActivity.mQueue7);

        mque.add(MainActivity.mQueue8);

        mque.add(MainActivity.mQueue9);


        Log.d("TAG", "jsonParse: "+urllist.size());

        for (int i = 0; i < urllist.size(); i++) {
            final String artisa=artislis.get(i);
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, urllist.get(i), null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                            try {

                                JSONArray jsonarray =response.getJSONArray("media") ;

                                for (int i = 0; i < jsonarray.length(); i++) {
                                    JSONObject obj1 = jsonarray.getJSONObject(i);
                                    JSONArray details = obj1.getJSONArray("tracks");
                                    for (int j = 0; j < details.length(); j++) {

                                        JSONObject obj2 = details.getJSONObject(j);
                                        JSONObject details2 = obj2.getJSONObject("recording");

                                        for (int k = 0; k < details.length(); k++) {

                                        JSONObject song = details.getJSONObject(k);
                                        addsong(song.getString("title"),artisa, "", 0, 0);

                                        }
                                        break;
                                    }
                                    break;
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

    }

    public static void addsong (String nama, String artis, String album,int rating,int listen){
        presenterSong.addToList(nama, artis, album, rating,listen);}


    }





