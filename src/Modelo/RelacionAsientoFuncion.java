
package Modelo;

import java.util.*;

import java.util.ArrayList;

/**
 *
 * @author kamil
 */
public class RelacionAsientoFuncion {
    private int idRelacionAsientoFuncion;
    private Funcion funcion;
    private ArrayList<Asiento> asiento;  

    public RelacionAsientoFuncion() {
    }

    public RelacionAsientoFuncion(int idRelacionAsientoFuncion, Funcion funcion, ArrayList<Asiento> asiento) {
        this.idRelacionAsientoFuncion = idRelacionAsientoFuncion;
        this.funcion = funcion;
        this.asiento = asiento;
    }

    public RelacionAsientoFuncion(Funcion funcion, ArrayList<Asiento> asiento) {
        this.funcion = funcion;
        this.asiento = asiento;
    }
    
    

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


