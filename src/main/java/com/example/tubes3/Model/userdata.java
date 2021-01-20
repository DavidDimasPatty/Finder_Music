package com.example.tubes3.Model;

public class userdata {
    private int id;
    private String username;
    private String password;
    private String email;
    private String phone;

    public userdata(int id,String username,String password,String email,String phone) {
        this.id=id;
        this.username=username;
        this.password=password;
        this.email=email;
        this.phone=phone;
    }


    public int getIdd() {
        return id;
    }
    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() { return  phone; }

    public void setPassword(String pass){
        this.password=pass;
    }

    }
