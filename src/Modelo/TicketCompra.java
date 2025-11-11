/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Modelo.*;
import java.util.Date;

/**
 *
 * @author kamil
 */
public class TicketCompra {
    private int idTicketCompra;
    private Comprador comprador;
    private Asiento asiento;
    private Date fechaCompra;
    private Date fechaFuncion;
    private double monto;

    public TicketCompra() {
    }

    public TicketCompra(int idTicketCompra, Comprador comprador, Asiento asiento, Date fechaCompra, Date fechaFuncion, double monto) {
        this.idTicketCompra = idTicketCompra;
        this.comprador = comprador;
        this.asiento = asiento;
        this.fechaCompra = fechaCompra;
        this.fechaFuncion = fechaFuncion;
        this.monto = monto;
    }

    public TicketCompra(Comprador comprador, Asiento asiento, Date fechaCompra, Date fechaFuncion, double monto) {
        this.comprador = comprador;
        this.asiento = asiento;
        this.fechaCompra = fechaCompra;
        this.fechaFuncion = fechaFuncion;
        this.monto = monto;
    }
    
    

    public int getIdTicketCompra() {
        return idTicketCompra;
    }

    public void setIdTicketCompra(int idTicketCompra) {
        this.idTicketCompra = idTicketCompra;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setIdComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Date getFechaFuncion() {
        return fechaFuncion;
    }

    public void setFechaFuncion(Date fechaFuncion) {
        this.fechaFuncion = fechaFuncion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    
    
}
