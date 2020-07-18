package com.example.mapdemo.Model;


import com.google.api.client.util.Key;

public class PlaceDetail {

    @Key
    public Favourite result;

    @Override
    public String toString() {
        if (result!=null) {
            return result.toString();
        }
        return super.toString();
    }
}
