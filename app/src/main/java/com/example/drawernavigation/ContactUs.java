package com.example.drawernavigation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class ContactUs extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);
    Button SendEmail = view.findViewById(R.id.SendEmail);
        Button message=view.findViewById(R.id.SendSms);
        Button calling =view.findViewById(R.id.SendPhone);

    SendEmail.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            sendEmail();
        }
    });

           message .setOnClickListener(new View.OnClickListener() {
         @Override
          public void onClick(View view) {


             String number = "12345";  // The number on which you want to send SMS
             startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null)));

           }
        });

           calling.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   String phone = "123445";
             Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
             startActivity(intent);
               }
           });

        return view;
    }
    protected void sendEmail() {
        Log.i("Send email", "");

        String[] TO = {"someone@gmail.com"};
        String[] CC = {"xyz@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getContext(), "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

    private void finish() {
    }


}