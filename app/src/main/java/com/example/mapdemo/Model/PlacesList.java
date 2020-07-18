package com.example.mapdemo.Model;

import java.util.List;

import com.google.api.client.util.Key;

public class PlacesList {

    @Key
    public String status;

    @Key
    public List<Favourite> results;

}
