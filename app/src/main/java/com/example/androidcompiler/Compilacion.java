package com.example.androidcompiler;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidcompiler.Pintar.Dibujar;
import com.example.androidcompiler.Analizadores.Lexico.Lexico;
import com.example.androidcompiler.Analizadores.Sintactico.Sintactico;
import com.example.androidcompiler.Reportes.report_colores;
import com.example.androidcompiler.Reportes.report_errores;
import com.example.androidcompiler.Reportes.report_objetos;
import com.example.androidcompiler.Reportes.report_operadores;

import java.io.StringReader;

public class Compilacion extends AppCompatActivity {

    //Clase generada a raiz de JFlex
    private Lexico lex;

    //Clase generada a raiz de Cup
    private Sintactico pars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compilacion);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Se recupera el texto ingresado por el usuario del activity main
        String dataE = getIntent().getStringExtra("datos");
        lex = new Lexico(new StringReader(dataE));
        pars = new Sintactico(lex);

        analizarDatos(dataE);

        //Verificamos si el analizador lexico encontro un error.
        //Verificamos si el analizador sintactico encontro un error.
        if(lex.getErrores().size()==0 && pars.getErrores().size()==0){
                dibujarFiguras();
        }
    }
    //Metodo que analiza lo ingresado por el usuario y mostrara un mensaje emergente en el activity
    public void analizarDatos(String datosEntrada){
        try {
            pars.parse();
            if(pars.getErrores().size()==0 && lex.getErrores().size()==0){
                Toast.makeText(this,"Compilacion finalizada con exito!",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"Se encontro Errores en la Compilacion: "+pars.getErrores().size(),Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            Toast.makeText(this,"Se encontro error en la Sintaxis de lo que ingreso: "+pars.getErrores().size(),Toast.LENGTH_SHORT).show();
        }
    }

    //Este metodo grafica o anima las figuras que se hayan encontrado en el texto que ingreso el usuario
    public void dibujarFiguras(){
        setContentView(new Dibujar(this,pars.getFigurass()));
    }


    //metodo para mostrar los errores/enviar los errores al activity errores
    public void mostrarErrores(){
        Intent intent = new Intent(this, report_errores.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("erroresLexicos",lex.getErrores());
        bundle.putParcelableArrayList("erroresSintacticos",pars.getErrores());
        intent.putExtras(bundle);
        startActivity(intent);
    }
    //metodo para mostrar reporte de ocurrencias usadas en el codigo
    public void mostrarOcurrencias(){
        Intent intent = new Intent(this, report_operadores.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("listaOp",pars.getOcurrencias());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    //metodo para mostrar reporte de colores usados en el codigo
    public void mostrarColores(){
        Intent intent = new Intent(this, report_colores.class);
        intent.putExtra("dataUsados",lex.gettUsados());
        startActivity(intent);
    }

    //metodo para mostrar reporte de objetos/figuras usados en el codigo
    public void mostrarObjetosUsados(){
        Intent intent = new Intent(this, report_objetos.class);
        intent.putExtra("usadosLex",lex.gettUsados());
        intent.putExtra("usadosSin",pars.gettUsados()[0]);
        startActivity(intent);
    }

    //Metodo que muestra las opciones de los reportes asi como los restringe si en el caso se encontro un error de copilacion
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        //Si hay algun error de compilacion solo mostrara el Reporte de Errores
        if(lex.getErrores().size()==0 && pars.getErrores().size()==0){
            menu.findItem(R.id.itemErrores).setEnabled(false);
        }else{
            //De no haber ningun error se mostran todos los demas reportes a excepcion del de Errores
            menu.findItem(R.id.itemAnimaciones).setEnabled(false);
            menu.findItem(R.id.itemColores).setEnabled(false);
            menu.findItem(R.id.itemObjetos).setEnabled(false);
            menu.findItem(R.id.itemOcurrencias).setEnabled(false);
        }
        return true;
    }

    //metodo para asignar las funciones correspondientes a las opciones
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.itemOcurrencias){
              mostrarOcurrencias();
        }else if(id==R.id.itemColores){
              mostrarColores();
        }else if(id==R.id.itemObjetos){
              mostrarObjetosUsados();
        }else if(id==R.id.itemErrores){
            mostrarErrores();
        }else if(id==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}