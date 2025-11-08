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
        String sql ="INSERT INTO pelicula (titulo,  director,  origen,  genero,  estreno,   enCartelera, idRelacionFuncionPelicula) VALUES (?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getTitulo());
            ps.setString(2, p.getDirector());
            ps.setString(4, p.getOrigen());
            ps.setString(5, p.getGenero());
            ps.setDate(6, new java.sql.Date(p.getEstreno().getTime()));
            ps.setBoolean(7, p.isEnCartelera());
            
            //aca como en asiento se llama al objeto relacionFuncionPelicula
            //el unico fin de ese objeto es relacionar una pelicula que aparece en muchas funciones
            //por lo demas se trata como hice en AsientoData
            ps.setInt(8, p.getRelacionFuncionPelicula().getIdRelacionFuncionPelicula());
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
                p.setOrigen(rs.getString("origen"));
                p.setGenero(rs.getString("genero"));
                p.setEstreno(rs.getDate("estreno"));
                p.setEnCartelera(rs.getBoolean("enCartelera"));
                }
            ps.close();
            } catch (SQLException ex) {
            System.out.println("❌ Error al buscar película: " + ex.getMessage());
            }
        return p;
    }
}
