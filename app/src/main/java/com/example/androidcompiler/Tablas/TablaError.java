package com.example.androidcompiler.Tablas;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.androidcompiler.Analizadores.Lexico.TError;
import com.example.androidcompiler.Analizadores.Sintactico.Sintactico;

import java.util.ArrayList;

public class TablaError  {

    private static final String TR = "#87CEEB";
    private static final String TD = "#F5F5F5";

    private TableLayout tablaE;
    private Context context;
    private TableRow tableRow;
    private TextView textView;
    private Sintactico parser;


    public TablaError(TableLayout tablaE, Context context) {
        this.tablaE = tablaE;
        this.context = context;
    }

    //Este metodo recibe una lista de Errores del parser
    public void crear(ArrayList<TError> listaErrores, Sintactico parser){
        this.parser=parser;
        agregarEncabezado();
        agregarDatos(listaErrores);
    }

    //metodo para crear una nueva fila de datos
    private void agregarFila(){
        tableRow = new TableRow(context);
    }

    //metodo para crear una nueva columna(Celda en android)
    private void agregarCelda(){
        textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(20);
    }

    //metodo para crear el encabezado de la tabla
    private void agregarEncabezado(){
        agregarFila();

        agregarCelda();
        textView.setText("Lexema");
        textView.setBackgroundColor(Color.parseColor(TR));
        tableRow.addView(textView,nuevosParametros());

        agregarCelda();
        textView.setText("Línea");
        textView.setBackgroundColor(Color.parseColor(TR));
        tableRow.addView(textView,nuevosParametros());

        agregarCelda();
        textView.setText("Columna");
        textView.setBackgroundColor(Color.parseColor(TR));
        tableRow.addView(textView,nuevosParametros());

        agregarCelda();
        textView.setText("Tipo");
        textView.setBackgroundColor(Color.parseColor(TR));
        tableRow.addView(textView,nuevosParametros());

        agregarCelda();
        textView.setText("Descripción");
        textView.setBackgroundColor(Color.parseColor(TR));
        tableRow.addView(textView,nuevosParametros());

        tablaE.addView(tableRow);
    }

    //metodo para agregar los datos
    private void agregarDatos(ArrayList<TError> listaErrores){
        for (int i=1;i<=listaErrores.size();i++){
            agregarFila();
            TError error = listaErrores.get(i-1);
            agregarCelda();
            if(error.getLexema()==null||error.getLexema().equals("null")){
                textView.setText("NO SE ENCONTRO LEXEMA");
            }else{
                textView.setText(error.getLexema());
            }
            textView.setBackgroundColor(Color.parseColor(TD));
            tableRow.addView(textView,nuevosParametros());
            agregarCelda();
            textView.setText(String.valueOf(error.getLine()));
            textView.setBackgroundColor(Color.parseColor(TD));
            tableRow.addView(textView,nuevosParametros());
            agregarCelda();
            textView.setText(String.valueOf(error.getColumna()));
            textView.setBackgroundColor(Color.parseColor(TD));
            tableRow.addView(textView,nuevosParametros());
            agregarCelda();
            textView.setText(error.getTipo());
            textView.setBackgroundColor(Color.parseColor(TD));
            tableRow.addView(textView,nuevosParametros());
            agregarCelda();
            textView.setText(error.getDescripcion());
            textView.setBackgroundColor(Color.parseColor(TD));
            tableRow.addView(textView,nuevosParametros());

            tablaE.addView(tableRow);

        }
    }
    //metodo para asignar margenes a las celdas
    private TableRow.LayoutParams nuevosParametros(){
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams();
        layoutParams.setMargins(1,1,1,1);
        layoutParams.weight=1;
        return layoutParams;
    }
}
