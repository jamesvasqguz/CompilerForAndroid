package com.example.androidcompiler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Variables de entrada
    private TextView histo;
    private EditText dataEntrada;
    private Button btcom;

    //Inicia el activity principal
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataEntrada=(EditText)findViewById(R.id.txtEntrada);
    }

    public void analizar(View view) {
        //Agregamos lo que ingreso el usuario a un historial

        if (dataEntrada.getText().toString().isEmpty() || dataEntrada.getText().toString().trim().isEmpty()) {
            //Mensaje en pantalla por si el usuario no ingreso texto.
            Toast.makeText(this, "Debe de ingresar texto primero", Toast.LENGTH_SHORT).show();
        } else {
            //Agregamos un intent que nos permitira enviar los datos de entrada al activity resultado y proceder con la copilacion
            Intent mostrarResultado = new Intent(this, Compilacion.class);
            mostrarResultado.putExtra("datos", dataEntrada.getText().toString());
            startActivity(mostrarResultado);
        }
    }
}