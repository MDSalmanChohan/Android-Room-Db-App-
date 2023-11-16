package com.example.drawernavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class fetch_support_record extends Fragment {
    TextView message,course;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       View view = inflater.inflate(R.layout.fragment_fetch_support_record, container, false);

        message = view.findViewById(R.id.message);
        course = view.findViewById(R.id.course);
        Bundle bundle = this.getArguments();
        String mymessage = bundle.getString("message");
        String mycourse = bundle.getString("course");
        message.setText(mymessage);
        course.setText(mycourse);

       return view;
    }
}