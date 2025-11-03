/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Modelo.Funcion;
/**
 *
 * @author kamil
 */
public class Asiento {
    private int idAsiento;
    private int idFuncion;
    private String codLugar;
    private String fila;
    private int numero;
    private boolean estado;

    public Asiento() {}

    public Asiento(int idAsiento, int idFuncion, String codLugar, String fila, int numero, boolean estado) {
        this.idAsiento = idAsiento;
        this.idFuncion = idFuncion;
        this.codLugar = codLugar;
        this.fila = fila;
        this.numero = numero;
        this.estado = estado;
    }
    
    public Asiento(int idFuncion, String codLugar, String fila, int numero, boolean estado) {
        this.idFuncion = idFuncion;
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

    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
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
