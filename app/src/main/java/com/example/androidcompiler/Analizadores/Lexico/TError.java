package com.example.androidcompiler.Analizadores.Lexico;

import android.os.Parcel;
import android.os.Parcelable;

;

/**
 *
 * @author jara
 */
public class TError implements Parcelable {

    private String lexema;
    private String tipo;
    private String descripcion;
    private int line;
    private int columna;

    public TError(String le, int li, int col, String ti, String desc) {
        lexema = le;
        tipo = ti;
        descripcion = desc;
        line = li;
        columna = col;
    }
    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    protected TError(Parcel in) {
        tipo = in.readString();
        line = in.readInt();
        columna = in.readInt();
        lexema = in.readString();
        descripcion = in.readString();

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
