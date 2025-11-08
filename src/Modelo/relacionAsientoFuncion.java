/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.*;

/**
 *
 * @author kamil
 */
public class relacionAsientoFuncion {
    private int idRelacionAsientoFuncion;
    private Funcion funcion;
    private ArrayList<Asiento> asiento;  

    public int getIdRelacionAsientoFuncion() {
        return idRelacionAsientoFuncion;
    }

    public void setIdRelacionAsientoFuncion(int idRelacionAsientoFuncion) {
        this.idRelacionAsientoFuncion = idRelacionAsientoFuncion;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public ArrayList<Asiento> getAsiento() {
        return asiento;
    }

    public void setAsiento(ArrayList<Asiento> asiento) {
        this.asiento = asiento;
    }
}


