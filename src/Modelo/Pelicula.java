/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.sql.*;

/**
 *
 * @author kamil
 */
public class Pelicula {
    private int idPelicula;
    private String titulo;
    private String director;
    private String origen;
    private String genero;
    private Date estreno;
    private boolean enCartelera;
    private RelacionFuncionPelicula relacionFuncionPelicula;

    public Pelicula() {
    }
    
    public Pelicula(String titulo, String director, 
            String origen, String genero, Date estreno, boolean enCartelera, RelacionFuncionPelicula relacionFuncionPelicula) {
        this.titulo = titulo;
        this.director = director;
        this.origen = origen;
        this.genero = genero;
        this.estreno = estreno;
        this.enCartelera = enCartelera;
        this.relacionFuncionPelicula = relacionFuncionPelicula;
    }
    
    public Pelicula(int idPelicula, String titulo, String director, 
            String origen, String genero, Date estreno, boolean enCartelera, RelacionFuncionPelicula relacionFuncionPelicula) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.director = director;

        this.origen = origen;
        this.genero = genero;
        this.estreno = estreno;
        this.enCartelera = enCartelera;
        this.relacionFuncionPelicula = relacionFuncionPelicula;
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

    public RelacionFuncionPelicula getRelacionFuncionPelicula() {
        return relacionFuncionPelicula;
    }

    public void setRelacionFuncionPelicula(RelacionFuncionPelicula relacionFuncionPelicula) {
        this.relacionFuncionPelicula = relacionFuncionPelicula;
    }
}
