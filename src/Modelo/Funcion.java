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
    private Pelicula idPelicula;
    private Sala idSala;
    private String idioma;
    private boolean es3D; 
    private boolean subtitulada;
    private Date horaInicio;
    private Date horaFin;
    private ArrayList<Asiento> listaDeLugaresDisponibles;
    private double precio;

    public Funcion() {
        this.listaDeLugaresDisponibles = new ArrayList<>();
    }


    public Funcion(int idFuncion, Pelicula idPelicula, Sala idSala, String idioma, boolean es3D,
               boolean subtitulada, Date horaInicio, Date horaFin, double precio) {
        this.idFuncion = idFuncion;
        this.idPelicula = idPelicula;
        this.idSala = idSala;
        this.idioma = idioma;
        this.es3D = es3D;
        this.subtitulada = subtitulada;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.precio = precio;
        this.listaDeLugaresDisponibles = new ArrayList<>();
    }

    
    public Funcion(Pelicula idPelicula, Sala idSala, String idioma, boolean es3D,
               boolean subtitulada, Date horaInicio, Date horaFin, double precio) {
        this.idPelicula = idPelicula;
        this.idSala = idSala;
        this.idioma = idioma;
        this.es3D = es3D;
        this.subtitulada = subtitulada;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.precio = precio;
        this.listaDeLugaresDisponibles = new ArrayList<>();
    }

    
    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

    public Pelicula getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Pelicula idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Sala getIdSala() {
        return idSala;
    }

    public void setIdSala(Sala idSala) {
        this.idSala = idSala;
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

    public ArrayList<Asiento> getListaDeLugaresDisponibles() {
        return listaDeLugaresDisponibles;
    }

    public void setListaDeLugaresDisponibles(ArrayList<Asiento> listaDeLugaresDisponibles) {
        this.listaDeLugaresDisponibles = listaDeLugaresDisponibles;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
