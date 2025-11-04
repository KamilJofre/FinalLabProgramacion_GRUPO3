/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kamil
 */
public class Pelicula {
    private int idPelicula;
    private String titulo;
    private String director;
    private ArrayList<String> actores;
    private String origen;
    private String genero;
    private Date estreno;
    private boolean enCartelera;
    private ArrayList<Funcion> funcion;

    public Pelicula(ArrayList<String> actores, ArrayList<Funcion> funcion) {
        this.actores = new ArrayList<>();
        this.funcion = new ArrayList<>();
    }
    
    public Pelicula(String titulo, String director, ArrayList<String> actores, 
            String origen, String genero, Date estreno, boolean enCartelera, ArrayList<Funcion> funcion) {
        this.titulo = titulo;
        this.director = director;
        this.actores = actores;
        this.origen = origen;
        this.genero = genero;
        this.estreno = estreno;
        this.enCartelera = enCartelera;
        this.funcion = new ArrayList<>();
    }
    
    public Pelicula(int idPelicula, String titulo, String director, ArrayList<String> actores, 
            String origen, String genero, Date estreno, boolean enCartelera, ArrayList<Funcion> funcion) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.director = director;
        this.actores = actores;
        this.origen = origen;
        this.genero = genero;
        this.estreno = estreno;
        this.enCartelera = enCartelera;
        this.funcion = new ArrayList<>();
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public ArrayList<String> getActores() {
        return actores;
    }

    public void setActores(ArrayList<String> actores) {
        this.actores = actores;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getEstreno() {
        return estreno;
    }

    public void setEstreno(Date estreno) {
        this.estreno = estreno;
    }

    public boolean isEnCartelera() {
        return enCartelera;
    }

    public void setEnCartelera(boolean enCartelera) {
        this.enCartelera = enCartelera;
    }

    public ArrayList<Funcion> getFuncion() {
        return funcion;
    }

    public void setFuncion(ArrayList<Funcion> funcion) {
        this.funcion = funcion;
    }

    public Object getHoraInicio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
