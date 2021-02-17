package com.example.androidcompiler.Figuras;

import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.provider.CalendarContract;

public class Figuras{

    private float posX;
    private float posY;
    private String color;
    private int instruccion;

    public Figuras(float posX, float posY, String color, int instruccion) {
        this.posX = posX;
        this.posY = posY;
        this.color = color;
        this.instruccion = instruccion;
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getInstruccion() {
        return instruccion;
    }

    public void setInstruccion(int instruccion) {
        this.instruccion = instruccion;
    }

    public static int convertColor(String color){
        switch (color){
            case "negro":
                return Color.parseColor("#000000");

            case "azul":
                return Color.parseColor("#3F51B5");

            case "rojo":
                return Color.parseColor("#E53935");

            case "verde":
                return Color.parseColor("#009688");

            case "naranja":
                return Color.parseColor("#EF6C00");

            case "amarillo":
                return Color.parseColor("#FFEB3B");

            case "cafe":
                return Color.parseColor("#795548");

            case "morado":
                return Color.parseColor("#673AB7");

            default:
                return Color.parseColor("#607D8B");
        }
    }
}
