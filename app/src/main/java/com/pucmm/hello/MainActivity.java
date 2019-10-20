package com.pucmm.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boton = findViewById(R.id.button);
        boton.setOnClickListener(this);
        Button boton2 = findViewById(R.id.button2);
        boton2.setOnClickListener(this);
        editText = findViewById(R.id.textView);
    }

    public void onClick(View view) {
        String mensaje = editText.getText().toString();
        if (view.getId() == R.id.button) {
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
        } else if (view.getId() == R.id.button2) {
            Intent intent = new Intent(this,SecondActivity.class);
            intent.putExtra("textmsg",mensaje);
            startActivity(intent);
        }

    }
}
