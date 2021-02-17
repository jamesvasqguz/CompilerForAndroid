package com.example.androidcompiler.Figuras;

public class Rectangulo extends Figuras {

    private float alto;
    private float ancho;

    public Rectangulo(float posicionX, float posicionY, float alto, float ancho, String color, int lineaInstruccion) {
        super(posicionX, posicionY, color, lineaInstruccion);
        this.alto = alto;
        this.ancho = ancho;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getAlto() {
        return alto;
    }

    public void setAlto(float alto) {
        this.alto = alto;
    }
}
