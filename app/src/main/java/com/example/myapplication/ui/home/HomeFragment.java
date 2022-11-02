package com.example.myapplication.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.FetchData1_Activity;
import com.example.myapplication.FetchDataActivity;
import com.example.myapplication.R;
import com.example.myapplication.RecyclerAdapter;
import com.example.myapplication.Recyclerview;
import com.example.myapplication.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    Recyclerview recyclerview;
    RecyclerAdapter adapter;

//    DatabaseReference databaseReference ;

    String[] contacts={"ENGLISH","MALAYALAM","MATHS","COMPUTER","PHYSICS","CHEMISTRY","BIOLOGY"};


Button b1;


    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerView = root.findViewById(R.id.recycler_contact);
        Button button =root.findViewById(R.id.button5);
        Button button1=root.findViewById(R.id.butt_details2);
        recyclerView.setLayoutManager(new LinearLayoutManager (getActivity()));
//        databaseReference= SQLiteDatabase.getInstance().getReference("users");

        adapter = new RecyclerAdapter(this.contacts);
        recyclerView.setAdapter(adapter);



//
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FetchDataActivity.class);
                startActivity(intent);


            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FetchData1_Activity.class);
                startActivity(intent);
            }
        });

       // final TextView textView = binding.textHome;


      //  homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;




    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();

        binding = null;
    }
}