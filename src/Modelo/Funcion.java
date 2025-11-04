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
    private int idPelicula;
    private int idSala;
    private String idioma;
    private boolean es3D; 
    private boolean subtitulada;
    private Date horaInicio;
    private Date horaFin;
    private ArrayList<Asiento> listaDeLugaresDisponibles;
    private double precio;

    public Funcion(){}

    public Funcion(int idFuncion, int idPelicula, int idSala, String idioma, boolean es3D, boolean subtitulada, Date horaInicio, Date horaFin, ArrayList<Asiento> listaDeLugaresDisponibles, double precio) {
        this.idFuncion = idFuncion;
        this.idPelicula = idPelicula;
        this.idSala = idSala;
        this.idioma = idioma;
        this.es3D = es3D;
        this.subtitulada = subtitulada;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.listaDeLugaresDisponibles = listaDeLugaresDisponibles;
        this.precio = precio;
    }
    
    public Funcion(int idPelicula, int idSala, String idioma, boolean es3D, boolean subtitulada, Date horaInicio, Date horaFin, ArrayList<Asiento> listaDeLugaresDisponibles, double precio) {
        this.idPelicula = idPelicula;
        this.idSala = idSala;
        this.idioma = idioma;
        this.es3D = es3D;
        this.subtitulada = subtitulada;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.listaDeLugaresDisponibles = listaDeLugaresDisponibles;
        this.precio = precio;
    }
    
    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
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
