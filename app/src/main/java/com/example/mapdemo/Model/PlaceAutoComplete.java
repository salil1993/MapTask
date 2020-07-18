package com.example.mapdemo.Model;

import com.google.api.client.util.Key;

public class PlaceAutoComplete {

    @Key
    public String id;

    @Key
    public String description;

    @Key
    public String reference;


    @Override
    public String toString() {
        return description + " - " + id + " - " + reference;
    }

}