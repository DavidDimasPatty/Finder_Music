package com.example.tubes3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.example.tubes3.Model.userdata;
import com.example.tubes3.fragmentView.DetailFragment.detail;
import com.example.tubes3.fragmentView.DetailFragment.detailAlbum;
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
import com.example.tubes3.presenter.presenterAlbum;
import com.example.tubes3.presenter.presenterArtis;
import com.example.tubes3.presenter.presenterSong;
import com.example.tubes3.presenter.presenterUser;
import com.google.android.material.bottomnavigation.BottomNavigationView;

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
    private FragmentManager fragmentManager;
    private FragmentTransaction ft;

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
        this.fragment14=detailAlbum.newInstance();


        this.fragmentManager = this.getSupportFragmentManager();
        this.ft = this.fragmentManager.beginTransaction();
        ft.add(R.id.fragment_container, this.fragment7);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        // mSensorManager =(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        // this.mSensorAccelerometer=this.mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //this.mSensorMagnetometer=this.mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        add("Selena Gomez",9,2134,"artis amerika","test");

        add("Selena Gomez",9,2134,"artis amerika","test");

        add("Selena Gomez",9,2134,"artis amerika","test");

        add("Selena Gomez",9,2134,"artis amerika","test");

        add("Selena Gomez",9,2134,"artis amerika","test");
        addAlbum("selena","do want",10,2321,"mantap bang","20-12-2012");

        addAlbum("selena","crystal",10,2321,"mantap bang","20-12-2012");
        ft.commit();
        addsong("nada kasih","w","a",4,3,"3","32");

        addsong("test","w","do want",4,3,"3","32");

        addsong("beer bong","w","do want",4,3,"3","32");

        addsong("circle","w","do want",4,3,"3","32");

        addUser(1,"admin","admin","admin@gmail.com","089231231241");
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
        if(page==1){
            ft.replace(R.id.fragment_container,this.fragment1)
                    .addToBackStack(null);
        }
        if(page==2){
            ft.replace(R.id.fragment_container,this.fragment2)
                    .addToBackStack(null);
        }
        if(page==3){
            ft.replace(R.id.fragment_container,this.fragment22)
                    .addToBackStack(null);
        }
        if(page==4){
            ft.replace(R.id.fragment_container,this.fragment3)
                    .addToBackStack(null);
        }
        if(page==5){
            ft.replace(R.id.fragment_container,this.fragment4)
                    .addToBackStack(null);
        }
        if(page==6){
            ft.replace(R.id.fragment_container,this.fragment5)
                    .addToBackStack(null);
        }
        if(page==7){
            ft.replace(R.id.fragment_container,this.fragment6)
                    .addToBackStack(null);
        }
        if(page==8){
            ft.replace(R.id.fragment_container,this.fragment7)
                    .addToBackStack(null);
        }
        if(page==9){
            ft.replace(R.id.fragment_container,this.fragment8)
                    .addToBackStack(null);
        }   if(page==10){
            ft.replace(R.id.fragment_container,this.fragment9)
                    .addToBackStack(null);
        }   if(page==11){
            ft.replace(R.id.fragment_container,this.fragment10)
                    .addToBackStack(null);
        }
        if(page==12){
            ft.replace(R.id.fragment_container,this.fragment11)
                    .addToBackStack(null);
        }
        if(page==13){
            ft.replace(R.id.fragment_container,this.fragment12)
                    .addToBackStack(null);
        }
        if(page==14){
            ft.replace(R.id.fragment_container,this.fragment13)
                    .addToBackStack(null);
        }
        if(page==15){
            ft.replace(R.id.fragment_container,this.fragment14)
                    .addToBackStack(null);
        }

        ft.commit();

    }
    public void add(String artis,int rating,int listen,String desc,String gambar){
        presenterArtis.addToList( artis, rating, listen,desc, gambar);
    }

    public void addAlbum(String artis, String album,int rating,int listen,String desc,String release){
        presenterAlbum.addToList( artis,  album,rating, listen, desc, release);
    }
    public void addsong (String nama, String artis, String album,int rating,int listen,String desc,String release){
        presenterSong.addToList(nama, artis, album, rating,listen, desc, release);}

    public static void addUser(int id,String username,String password,String email,String phone){
        presenterUser.addToList(id,username,  password, email, phone);
    }
}
