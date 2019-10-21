package com.pucmm.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Tarea1Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarea12);
        TextView textView = findViewById(R.id.resultadosTextView);
        Intent intent = getIntent();
        String msg = intent.getStringExtra("textmsg");
        if(!msg.trim().isEmpty())
            textView.setText(msg);
    }
}
