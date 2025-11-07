/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.*;
import java.sql.*;
import java.util.*;


public class AsientoData {
    
    //CONECTAR
    private Connection conexion=null;
    
    public AsientoData(Conexion conexion1){
        conexion =  Conexion.getConexion();
    }
    
    //INSERTAR
    public void insertar(Asiento a){
        String sql = "INSERT INTO asiento (idFuncion, codLugar, fila, numero, estado) VALUES (?, ?, ?, ?,? )";
        try{ 
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, a.getIdFuncion());
            ps.setString(2, a.getCodLugar());
            ps.setString(3, a.getFila());
            ps.setInt(4, a.getNumero());
            ps.setBoolean(5, a.isEstado());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) a.setIdAsiento(rs.getInt(1));
            
            ps.close();
                
        } catch (SQLException ex) {
            System.out.println("Error al guardar asiento:" +ex.getMessage());
        } 
    }
    
    //BUSCAR POR ID
    public Asiento buscarAsiento(int id) {
        Asiento a = null;
        String sql ="SELECT * FROM asiento WHERE idAsiento=?";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
        
            ResultSet rs= ps.executeQuery();
            if (rs.next()){ 
                a = new Asiento(
                        rs.getInt(id),
                        rs.getInt("idFuncion"),
                        rs.getString("codLugar"),
                        rs.getString("fila"),
                        rs.getInt("numero"),
                        rs.getBoolean("estado")
                        );
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar asiento: " + ex.getMessage());
        }
        return a;
    }
   
    //LISTAR TODOS
    public List<Asiento> listarAsientos(){
        List<Asiento> lista = new ArrayList<>();
        String sql ="SELECT * FROM asiento";
        
        try{
            PreparedStatement ps= conexion.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            
            while(rs.next()){
                Asiento a= new Asiento(
                        rs.getInt("idAsiento"),
                        rs.getInt("idFuncion"),
                        rs.getString("codLugar"),
                        rs.getString("fila"),
                        rs.getInt("numero"),
                        rs.getBoolean("estado")
                    );
                lista.add(a);
            }
            ps.close();
        }   catch(SQLException ex){
            System.out.println("Erros: "+ex.getMessage());
        }
        return lista;
    }
    
    //ACTUALIZAR
    public void actualizarAsiento(Asiento a){
        String sql ="UPDATE asiento SET idFuncion=?, codLugar=?, fila=?, numero=?, estado=? WHERE idAsiento=?";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, a.getIdFuncion());
            ps.setString(2, a.getCodLugar());
            ps.setString(3, a.getFila());
            ps.setInt(4, a.getNumero());
            ps.setBoolean(5, a.isEstado());
            
            ps.executeUpdate();
            ps.close();
        } catch(SQLException ex){
            System.out.println("Error:" +ex.getMessage());
        }
    }
    
    // BAJA LOGICA
    public void darDeBaja(int id) {
        String sql = "UPDATE asiento SET estado = 0 WHERE idAsiento = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al dar de baja asiento: " + ex.getMessage());
        }
    }
    
    
}
