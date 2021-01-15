package com.example.tubes3.Model;

public class history {
    private String user;
    private String song;

    public history(String user,String song){
        this.user=user;
        this.song=song;
    }

    public String getSong() {
        return song;
    }


    public String getUser() {
        return user;
    }
}
