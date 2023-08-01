package com.example.myelementary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        String coders="developer--->fobybus(firaol)@msf\ndesigner--->temesgen getachew";
        TextView tx=findViewById(R.id.textview);
        tx.setText(coders);

    }
}