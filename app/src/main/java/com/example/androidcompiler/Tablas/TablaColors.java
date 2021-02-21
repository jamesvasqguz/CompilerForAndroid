package com.example.androidcompiler.Tablas;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class TablaColors {

    private static final String TR = "#87CEEB";
    private static final String TD = "#F5F5F5";

    private TableLayout tablaC;
    private Context context;
    private TableRow tableRow;
    private TextView textView;

    public TablaColors(TableLayout tablaC, Context context) {
        this.tablaC = tablaC;
        this.context = context;
    }

    //metodo general para crear la tabla
    public void listarColores(int[] usados){
        crearEncabezado();
        agregarDatos(usados);
    }


    //metodo para crear una nueva fila de datos
    private void nuevaFila(){
        tableRow = new TableRow(context);
    }

    //metodo para crear una nueva columna(Celda en android)
    private void nuevaCelda(){
        textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(25);
    }


    //metodo para crear el encabezado de la tabla
    private void crearEncabezado(){
        nuevaFila();

        nuevaCelda();
        textView.setText("Color");
        textView.setBackgroundColor(Color.parseColor(TR));
        tableRow.addView(textView,nuevosParametros());

        nuevaCelda();
        textView.setText("Cantidad de Usos");
        textView.setBackgroundColor(Color.parseColor(TR));
        tableRow.addView(textView,nuevosParametros());

        tablaC.addView(tableRow);
    }

    //metodo para agregar los datos
    private void agregarDatos(int[] arreglo){

        if(arreglo[0]>0){
            agregarColor("Azul",arreglo[0]);
        }

        if(arreglo[1]>0){
            agregarColor("Rojo",arreglo[1]);
        }

        if(arreglo[2]>0){
            agregarColor("Verde",arreglo[2]);
        }

        if(arreglo[3]>0){
            agregarColor("Amarillo",arreglo[3]);
        }

        if(arreglo[4]>0){
            agregarColor("Naranja",arreglo[4]);
        }

        if(arreglo[5]>0){
            agregarColor("Morado",arreglo[5]);
        }

        if(arreglo[6]>0){
            agregarColor("Café",arreglo[6]);
        }

        if(arreglo[7]>0){
            agregarColor("Negro",arreglo[7]);
        }


    }

    private void agregarColor(String nombreColor,int cantidadUsos){
        nuevaFila();
        nuevaCelda();
        textView.setText(nombreColor);
        textView.setBackgroundColor(Color.parseColor(TD));
        tableRow.addView(textView,nuevosParametros());
        nuevaCelda();
        textView.setText(String.valueOf(cantidadUsos));
        textView.setBackgroundColor(Color.parseColor(TD));
        tableRow.addView(textView,nuevosParametros());
        tablaC.addView(tableRow);
    }

    //metodo para asignar margenes a las celdas
    private TableRow.LayoutParams nuevosParametros(){
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams();
        layoutParams.setMargins(1,1,1,1);
        layoutParams.weight=1;
        return layoutParams;
    }

}
