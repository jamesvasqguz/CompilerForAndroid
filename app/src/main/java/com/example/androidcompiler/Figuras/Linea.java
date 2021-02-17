package com.example.androidcompiler.Figuras;

public class Linea extends Figuras{

    private float posX1;
    private float posY1;

    public Linea(float posX, float posY, float posX1, float posY1, String color, int instruccion) {
        super(posX, posY, color, instruccion);
        this.posX1 = posX1;
        this.posY1 = posY1;
    }

    public float getPosX1() {
        return posX1;
    }

    public void setPosX1(float posX1) {
        this.posX1 = posX1;
    }

    public float getPosY1() {
        return posY1;
    }

    public void setPosY1(float posY1) {
        this.posY1 = posY1;
    }
}
