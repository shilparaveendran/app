package com.example.myapplication;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
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

public class FetchDataActivity extends AppCompatActivity implements OnitemClick {
    private static final String TAG = "FetchData";
    RecyclerView recyclerView;
    FetchAdapter fetchAdapter;

    List<User> list=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_data);

         recyclerView = findViewById(R.id.recycler_user);
        recyclerView.setLayoutManager(new LinearLayoutManager(FetchDataActivity.this ));
       setAdapter(list);

//        TextView textView = findViewById(R.id.user);
         Button button = findViewById(R.id.button_fetch);




        RequestQueue requestQueue= Volley.newRequestQueue(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = " https://jsonplaceholder.typicode.com/users";
                JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null,
                        new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                      //  Log.d(TAG, "onResponse: "+response.toString());
                        Gson gson = new Gson();
                        Type type = new TypeToken<List<User>> (){}.getType();
                        List<User> userList = gson.fromJson(response.toString(),type);
                        setAdapter(userList);
                        for(int i=0; i<userList.size();i++){
                          User  user = userList.get( i);
                          Address address=user.getAddress();
                          Company company=user.getCompany();
                          Geo geo=address.getGeo();
//                            Log.d(TAG, "onResponse: "+user);

                        }
                        Log.d(TAG, "onResponse: "+userList.toString());

             }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(FetchDataActivity.this,error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

                requestQueue.add(jsonArrayRequest);
            }
        });

    }


    @Override
    public void OnitemClick(User user) {
        Toast.makeText(FetchDataActivity.this,user.getName(), Toast.LENGTH_SHORT).show();
       if(getSupportActionBar() != null){
        getSupportActionBar().setTitle(user.getName());
       }
    }
    public void setAdapter(List<User> user){
        fetchAdapter = new FetchAdapter(FetchDataActivity.this,user,this);
        recyclerView.setAdapter(fetchAdapter);
        fetchAdapter.notifyDataSetChanged();
    }
}