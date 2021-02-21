/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.androidcompiler.Operadores;

import android.os.Parcelable;
import android.os.Parcel;

/**
 *
 * @author jara
 */
public class Ocurrencia implements Parcelable {
    private String operador;
    private int linea;
    private int columna;
    private String ocurrencia;
    
    public Ocurrencia(String operador, int linea, int columna, String ocurrencia) {
        this.operador = operador;
        this.linea = linea;
        this.columna = columna;
        this.ocurrencia = ocurrencia;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getOcurrencia() {
        return ocurrencia;
    }

    public void setOcurrencia(String ocurrencia) {
        this.ocurrencia = ocurrencia;
    }

    protected Ocurrencia(Parcel in) {
        operador=in.readString();
        linea = in.readInt();
        columna = in.readInt();
        ocurrencia = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(operador);
        parcel.writeInt(linea);
        parcel.writeInt(columna);
        parcel.writeString(ocurrencia);
    }
    public static final Creator<Ocurrencia> CREATOR = new Creator<Ocurrencia>() {
        @Override
        public Ocurrencia createFromParcel(Parcel in) {
            return new Ocurrencia(in);
        }

        @Override
        public Ocurrencia[] newArray(int size) {
            return new Ocurrencia[size];
        }
    };
}
