package com.example.heesu.myapplication;

/**
 * Created by heesu on 2017-12-06.
 */

public class Book {
    String _id;
    String name;
    String address;
    String phone;

    public Book(String _id, String name, String address, String phone) {
        this._id = _id;
        this.name = name;
        this.address  = address;
        this.phone = phone;
    }

    public String toString() {
        return String.format("_id = %s \n name = %s \n address = %s \n phone = %s",_id,name,address,phone);
    }
    public String get_id() {
        return _id;
    }
    public String getname() {
        return name;
    }
    public String getaddress() {
        String st = address;
        String[] arr = st.split(" ");
        return arr[0];
    }
    public String getphone() {
        return phone;
    }


}