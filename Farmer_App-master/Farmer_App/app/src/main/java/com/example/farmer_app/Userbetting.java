package com.example.farmer_app;

public class Userbetting {
    String uname,uaddress,unumber,price,fname,proname,date,time;

    public Userbetting() {
    }

    public Userbetting(String uname, String uaddress, String unumber, String price, String fname, String proname, String date, String time) {
        this.uname = uname;
        this.uaddress = uaddress;
        this.unumber = unumber;
        this.price = price;
        this.fname = fname;
        this.proname = proname;
        this.date = date;
        this.time = time;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }

    public String getUnumber() {
        return unumber;
    }

    public void setUnumber(String unumber) {
        this.unumber = unumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
