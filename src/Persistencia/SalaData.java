/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Sala;
import Modelo.*;
import java.sql.Connection;
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
public class SalaData {
    //conectar
    private Connection conexion=null;
    
    public SalaData(Conexion conexion1){
        conexion =  Conexion.getConexion();
    }
    
    //INSERTAR inserta datos
    public void insertar(Sala s){
        String sql = "INSERT INTO sala (NroSala, apta3D, capacidad, estado) VALUES (?, ?, ?, ?)";
        try{ 
            //metodos para llevarle los datos a la base
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            //ahi lo que pasa es que es un objetio del tipo Funcion
            //entonces tenes q llamar al objeto mediante getFuncion()
            //y a ese objeto pedirle la id
            ps.setInt(1, s.getCapacidad());
            ps.setBoolean(2, s.isApta3D());
            ps.setBoolean(3, s.isEstado());
            
            // ahi le manda eso a la base
            ps.executeUpdate();
            
            //aca genera la Key y la setea
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) s.setNroSala(rs.getInt(1));
            
            ps.close();
                
        } catch (SQLException ex) {
            System.out.println("Error al guardar sala:" +ex.getMessage());
        } 
    }
    
    //BUSCAR X ID
    public Sala buscarSala(int NroSala) {
        Sala s = null;
        String sql ="SELECT * FROM sala WHERE NroSala=?";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, NroSala);
        
            ResultSet rs= ps.executeQuery();
            if (rs.next()){ 
                s = new Sala(
                        rs.getInt("NroSala"),
                        rs.getBoolean("apta3D"),
                        rs.getInt("capacidad"),
                        rs.getBoolean("estado")
                        );
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return s;
    }
    
    //LISTAR TODOS
    public List<Sala> listarSalas(){
        List<Sala> lista = new ArrayList<>();
        String sql ="SELECT * FROM sala";
        
        try{
            PreparedStatement ps= conexion.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            
            while(rs.next()){
                //mas de lo mismo
                
                Sala s= new Sala(
                        rs.getInt("NroSala"),
                        rs.getBoolean("apta3D"),
                        rs.getInt("capacidad"),
                        rs.getBoolean("estado")
                    );
                lista.add(s);
            }
            ps.close();
        }   catch(SQLException ex){
            System.out.println("Erros: "+ex.getMessage());
        }
        return lista;
    }
    
    //ACTUALIZAR
    public void actualizarSala(Sala s){
        String sql ="UPDATE sala SET apta3D=?, capacidad=?, estado=? WHERE NroSala=?";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            //devuelta
            ps.setInt(1, s.getNroSala());
            ps.setBoolean(2, s.isApta3D());
            ps.setInt(3, s.getCapacidad());
            ps.setBoolean(4, s.isEstado());
            
            ps.executeUpdate();
            ps.close();
        } catch(SQLException ex){
            System.out.println("Error:" +ex.getMessage());
        }
    }
    
    // BAJA LOGICA
    public void darDeBaja(int NroSala) {
        String sql = "UPDATE sala SET estado = 0 WHERE NroSala = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, NroSala);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al dar de baja sala: " + ex.getMessage());
        }
    }
}
