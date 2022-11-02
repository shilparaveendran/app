package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    int id ;
    @SerializedName("name")
    String name;
    @SerializedName("username")
    String username;
    @SerializedName("email")
    String email;


    @SerializedName("address")
    Address address ;

    @SerializedName("phone")
    String phone ;
    @SerializedName("website")
    String website ;
    @SerializedName("company")
    Company company ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
