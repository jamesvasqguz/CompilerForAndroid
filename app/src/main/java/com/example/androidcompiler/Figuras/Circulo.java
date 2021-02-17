package com.example.androidcompiler.Figuras;

public class Circulo extends Figuras{

    private float radio;

    public Circulo(float posicionX, float posicionY, float radio, String color, int lineaInstruccion) {
        super(posicionX, posicionY, color, lineaInstruccion);
        this.radio = radio;
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }
}
