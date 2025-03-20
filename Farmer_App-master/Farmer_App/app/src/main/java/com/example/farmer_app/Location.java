package com.example.farmer_app;

public class Location {

    String proname,desc,price,qty,time,fname,faddress,fnumber,imageurl;

    public Location() {
    }

    public Location(String proname, String desc, String price, String qty, String time, String fname, String faddress, String fnumber, String imageurl) {
        this.proname = proname;
        this.desc = desc;
        this.price = price;
        this.qty = qty;
        this.time = time;
        this.fname = fname;
        this.faddress = faddress;
        this.fnumber = fnumber;
        this.imageurl = imageurl;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFaddress() {
        return faddress;
    }

    public void setFaddress(String faddress) {
        this.faddress = faddress;
    }

    public String getFnumber() {
        return fnumber;
    }

    public void setFnumber(String fnumber) {
        this.fnumber = fnumber;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
