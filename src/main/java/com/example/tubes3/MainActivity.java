package com.example.tubes3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.tubes3.fragmentView.DetailFragment.detail;
import com.example.tubes3.fragmentView.DetailFragment.detailAlbum;
import com.example.tubes3.fragmentView.DetailFragment.detailSong;
import com.example.tubes3.fragmentView.dialog.dialog_ganti_password;
import com.example.tubes3.fragmentView.dialog.dialog_ganti_pp;
import com.example.tubes3.fragmentView.dialog.dialog_ganti_warna;
import com.example.tubes3.fragmentView.history;
import com.example.tubes3.fragmentView.homepage;
import com.example.tubes3.fragmentView.listsong;
import com.example.tubes3.fragmentView.login;
import com.example.tubes3.fragmentView.profile;
import com.example.tubes3.fragmentView.search;
import com.example.tubes3.fragmentView.setting;
import com.example.tubes3.fragmentView.signup;
import com.example.tubes3.fragmentView.topalbum;
import com.example.tubes3.fragmentView.topsong;
import com.example.tubes3.presenter.presenterArtis;
import com.example.tubes3.presenter.presenterUser;
import com.example.tubes3.webService.fetchData;
import com.example.tubes3.webService.musicbrainzService;
import com.example.tubes3.webService.webServiceArtis;
import com.example.tubes3.webService.webServiceDataSong;
import com.example.tubes3.webService.webServiceLagu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity implements FragmentListener {
    private homepage fragment1;
    private detail fragment2;
    private dialog_ganti_password fragment22;
    private dialog_ganti_pp fragment3;
    private dialog_ganti_warna fragment4;
    private history fragment5;
    private listsong fragment6;
    private login fragment7;
    private profile fragment8;
    private search fragment9;
    private setting fragment10;
    private signup fragment11;
    private topalbum fragment12;
    private topsong fragment13;
    private detailAlbum fragment14;
    private detailSong fragment15;
    private FragmentManager fragmentManager;
    private FragmentTransaction ft;
    private ProgressDialog progressDialog;
    ArrayList<HashMap<String, String>> songlist;
    public static String tes;
    //  private menu_fragment menu;
    // private FragmentGameOver over;
    // private username userr;
    //  private setting set;
    // private static final float VALUE_DRIFT = 1 ;
    //  private SensorManager mSensorManager;
    //  private Sensor mSensorAccelerometer;
    //  private Sensor mSensorMagnetometer;
    // private float[] accelerometerReading =new float[3];
    // private float[] magnetometerReading = new float[3];
    //  public static boolean warna=false;
    //  public static  float pitch;
    public static RequestQueue mQueue;

    public static RequestQueue mQueue2;

    public static RequestQueue mQueue3;
    public static RequestQueue mQueue4;

    public static RequestQueue mQueue5;

    public static RequestQueue mQueue6;

    public static RequestQueue mQueue7;

    public static RequestQueue mQueue8;

    public static RequestQueue mQueue9;

    public static RequestQueue mQueue10;

    public static RequestQueue mQueue11;

    public static RequestQueue mQueue12;

    public static RequestQueue mQueue13;
    public static  BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        this.fragment1 = homepage.newInstance();
        this.fragment2 = detail.newInstance();

        this.fragment5 = history.newInstance();
        this.fragment6 = listsong.newInstance();
        this.fragment7 = login.newInstance();
        this.fragment8 = profile.newInstance();
        this.fragment9 = search.newInstance();
        this.fragment10 = setting.newInstance();
        this.fragment11 = signup.newInstance();
        this.fragment12 = topalbum.newInstance();
        this.fragment13 = topsong.newInstance();
        this.fragment14 = detailAlbum.newInstance();
        this.fragment15 = detailSong.newInstance();
        this.mQueue = Volley.newRequestQueue(this);

        this.mQueue2 = Volley.newRequestQueue(this);

        this.mQueue3 = Volley.newRequestQueue(this);


        this.mQueue4 = Volley.newRequestQueue(this);

        this.mQueue5 = Volley.newRequestQueue(this);

        this.mQueue6 = Volley.newRequestQueue(this);

        this.mQueue7 = Volley.newRequestQueue(this);

        this.mQueue8 = Volley.newRequestQueue(this);

        this.mQueue9 = Volley.newRequestQueue(this);


        this.mQueue10 = Volley.newRequestQueue(this);

        this.mQueue11 = Volley.newRequestQueue(this);

        this.mQueue12 = Volley.newRequestQueue(this);

        this.mQueue13 = Volley.newRequestQueue(this);


        this.fragmentManager = this.getSupportFragmentManager();
        this.ft = this.fragmentManager.beginTransaction();
        ft.add(R.id.fragment_container, this.fragment7);
       this.bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        // mSensorManager =(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        // this.mSensorAccelerometer=this.mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //this.mSensorMagnetometer=this.mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        songlist = new ArrayList<>();
        musicbrainzService mbs = new musicbrainzService();
        mbs.jsonParse();
        webServiceDataSong wsd = new webServiceDataSong();
        wsd.jsonParse();
        webServiceLagu wsa = new webServiceLagu();
        wsa.jsonParse();
        webServiceArtis wartis = new webServiceArtis();
        wartis.jsonParse();
        fetchData process = new fetchData();
        process.execute();

        ft.commit();


    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {


                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            changePage(1);
                            break;
                        case R.id.nav_profile:
                            changePage(9);
                            break;
                        case R.id.nav_search:
                            changePage(10);
                            break;
                    }
                    return true;
                }
            };


    @Override
    public void changePage(int page) {
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        if (page == 1) {
            ft.replace(R.id.fragment_container, this.fragment1)
                    .addToBackStack(null);
        }
        if (page == 2) {
            ft.replace(R.id.fragment_container, this.fragment2)
                    .addToBackStack(null);
        }
        if (page == 3) {
            ft.replace(R.id.fragment_container, this.fragment22)
                    .addToBackStack(null);
        }
        if (page == 4) {
            ft.replace(R.id.fragment_container, this.fragment3)
                    .addToBackStack(null);
        }
        if (page == 5) {
            ft.replace(R.id.fragment_container, this.fragment4)
                    .addToBackStack(null);
        }
        if (page == 6) {
            ft.replace(R.id.fragment_container, this.fragment5)
                    .addToBackStack(null);
        }
        if (page == 7) {
            ft.replace(R.id.fragment_container, this.fragment6)
                    .addToBackStack(null);
        }
        if (page == 8) {

            ft.replace(R.id.fragment_container, this.fragment7)
                    .addToBackStack(null);
        }
        if (page == 9) {
            ft.replace(R.id.fragment_container, this.fragment8)
                    .addToBackStack(null);
        }
        if (page == 10) {
            ft.replace(R.id.fragment_container, this.fragment9)
                    .addToBackStack(null);
        }
        if (page == 11) {
            ft.replace(R.id.fragment_container, this.fragment10)
                    .addToBackStack(null);
        }
        if (page == 12) {
            ft.replace(R.id.fragment_container, this.fragment11)
                    .addToBackStack(null);
        }
        if (page == 13) {
            ft.replace(R.id.fragment_container, this.fragment12)
                    .addToBackStack(null);
        }
        if (page == 14) {
            ft.replace(R.id.fragment_container, this.fragment13)
                    .addToBackStack(null);
        }
        if (page == 15) {
            ft.replace(R.id.fragment_container, this.fragment14)
                    .addToBackStack(null);
        }
        if (page == 16) {
            ft.replace(R.id.fragment_container, this.fragment15)
                    .addToBackStack(null);
        }

        ft.commit();

    }

    public void add(String artis, int rating, int listen, String desc, String gambar) {
        presenterArtis.addToList(artis, rating, listen, desc, gambar);
    }

    public static void addUser(int id, String username, String password, String email, String phone) {
        presenterUser.addToList(id, username, password, email, phone);
    }


}
