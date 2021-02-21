package com.example.androidcompiler.Reportes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.androidcompiler.Analizadores.Lexico.TError;
import com.example.androidcompiler.Analizadores.Sintactico.Sintactico;
import com.example.androidcompiler.R;
import com.example.androidcompiler.Tablas.TablaError;

import java.util.ArrayList;

public class report_errores extends AppCompatActivity {
    //Declaramos el array que vamos a recibir del analizador sintactico y tablelayout propio de android
    private Sintactico parser=new Sintactico();
    private TableLayout tablaActivityE;
    ArrayList<TError> errores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_errores);
        tablaActivityE=(TableLayout)findViewById(R.id.tablaErrores);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        parser = new Sintactico();
        errores = new ArrayList<>();
        try{
            //recibiendo los errores del activity resultado y agreganolos a la lista de errores
            ArrayList<TError> erroresLexicos= getIntent().getExtras().getParcelableArrayList("erroresLexicos");
            ArrayList<TError> erroresSintacticos= getIntent().getExtras().getParcelableArrayList("erroresSintacticos");
            errores.addAll(erroresLexicos);
            errores.addAll(erroresSintacticos);
            mostrarErrores(tablaActivityE,errores);

        }catch(Exception e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
        }
    }
    //metodo para agregar los errores en la lista a la tabla de errores
    public void mostrarErrores(TableLayout tablaE, ArrayList<TError> errores){
        try{
            TablaError tabla = new TablaError(tablaE,getApplicationContext());
            tabla.crear(errores,parser);
        }catch (Exception e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}