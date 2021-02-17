package com.example.androidcompiler.Figuras;

public class Poligono extends Figuras{
    private float alto;
    private float ancho;
    private int cantLados;

    public Poligono( float posX, float posY, float alto, float ancho, int cantLados, String color, int instruccion) {
        super(posX, posY, color, instruccion);
        this.alto = alto;
        this.ancho = ancho;
        this.cantLados = cantLados;
    }

    public float getAlto() {
        return alto;
    }

    public void setAlto(float alto) {
        this.alto = alto;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public int getCantLados() {
        return cantLados;
    }

    public void setCantLados(int cantLados) {
        this.cantLados = cantLados;
    }
}
