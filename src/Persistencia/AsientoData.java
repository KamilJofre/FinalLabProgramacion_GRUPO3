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
    
    //INSERTAR inserta datos
    public void insertar(Asiento a){
        String sql = "INSERT INTO asiento (idFuncion, codLugar, fila, numero, estado) VALUES (?, ?, ?, ?,? )";
        try{ 
            //metodos para llevarle los datos a la base
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            //ahi lo que pasa es que es un objetio del tipo Funcion
            //entonces tenes q llamar al objeto mediante getFuncion()
            //y a ese objeto pedirle la id
            ps.setInt(1, a.getFuncion().getIdFuncion());
            
            ps.setString(2, a.getCodLugar());
            ps.setString(3, a.getFila());
            ps.setInt(4, a.getNumero());
            ps.setBoolean(5, a.isEstado());
            
            // ahi le manda eso a la base
            ps.executeUpdate();
            
            //aca genera la Key i la setea
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) a.setIdAsiento(rs.getInt(1));
            
            ps.close();
                
        } catch (SQLException ex) {
            System.out.println("Error al guardar asiento:" +ex.getMessage());
        } 
    }
    
    //BUSCAR POR ID
    public Asiento buscarAsiento(int id) {
        //Inicializa un objeto a vacio
        Asiento a = null;
        //aclaracion de que y donde para SQL
        String sql ="SELECT * FROM asiento WHERE idAsiento=?";
        
        try {
            //metodo para llevar datos a la base
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
        
            ResultSet rs = ps.executeQuery();
            if (rs.next()) { 
                
                //aca hay un objeto funcion, entonces se crea y le pide su id
                //no estoy seguro de como llamar al objeto que queremos en especifico
                //pero es un avance
                Funcion f = new Funcion();
                f.setIdFuncion(rs.getInt("idFuncion"));
                a = new Asiento(
                    rs.getInt("idAsiento"),
                        
                    //aca le da el fato f del objeto q hicimos antes
                    f,
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
                //mas de lo mismo
                Funcion f = new Funcion();
                f.setIdFuncion(rs.getInt("idFuncion"));
                Asiento a= new Asiento(
                        rs.getInt("idAsiento"),
                        f,
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
            //devuelta
            ps.setInt(1, a.getFuncion().getIdFuncion());
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
