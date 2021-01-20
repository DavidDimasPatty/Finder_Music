package com.example.tubes3.webService;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.tubes3.MainActivity;
import com.example.tubes3.presenter.presenterSong;
import com.example.tubes3.presenter.presenterUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class musicbrainzService {

    public musicbrainzService(){


    }

    public static  void jsonParse() {

        String url = "http://www.json-generator.com/api/json/get/cezkODuqeW?indent=2";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("user");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject song = jsonArray.getJSONObject(i);
                                addUser(Integer.parseInt(song.getString("id")),song.getString("username"),song.getString("password"),song.getString("email"),song.getString("phone"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.d("TAG", "onErrorResponse: "+"error");
            }
        });
        MainActivity.mQueue.add(request);
    }


    public static void addUser(int id,String username,String password,String email,String phone){
        presenterUser.addToList(id,username,  password, email, phone);
    }

}
