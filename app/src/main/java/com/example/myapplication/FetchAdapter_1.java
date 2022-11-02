package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FetchAdapter_1 extends RecyclerView.Adapter<FetchAdapter_1.MyViewHolder> {
    Context context;
    List<User_1> list;

    public FetchAdapter_1(Context context, List<User_1> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public FetchAdapter_1.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.data_row1, parent, false);
        return new FetchAdapter_1.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FetchAdapter_1.MyViewHolder holder, int position) {
        User_1 user_1 = list.get(position);
        if (user_1 != null) {
            int userId = user_1.getUserId();
            int Id = user_1.getId();
            String title = user_1.getTitle();
            String body = user_1.getBody();
            String userDetails = user_1.getUserId() + "\n" + user_1.getId() + "\n" + user_1.getTitle() + "\n" + user_1.getBody();

            holder.user_1.setText(userDetails);

        }
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView user_1;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            user_1 = itemView.findViewById(R.id.textView4);

        }
    }
}
