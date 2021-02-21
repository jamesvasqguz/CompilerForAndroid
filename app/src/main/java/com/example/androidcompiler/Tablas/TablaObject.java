package com.example.androidcompiler.Tablas;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class TablaObject {
    private static final String TR = "#87CEEB";
    private static final String TD = "#F5F5F5";

    private TableLayout tablaOb;
    private Context context;
    private TableRow tableRow;
    private TextView textView;

    public TablaObject(TableLayout tablaOb, Context context) {
        this.tablaOb = tablaOb;
        this.context = context;
    }

    //metodo general para crear la tabla
    public void listarObjetos(int[] usados,int cantidad){
        crearEncabezado();
        agregarDatos(usados,cantidad);
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
        textView.setText("Objeto");
        textView.setBackgroundColor(Color.parseColor(TR));
        tableRow.addView(textView,nuevosParametros());

        nuevaCelda();
        textView.setText("Cantidad de Usos");
        textView.setBackgroundColor(Color.parseColor(TR));
        tableRow.addView(textView,nuevosParametros());

        tablaOb.addView(tableRow);
    }

    //metodo para agregar los datos
    private void agregarDatos(int[] arreglo,int cantidad){
        if(arreglo[8]>0){
            agregarObjeto("Circulo",arreglo[8]);
        }
        if(arreglo[9]>0){
            agregarObjeto("Cuadrado",arreglo[9]);
        }
        if(arreglo[10]>0){
            agregarObjeto("Rectangulo",arreglo[10]);
        }
        if(arreglo[11]>0){
            agregarObjeto("Poligono",arreglo[11]);
        }
        if(arreglo[12]>0){
            agregarObjeto("Linea",arreglo[12]);
        }
        if(arreglo[13]>0){
            agregarObjeto("Curva",arreglo[13]);
        }
    }

    private void agregarObjeto(String objeto,int cantidadUsos){
        nuevaFila();
        nuevaCelda();
        textView.setText(objeto);
        textView.setBackgroundColor(Color.parseColor(TD));
        tableRow.addView(textView,nuevosParametros());
        nuevaCelda();
        textView.setText(String.valueOf(cantidadUsos));
        textView.setBackgroundColor(Color.parseColor(TD));
        tableRow.addView(textView,nuevosParametros());
        tablaOb.addView(tableRow);
    }

    //metodo para asignar margenes a las celdas
    private TableRow.LayoutParams nuevosParametros(){
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams();
        layoutParams.setMargins(1,1,1,1);
        layoutParams.weight=1;
        return layoutParams;
    }
}
