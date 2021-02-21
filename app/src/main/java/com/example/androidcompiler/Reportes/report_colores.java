package com.example.androidcompiler.Reportes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.androidcompiler.R;
import com.example.androidcompiler.Tablas.TablaColors;

public class report_colores extends AppCompatActivity {
    private TableLayout tablaColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_colores);
        tablaColor = (TableLayout)findViewById(R.id.tablaColores);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        try{
            int[] usados = getIntent().getIntArrayExtra("dataUsados");
            agregarColoresUsados(tablaColor,usados);
        }catch(Exception e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();
        }
    }
    //Este metodo para agregar los colores a la lista de colores usados
    public void agregarColoresUsados(TableLayout tableLayout, int[] usados){
        try{
            TablaColors tabla = new TablaColors(tableLayout,getApplicationContext());
            tabla.listarColores(usados);
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