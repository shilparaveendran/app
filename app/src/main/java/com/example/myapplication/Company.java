package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class Company {

    @SerializedName("name")
    String name;
    @SerializedName("catchPhrase")
    String catchPhrase;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    @SerializedName("bs")
    String bs;
}
