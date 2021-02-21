package com.example.androidcompiler.Tablas;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.androidcompiler.Analizadores.Lexico.TError;
import com.example.androidcompiler.Analizadores.Sintactico.Sintactico;
import com.example.androidcompiler.Operadores.Ocurrencia;

import java.util.ArrayList;

public class TablaOcurrencia {
    private static final String TR = "#87CEEB";
    private static final String TD = "#F5F5F5";

    private TableLayout tablaE;
    private Context context;
    private TableRow tableRow;
    private TextView textView;
    private Sintactico parser;


    public TablaOcurrencia(TableLayout tablaE, Context context) {
        this.tablaE = tablaE;
        this.context = context;
    }

    //Este metodo recibe una lista de ocurrencias del parser
    public void crear(ArrayList<Ocurrencia> listaOcu, Sintactico parser){
        this.parser=parser;
        agregarEncabezado();
        agregarDatos(listaOcu);
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
        textView.setText("Operador");
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
        textView.setText("Ocurrencia");
        textView.setBackgroundColor(Color.parseColor(TR));
        tableRow.addView(textView,nuevosParametros());

        tablaE.addView(tableRow);
    }

    //metodo para agregar los datos
    private void agregarDatos(ArrayList<Ocurrencia> listaOcu){
        for (int i=1;i<=listaOcu.size();i++){
            agregarFila();
            Ocurrencia operador = listaOcu.get(i-1);
            agregarCelda();
            textView.setText(operador.getOperador());
            textView.setBackgroundColor(Color.parseColor(TD));
            tableRow.addView(textView,nuevosParametros());
            agregarCelda();
            textView.setText(String.valueOf(operador.getLinea()));
            textView.setBackgroundColor(Color.parseColor(TD));
            tableRow.addView(textView,nuevosParametros());
            agregarCelda();
            textView.setText(String.valueOf(operador.getColumna()));
            textView.setBackgroundColor(Color.parseColor(TD));
            tableRow.addView(textView,nuevosParametros());
            agregarCelda();
            textView.setText(operador.getOcurrencia());
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
