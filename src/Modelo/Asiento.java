/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Modelo.*;
/**
 *
 * @author kamil
 */
public class Asiento {
    private int idAsiento;
    private Funcion funcion;
    private String codLugar;
    private String fila;
    private int numero;
    private boolean estado;

    public Asiento() {}

    public Asiento(int idAsiento, Funcion funcion, String codLugar, String fila, int numero, boolean estado) {
        this.idAsiento = idAsiento;
        this.funcion = funcion;
        this.codLugar = codLugar;
        this.fila = fila;
        this.numero = numero;
        this.estado = estado;
    }
    
    public Asiento(Funcion funcion, String codLugar, String fila, int numero, boolean estado) {
        this.funcion = funcion;
        this.codLugar = codLugar;
        this.fila = fila;
        this.numero = numero;
        this.estado = estado;
    }

    public int getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(int idAsiento) {
        this.idAsiento = idAsiento;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public String getCodLugar() {
        return codLugar;
    }

    public void setCodLugar(String codLugar) {
        this.codLugar = codLugar;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
