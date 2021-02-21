package com.example.androidcompiler.Reportes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.androidcompiler.R;
import com.example.androidcompiler.Tablas.TablaColors;
import com.example.androidcompiler.Tablas.TablaObject;

public class report_objetos extends AppCompatActivity {
    private TableLayout tablaObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_objetos);
        tablaObject = (TableLayout)findViewById(R.id.tablaOb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        try{
            int[] usadosLex = getIntent().getIntArrayExtra("usadosLex");
            int usadosSin = getIntent().getIntExtra("usadosSin",0);
            listarObjetos(tablaObject,usadosLex,usadosSin);
        }catch(Exception e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();
        }
    }
    //Este metodo para agregar los colores a la lista de colores usados
    public void listarObjetos(TableLayout tableLayout, int[] usados,int cantidad){
        try{
            TablaObject tabla = new TablaObject(tableLayout,getApplicationContext());
            tabla.listarObjetos(usados,cantidad);
        }catch (Exception e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}