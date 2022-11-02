package com.example.myapplication.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.RecyclerAdapter;
import com.example.myapplication.Recyclerview;
import com.example.myapplication.Student;
import com.example.myapplication.Student_adapter;
import com.example.myapplication.databinding.FragmentGalleryBinding;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    Recyclerview recyclerview;
    Student_adapter adapter;
    ArrayList<Student> list=new ArrayList<>();
    int images[]={ R.drawable.p1,R.drawable.p2,R.drawable.p4,R.drawable.p5,R.drawable.p3};

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerView = root.findViewById(R.id.recycler_student);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        list =new ArrayList<>();
        addStudent();
        adapter = new Student_adapter(getActivity(),list,images);
        recyclerView.setAdapter(adapter);

//        final TextView textView = binding.textGallery;
//        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    private void addStudent() {
        Student stud  = new Student();
        stud.setName("SHILPA.P");
        stud.setCourse("COMPUTER");
        stud.setEmail("shilpa@gmail.com");
        stud.setAge(23);
        stud.setPercentage(100);

        list.add(stud);


        Student stud2  = new Student();
        stud2.setName("ANU");
        stud2.setCourse("physics");
        stud2.setEmail("anu@gmail.com");
        stud2.setAge(25);
        stud2.setPercentage(80);
        list.add(stud2);

        Student stud3 = new Student();
        stud3.setName("ALI");
        stud3.setCourse("Biology");
        stud3.setEmail("ali@gmail.com");
        stud3.setAge(21);
        stud3.setPercentage(85);
        list.add(stud3);

        Student stud4  = new Student();
        stud4.setName("JOHN");
        stud4.setCourse("english");
        stud4.setEmail("john@gmail.com");
        stud4.setAge(22);
        stud4.setPercentage(90);
        list.add(stud4);

        Student stud5  = new Student();
        stud5.setName("MIYA");
        stud5.setCourse("malayalam");
        stud5.setEmail("miya@gmail.com");
        stud5.setAge(23);
        stud5.setPercentage(88);
        list.add(stud5);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}