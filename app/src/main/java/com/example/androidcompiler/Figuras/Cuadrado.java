package com.example.androidcompiler.Figuras;

public class Cuadrado extends Figuras{

    private float lado;

    public Cuadrado(float posX, float posY, float lado, String color, int instruccion) {
        super(posX, posY, color, instruccion);
        this.lado = lado;
    }

    public float getLado() {
        return lado;
    }

    public void setLado(float lado) {
        this.lado = lado;
    }
}
