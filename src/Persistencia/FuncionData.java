/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.*;
import java.sql.*;
import java.util.*;


/**
 *
 * @author kamil
 */
public class FuncionData {
    //CONECTAR
    private Connection conexion=null;
    
    public FuncionData(){
        conexion =  Conexion.getConexion();
    }
    
    //INSERTAR
    public void guardarFuncion(Funcion f){
        String sql ="INSERT INTO funcion ( idPelicula,  idSala,  idioma,  es3D,  subtitulada,  horaInicio,  horaFin,  precio) VALUES (?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, f.getIdPelicula());
            ps.setInt(2, f.getIdSala());
            ps.setString(3, f.getIdioma());
            ps.setBoolean(4, f.isEs3D());
            ps.setBoolean(5, f.isSubtitulada());
            ps.setDate(6, new java.sql.Date(f.getHoraInicio().getTime()));
            ps.setDate(7, new java.sql.Date(f.getHoraFin().getTime()));
            ps.setDouble(8, f.getPrecio());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) f.setIdFuncion(rs.getInt(1));
            
            ps.close();
            
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }
    
    
    //BUSCAR POR ID
    public Funcion buscarFuncion(int id){
        Funcion f=null;
        String sql ="SELECT * FROM funcion WHERE idFuncion=?";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                f = new Funcion();
                f.setIdFuncion(id);
                f.setIdPelicula(rs.getInt("idPelicula"));
                f.setIdSala(rs.getInt("idSala"));
                f.setIdioma(rs.getString("idioma"));
                f.setEs3D(rs.getBoolean("es3D"));
                f.setSubtitulada(rs.getBoolean("subtitulada"));
                f.setHoraInicio(rs.getTimestamp("horaInicio"));
                f.setHoraFin(rs.getTimestamp("horaFin"));
                f.setPrecio(rs.getDouble("precio"));
                }   
            ps.close();
            } catch (SQLException ex) {
                System.out.println("Error al buscar funcion: " + ex.getMessage());
            }
        return f;
    }
   
}
