package com.example.tubes3.webService;

import android.os.AsyncTask;
import android.util.Log;

import com.example.tubes3.presenter.presenterAlbum;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchData extends AsyncTask<Void,Void,Void> {
    String data ="";
    String dataParsed = "";
    String singleParsed ="";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("http://musicbrainz.org/ws/2/artist/a74b1b7f-71a5-4011-9441-d0b5e4122711?inc=release-groups&fmt=json");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONObject JA = new JSONObject(data);
            JSONArray JA2 =JA.getJSONArray("release-groups");
            String artis = JA.getString("name");
            for(int i =0 ;i < JA2.length(); i++){
                JSONObject JO = (JSONObject) JA2.get(i);
                singleParsed = (String) JO.get("title");
                addAlbum(artis, JO.getString("title"), 0, 0, "", JO.getString("first-release-date"),false);

                dataParsed = dataParsed + singleParsed  ;


            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        Log.d("TAG", "onPostExecute: "+dataParsed);

    }

    public static void addAlbum(String artis, String album,int rating,int listen,String desc,String release,boolean isi){
        presenterAlbum.addToList( artis,  album,rating, listen, desc, release,isi);
    }

}