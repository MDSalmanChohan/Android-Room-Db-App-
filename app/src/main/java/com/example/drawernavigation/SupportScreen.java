package com.example.drawernavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SupportScreen extends Fragment  {
    Spinner spinner;
    String[] course ={"Select your course","Android","Flutter","Kotlin","Java","Python","Other"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


         // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_support_screen, container, false);



        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<String> LTRadapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, course);
        LTRadapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(LTRadapter);
        EditText et_text;
        et_text = view.findViewById(R.id.et_text);
        Button submit = view.findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                String editt = et_text.getText().toString();
                if (spinner.getSelectedItem().toString().trim() == ("Pick one")) {

                }
                else if (TextUtils.isEmpty(editt))
                {
                    et_text.setError("Please enter the field");
                    //Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                }
                else
                {

                        Bundle bundle = new Bundle();
                        String message = et_text.getText().toString();
                        String course  = spinner.getSelectedItem().toString();
                        bundle.putString("message",message);
                        bundle.putString("course",course);
                        fetch_support_record record = new fetch_support_record();
                        record.setArguments(bundle);

                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,record).commit();

                   Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return  view;
    }

}