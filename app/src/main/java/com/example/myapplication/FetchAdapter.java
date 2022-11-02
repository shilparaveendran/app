package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


    public class FetchAdapter extends RecyclerView.Adapter<FetchAdapter.MyViewHolder> {
        Context context;
        List<User> list;
        OnitemClick onitemClick;

        public FetchAdapter(Context context, List<User> list, OnitemClick onitemClick) {
            this.context = context;
            this.list = list;
            this.onitemClick=onitemClick;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.data_row, parent, false);
            return new FetchAdapter.MyViewHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull FetchAdapter.MyViewHolder holder, int position) {

            User user = list.get(position);
            String userDetails = user.getId()+"\n"+ user.getName()+"\n"+user.getUsername()+ "\n" +user.getEmail();
            Address address=user.getAddress();
            if (address !=null){
                String street = address.getStreet();
                String suite = address.getSuite();
                String city = address.getCity();
                String zipcode = address.getZipcode();
                String address_details = address.getStreet()+"\n"+address.getSuite()+"\n"+ address.getCity()+"\n"+ address.getZipcode();
                holder.address.setText(address_details);
                Geo geo=address.getGeo();
                if (geo!=null){
                    String lat = geo.getLat();
                    String lng = geo.getLng();
                    String geo_details = address.getGeo().getLat();
                    holder.geo.setText(geo_details);
                }
            }
            Company company=user.getCompany();
            if(company != null){
                String name = company.getName();
                String catchphrase = company.getCatchPhrase();
                String company_details = company.getName()+"\n"+company.getCatchPhrase()+"\n"+company.getBs();
                holder.company.setText(company_details);
            }






            holder.user.setText(userDetails);









//            holder.user.setText(user.getId());
//            holder.user.setText(user.getName());
//            holder.user.setText(user.getUsername());

//            holder.address.setText(address.getStreet());
//            holder.address.setText(address.getSuite());
//            holder.address.setText(address.getCity());
//            holder.address.setText(address.getZipcode());
//            holder.geo.setText(address.geo.getLat());
//            holder.geo.setText(address.geo.getLng());
//            holder.company.setText(company.getName());
//            holder.company.setText(company.getCatchPhrase());
//            holder.company.setText(company.getBs());
//
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    onitemClick.OnitemClick(user);
                }
            });



        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView user, address, company, geo;


            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                user = itemView.findViewById(R.id.tv_user);
                address = itemView.findViewById(R.id.tv_address);
                geo = itemView.findViewById(R.id.tv_geo);
                company = itemView.findViewById(R.id.tv_company);



            }
        }
    }




