package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Recyclerview extends AppCompatActivity {
    Recyclerview recyclerview;
    RecyclerAdapter adapter;
    ArrayList<Student>list;

    String[] contacts={"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
//        RecyclerView recyclerView = findViewById(R.id.recyclercontact);
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new RecyclerAdapter(this.contacts);
//        recyclerView.setAdapter(adapter);
    }


}