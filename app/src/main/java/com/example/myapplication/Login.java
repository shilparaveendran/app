package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText username;
    EditText password;
    Button b1;
    Button b2;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1=findViewById(R.id.button2);
        b2=findViewById(R.id.button3);

        username=(EditText)findViewById(R.id.editTextTextPersonName7);
        password=(EditText)findViewById(R.id.editTextTextPersonName8);
        DB= new DBHelper(this );

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals("")){
                    Toast.makeText(Login.this, " Enter all fields.", Toast.LENGTH_SHORT).show();
                }else {
                    boolean checkuser = DB.checkusernamepassword(user, pass);

                    if (checkuser) {
                        Toast.makeText(Login.this, "sign in successfully.", Toast.LENGTH_SHORT).show();


                        Intent intent = new Intent(Login.this, NavigationdrawyerActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Login.this, "invalid.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

       b2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent =new Intent(Login.this,MainActivity.class);
               startActivity(intent);


       }
       });


    }
    }