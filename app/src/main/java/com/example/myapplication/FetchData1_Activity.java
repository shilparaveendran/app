package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FetchData1_Activity extends AppCompatActivity {

    Recyclerview recyclerview;
    FetchAdapter_1 fetchAdapter_1;

    List<User_1> list=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_data1);

         RecyclerView recyclerView = findViewById(R.id.recycler_user1);
         recyclerView.setLayoutManager(new LinearLayoutManager(FetchData1_Activity.this ));


        Button button = findViewById(R.id.button_fetch1);

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = " https://jsonplaceholder.typicode.com/posts";
                JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                //  Log.d(TAG, "onResponse: "+response.toString());
                                Gson gson = new Gson();
                                Type type = new TypeToken<List<User_1>>() {}.getType();
                                List<User_1> userList_1 = gson.fromJson(response.toString(), type);
                                fetchAdapter_1 = new FetchAdapter_1(FetchData1_Activity.this, userList_1);
                                recyclerView.setAdapter(fetchAdapter_1);
                                fetchAdapter_1.notifyDataSetChanged();
                                for (int i = 0; i < userList_1.size(); i++) {
                                    User_1 user_1 = userList_1.get(i);
                                }
                               }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(FetchData1_Activity.this,error.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });

                requestQueue.add(jsonArrayRequest);
                        }
            });


        }

    }
