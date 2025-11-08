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
public class relacionFuncionPelicula {
    private int idRelacionFuncionPelicula;
    private Pelicula pelicula;
    private ArrayList<Funcion> funcion;

    public relacionFuncionPelicula(ArrayList<Funcion> funcion) {
        this.funcion = funcion;
    }
    
    

    public relacionFuncionPelicula(int idRelacionFuncionPelicula, Pelicula pelicula) {
        this.idRelacionFuncionPelicula = idRelacionFuncionPelicula;
        this.pelicula = pelicula;
    }

    public relacionFuncionPelicula(Pelicula pelicula, ArrayList<Funcion> funcion) {
        this.pelicula = pelicula;
        this.funcion = funcion;
    }
    
    

    public int getIdRelacionFuncionPelicula() {
        return idRelacionFuncionPelicula;
    }

    public void setIdRelacionFuncionPelicula(int idRelacionFuncionPelicula) {
        this.idRelacionFuncionPelicula = idRelacionFuncionPelicula;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public ArrayList<Funcion> getFuncion() {
        return funcion;
    }

    public void setFuncion(ArrayList<Funcion> funcion) {
        this.funcion = funcion;
    }
    
    
}
