package com.pucmm.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textView = findViewById(R.id.textView);
        Intent intent = getIntent();
        String msg = intent.getStringExtra("textmsg");
        if(!msg.trim().isEmpty())
            textView.setText(msg);
    }
}
