package com.example.androidcompiler.Pintar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.graphics.Path;
import android.view.View;

import com.example.androidcompiler.Figuras.Circulo;
import com.example.androidcompiler.Figuras.Cuadrado;
import com.example.androidcompiler.Figuras.Figuras;
import com.example.androidcompiler.Figuras.Linea;
import com.example.androidcompiler.Figuras.Poligono;
import com.example.androidcompiler.Figuras.Rectangulo;

import java.util.ArrayList;

public class Dibujar extends View {

    //Recibimos el arreglo del objeto figuras que contiene todas instrucciones recibidas en el analizador sintactico
    private ArrayList<Figuras> figuras;
    //Hacemos uso de la clase paint propia de Android para dibujar las figuras
    Paint pintar = new Paint();
    //Constructor que recibe una vista y un arreglo de figuras
    public Dibujar(Context context, ArrayList<Figuras> figuras) {
    super(context);
    this.figuras=figuras;
    pintar.setStyle(Paint.Style.FILL);
    pintar.setStrokeWidth(5);
    }
    //Metodo que utiliza la clase canvas para dibujar
    public void onDraw(Canvas canvas){
        dibujarFiguras(figuras,canvas);
    }

    //Metodo que dibuja un circulo a raiz de lo ignresado por el usuario
    private void dibujarCirculo(Circulo circulo, Canvas canvas){
        pintar.setColor(Figuras.convertColor(circulo.getColor()));
        canvas.drawCircle(circulo.getPosX(),circulo.getPosY(),circulo.getRadio(),pintar);
    }
    //Metodo que dibuja un cuadrado a raiz de lo ignresado por el usuario
    private void dibujarCuadrado(Cuadrado cuadrado, Canvas canvas){
        pintar.setColor(Figuras.convertColor(cuadrado.getColor()));
        canvas.drawRect(cuadrado.getPosX(),cuadrado.getPosY(),cuadrado.getLado(),cuadrado.getLado(),pintar);
    }
    //Metodo que dibuja un rectangulo a raiz de lo ignresado por el usuario
    private void dibujarRectangulo(Rectangulo rectangulo, Canvas canvas){
        pintar.setColor(Figuras.convertColor(rectangulo.getColor()));
        canvas.drawRect(rectangulo.getPosX(),rectangulo.getPosY(),rectangulo.getAncho(),rectangulo.getAlto(),pintar);
    }
    //Metodo que dibuja una linea a raiz de lo ignresado por el usuario
    private void dibujarLinea(Linea linea, Canvas canvas) {
        pintar.setColor(Figuras.convertColor(linea.getColor()));
        canvas.drawLine(linea.getPosX(), linea.getPosY(), linea.getPosX1(), linea.getPosY1(), pintar);
    }
    //Metodo que dibuja un poligono a raiz de lo ignresado por el usuario
    //La clase canvas no tiene por defecto un metodo que dibujo un poligono para ello me ayudare de la clase drawPath
    private void dibujarPoligono(Poligono poligono,Canvas canvas){
        /*float limit1=poligono.getAlto()/2;
        float limit2=poligono.getAncho()/2;
        canvas.save();
        canvas.scale(limit1, limit2);

        Path trazo = new Path();
        pintar.setColor(Figuras.convertColor(poligono.getColor()));
        trazo.moveTo(canvas.getWidth() / 2, 550);
        trazo.lineTo(canvas.getWidth() / 2 + 100, 700);
        trazo.lineTo(canvas.getWidth() / 2 - 100, 700);
        trazo.close();
        canvas.drawPath(trazo, pintar);
        */

        float escalaX=poligono.getAlto()/2;
        float escalaY=poligono.getAncho()/2;
        pintar.setColor(Figuras.convertColor(poligono.getColor()));
        canvas.save();
        canvas.scale(escalaX, escalaY);
        //Declaramos un path que sera el trazo del pintar
        Path trazo = new Path();
        //Hacemos uso de la clase displaymetrics que nos servira para la describir en la pantalla
        float  size = 1, Xcenter = poligono.getPosX()/escalaX, Ycenter = poligono.getPosY()/escalaY;
        trazo.moveTo ((float)(Xcenter + size * Math.cos(0)), (float)(Ycenter + size * Math.sin(0)));
        for (int i = 1; i <= poligono.getCantLados(); i++) {
            trazo.lineTo ( (float)(Xcenter + size * Math.cos(i * 2 * Math.PI / poligono.getCantLados())), (float) (Ycenter + size * Math.sin(i * 2 * Math.PI / poligono.getCantLados())));
        }
        trazo.close();
        canvas.drawPath(trazo, pintar);
        canvas.restore();
    }

    //Este metodo se encarga de obtener las figuras del arreglo
    private void dibujarFiguras(ArrayList<Figuras> figuras,Canvas canvas){
        System.out.println("Tamano de las figuras ingresadas"+figuras.size());
        for (int i = 0; i <figuras.size();i++) {
            if(figuras.get(i).getClass()==Linea.class){
                dibujarLinea((Linea)figuras.get(i),canvas);
            }else if(figuras.get(i).getClass()==Cuadrado.class){
                dibujarCuadrado((Cuadrado)figuras.get(i),canvas);
            }else if(figuras.get(i).getClass()== Rectangulo.class){
                dibujarRectangulo((Rectangulo)figuras.get(i),canvas);
            }else if(figuras.get(i).getClass()==Circulo.class){
                dibujarCirculo((Circulo) figuras.get(i),canvas);
            }else if(figuras.get(i).getClass()== Poligono.class){
                dibujarPoligono((Poligono) figuras.get(i),canvas);
            }
        }
    }
}
