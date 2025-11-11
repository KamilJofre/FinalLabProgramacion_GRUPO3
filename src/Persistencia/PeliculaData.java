/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.sql.Connection;
import Modelo.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author kamil
 */
public class PeliculaData {
    //CONECTAR
    private Connection conexion=null;
    
    public PeliculaData(Connection con){
        conexion =  Conexion.getConexion();
    }
    
    //INSERTAR
    public void guardarPelicula(Pelicula p){
        String sql ="INSERT INTO pelicula (titulo,  director,  actores,  origen,  genero,  estreno,   enCartelera) VALUES (?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getTitulo());
            ps.setString(2, p.getDirector());
            
            // Actores -> texto
            ps.setString(3, String.join(",", p.getActores()));
            ps.setString(4, p.getOrigen());
            ps.setDate(5, new java.sql.Date(p.getEstreno().getTime()));

            ps.setBoolean(7, p.isEnCartelera());
           
            //Funciones->texto
            ps.setString(8, p.getIdFuncion());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) p.setIdPelicula(rs.getInt(1));
            
            ps.close();
            
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }
    
    //BUSCAR
    public Pelicula buscarPelicula(int id){
        Pelicula p=null;
        String sql="SELECT * FROM pelicula WHERE idPelicula=?";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p = new Pelicula();
                p.setIdPelicula(rs.getInt("idPelicula"));
                p.setTitulo(rs.getString("titulo"));
                p.setDirector(rs.getString("director"));

                // Convierte texto a ArrayList<String>
                String actores = rs.getString("actores");
                List<String> listaActores = Arrays.asList(actores.split(","));
                p.setActores(new ArrayList<>(listaActores));
 
                p.setOrigen(rs.getString("origen"));
                p.setGenero(rs.getString("genero"));
                p.setEstreno(rs.getDate("estreno"));
                p.setEnCartelera(rs.getBoolean("enCartelera"));
                
                // Convierte texto a ArrayList<String>
                String funcion = rs.getString("funcion");
                List<String> listaFunciones = Arrays.asList(funcion.split(","));
                p.setFuncion(new ArrayList<>(listaFunciones));
                }
            ps.close();
            } catch (SQLException ex) {
            System.out.println("❌ Error al buscar película: " + ex.getMessage());
            }
        return p;
    }
}
