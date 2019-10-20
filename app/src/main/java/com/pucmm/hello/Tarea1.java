package com.pucmm.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Tarea1 extends AppCompatActivity implements View.OnClickListener {

    private EditText txtNombre, txtApellido, txtEdad, txtNacimiento, txtCorreo;
    private Spinner estadoSpinner;
    private RadioGroup sexRadioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarea1);
        Button botonEnviar = findViewById(R.id.btnEnviar);
        botonEnviar.setOnClickListener(this);
        Button botonLimpiar = findViewById(R.id.btnLimpiar);
        botonLimpiar.setOnClickListener(this);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtEdad = findViewById(R.id.txtEdad);
        txtNacimiento = findViewById(R.id.txtNacimiento);
        txtCorreo = findViewById(R.id.txtCorreo);
        estadoSpinner = findViewById(R.id.estadoSpinner);
        sexRadioGroup = findViewById(R.id.sexRadioGroup);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnEnviar) {
            //Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
            //Intent intent = new Intent(this,SecondActivity.class);
            //intent.putExtra("textmsg",mensaje);
            //startActivity(intent);
            if(camposValidos() == true){
                Toast.makeText(this, "Enviando Data...", Toast.LENGTH_LONG).show();
            }
        }else if (v.getId() == R.id.btnLimpiar) {
            limpiarCampos();
        }
    }

    private boolean camposValidos() {
        boolean camposValidados = true;
        if(txtNombre.getText().toString().trim().isEmpty()){
            camposValidados = false;
            Toast.makeText(this, "El campo Nombre está vacio", Toast.LENGTH_LONG).show();
        }else if(txtApellido.getText().toString().trim().isEmpty()){
            camposValidados = false;
            Toast.makeText(this, "El campo Apellido está vacio", Toast.LENGTH_LONG).show();
        }else if(txtEdad.getText().toString().trim().isEmpty()){
            camposValidados = false;
            Toast.makeText(this, "El campo Edad está vacio", Toast.LENGTH_LONG).show();
        }else if(txtNacimiento.getText().toString().trim().isEmpty()){
            camposValidados = false;
            Toast.makeText(this, "El campo Fecha de Nacimiento está vacio", Toast.LENGTH_LONG).show();
        }else if(txtCorreo.getText().toString().trim().isEmpty()) {
            camposValidados = false;
            Toast.makeText(this, "El campo Correo está vacio", Toast.LENGTH_LONG).show();
        }else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(txtCorreo.getText().toString()).matches()){
            camposValidados = false;
            Toast.makeText(this, "Introduce una dirección de correo válida", Toast.LENGTH_LONG).show();
        }else if(isValidDate(txtNacimiento.getText().toString())==false){
            camposValidados = false;
            Toast.makeText(this, "Introduce una fecha de nacimiento válida", Toast.LENGTH_LONG).show();
        }
        return camposValidados;
    }

    private boolean isValidDate(String fecha) {
        boolean validDate = true;
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            format.parse(fecha);
        } catch (ParseException e) {
           validDate = false;
        }
        return validDate;
    }


    private void limpiarCampos() {
        txtNombre.getText().clear();
        txtApellido.getText().clear();
        txtEdad.getText().clear();
        txtNacimiento.getText().clear();
        txtCorreo.getText().clear();
    }

}
