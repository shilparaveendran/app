package com.example.myapplication;

public class Student {
    String name, course, email;
    int age;
    boolean s;
    double percentage;

    public Student(){

    }

    public Student(String name, String course, String email, int age, boolean s, double percentage) {
        this.name = name;
        this.course = course;
        this.email = email;
        this.age = age;
        this.s = s;
        this.percentage = percentage;
    }

    public Student (String name, String course){
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isS() {
        return s;
    }

    public void setS(boolean s) {
        this.s = s;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}