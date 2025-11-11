/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Comprador;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kamil
 */
public class CompradorData {
    
    //CONECTAR
    private Connection conexion=null;
    
    public CompradorData(Conexion conexion1){
        conexion =  Conexion.getConexion();
    }
    
    //INSERTAR
    public void insertar(Comprador c){
        String sql = "INSERT INTO comprador (dni, nombre, fechaNac, password, medioPago) VALUES (?, ?, ?, ?, ?)";
        try{ 
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, c.getDni());
            ps.setString(2, c.getNombre());
            ps.setDate(3, new java.sql.Date(c.getFechaNac().getTime()));
            ps.setString(4, c.getPassword());
            ps.setString(5, c.getMedioPago());
            
            ps.executeUpdate();
            
           
            
            ps.close();
                
        } catch (SQLException ex) {
            System.out.println("Error: " +ex.getMessage());
        } 
    }
    
    //BUSCAR X ID
    public Comprador buscarComprador(int id) {
        Comprador c = null;
        String sql ="SELECT * FROM comprador WHERE dni=?";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
        
            ResultSet rs= ps.executeQuery();
            if (rs.next()){ 
                c = new Comprador(
                        rs.getInt("dni"),
                        rs.getString("nombre"),
                        rs.getDate("fechaNac"),
                        rs.getString("password"),
                        rs.getString("medioPago")
                        );
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return c;
    }
   
    //LISTAR TODOS
    public List<Comprador> listarCompradores(){
        List<Comprador> lista = new ArrayList<>();
        String sql ="SELECT * FROM comprador";
        
        try{
            PreparedStatement ps= conexion.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            
            while(rs.next()){
                Comprador c = new Comprador(
                        rs.getInt("dni"),
                        rs.getString("nombre"),
                        rs.getDate("fechaNac"),
                        rs.getString("password"),
                        rs.getString("medioPago")
                );
                lista.add(c);
            }
            ps.close();
        }   catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
        }
        return lista;
    }
    
    //ACTUALIZAR
    public void actualizarComprador(Comprador c){
        String sql = "UPDATE comprador SET dni=?, nombre=?, fechaNac=?, password=?, medioPago=? WHERE dni=?";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, c.getDni());
            ps.setString(2, c.getNombre());
            ps.setDate(3, (Date) c.getFechaNac());
            ps.setString(4, c.getPassword());
            ps.setString(5, c.getMedioPago());
            
            ps.executeUpdate();
            ps.close();
        } catch(SQLException ex){
            System.out.println("Error: " +ex.getMessage());
        }
    }
    
    // BAJA LOGICA
    public void darDeBaja(int dni) {
        String sql = "DELETE FROM comprador WHERE dni = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, dni);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar comprador: " + ex.getMessage());
        }
        }
}
