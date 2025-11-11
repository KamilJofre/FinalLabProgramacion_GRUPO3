/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Modelo.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kamil
 */
public class Funcion {
    private int idFuncion;
    private Pelicula pelicula;
    private Sala sala;
    private String idioma;
    private boolean es3D; 
    private boolean subtitulada;
    private Date horaInicio;
    private Date horaFin;
    private RelacionAsientoFuncion relacionAsientoFuncion;
    private double precio;

    public Funcion() {
    }


    public Funcion(int idFuncion, Pelicula pelicula, Sala sala, String idioma, boolean es3D,
               boolean subtitulada, Date horaInicio, Date horaFin, 
               RelacionAsientoFuncion relacionAsientoFuncion, double precio) {
        this.idFuncion = idFuncion;
        this.pelicula = pelicula;
        this.sala = sala;
        this.idioma = idioma;
        this.es3D = es3D;
        this.subtitulada = subtitulada;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.relacionAsientoFuncion = relacionAsientoFuncion;
        this.precio = precio;
    }

    
    public Funcion(Pelicula pelicula, Sala sala, String idioma, boolean es3D,
               boolean subtitulada, Date horaInicio, Date horaFin,
               RelacionAsientoFuncion relacionAsientoFuncion, double precio) {
        this.pelicula = pelicula;
        this.sala = sala;
        this.idioma = idioma;
        this.es3D = es3D;
        this.subtitulada = subtitulada;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.relacionAsientoFuncion = relacionAsientoFuncion;
        this.precio = precio;
    }

    
    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public boolean isEs3D() {
        return es3D;
    }

    public void setEs3D(boolean es3D) {
        this.es3D = es3D;
    }

    public boolean isSubtitulada() {
        return subtitulada;
    }

    public void setSubtitulada(boolean subtitulada) {
        this.subtitulada = subtitulada;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public RelacionAsientoFuncion getRelacionAsientoFuncion() {
        return relacionAsientoFuncion;
    }

    public void setRelacionAsientoFuncion(RelacionAsientoFuncion relacionAsientoFuncion) {
        this.relacionAsientoFuncion = relacionAsientoFuncion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
