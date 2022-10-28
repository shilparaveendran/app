package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText name,email,password,username;
    Spinner country;
    RadioButton r1,r2;
    Button b1,b2;
    String gender;


    DBHelper myDB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.editTextTextPersonName);
        email=(EditText)findViewById(R.id.editTextTextPersonName5);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        country=findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.country,android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        country.setAdapter(adapter);
        country.setOnItemSelectedListener(this);
//        gender=(EditText)findViewById(R.id.gender);
        r1=findViewById(R.id.radioButton);
        r2=findViewById(R.id.radioButton2);
        b1=findViewById(R.id.button);



        myDB = new DBHelper(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String Name = name.getText().toString();
                String Email = email.getText().toString();
                String Country = country.getSelectedItem().toString();
                if(r1.isChecked())
                {
                    gender=r1.getText().toString();
                }
                else if(r2.isChecked())
                {
                    gender=r2.getText().toString();
                }
                if(Name.equals("")||Email.equals("")||gender.equals("")||Country.equals("")||user.equals("")||pass.equals("")){
                    Toast.makeText(MainActivity.this, "Fill all the fields.", Toast.LENGTH_SHORT).show();
                }
                else{
                   boolean checkuser = myDB.checkusername(user);
                   if(!checkuser){
                       boolean insert = myDB.insertData(Name,Email,gender,Country,user,pass);
                       if(insert==true){
                           Toast.makeText(MainActivity.this, "Registerd Successfully.", Toast.LENGTH_SHORT).show();
                           Intent intent =new Intent(MainActivity.this,Login.class);
                           startActivity(intent);
                       }
                       else{
                           Toast.makeText(MainActivity.this, "Registerd failed.", Toast.LENGTH_SHORT).show();
                       }
//                       else{
//                           Toast.makeText(MainActivity.this, " already exists.", Toast.LENGTH_SHORT).show();
//                       }

                    }
                }




            }
        });
//        b2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent =new Intent(MainActivity.this,Login.class);
//                startActivity(intent);
//
//
//            }
//        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}