package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class Geo {
    @SerializedName("lat")
    String lat;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @SerializedName("lng")
    String lng;
}
