package com.example.androidcompiler.Reportes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.androidcompiler.Analizadores.Lexico.TError;
import com.example.androidcompiler.Analizadores.Sintactico.Sintactico;
import com.example.androidcompiler.Operadores.Ocurrencia;
import com.example.androidcompiler.R;
import com.example.androidcompiler.Tablas.TablaError;
import com.example.androidcompiler.Tablas.TablaOcurrencia;

import java.util.ArrayList;

public class report_operadores extends AppCompatActivity {
    //Declaramos el array que vamos a recibir del analizador sintactico y tablelayout propio de android
    private Sintactico parser=new Sintactico();
    private TableLayout tablaActivityOp;
    ArrayList<Ocurrencia> ocurrencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_operadores);
        tablaActivityOp=(TableLayout)findViewById(R.id.tablaOpe);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        parser = new Sintactico();
        ocurrencias = new ArrayList<>();

        try{
            //recibiendo los errores del activity resultado y agreganolos a la lista de errores
            ArrayList<Ocurrencia> listaOperadores= getIntent().getExtras().getParcelableArrayList("listaOp");
            ocurrencias.addAll(listaOperadores);
            mostrarOcurrencias(tablaActivityOp,ocurrencias);

        }catch(Exception e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
        }
    }
    //metodo para agregar las ocurrencias a la lista a la tabla de tabla Ocurrencia
    public void mostrarOcurrencias(TableLayout tablaO, ArrayList<Ocurrencia> ocu){
        try{
            TablaOcurrencia tabla = new TablaOcurrencia(tablaO,getApplicationContext());
            tabla.crear(ocu,parser);
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