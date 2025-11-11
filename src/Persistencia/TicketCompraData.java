/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;


/**
 *
 * @author kamil
 */
public class TicketCompraData {
    //CONECTAR
    private Connection conexion=null;
    
    public TicketCompraData(Connection con){
        conexion =  Conexion.getConexion();
    }
    
    //INSERTAR
    public void guardarTicket(TicketCompra t){
        String sql ="INSERT INTO funcion ( comprador,  asiento,  fechaCompra,  fechaFuncion,  monto) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, t.getComprador().getDni());
            ps.setInt(2, t.getAsiento().getIdAsiento());
            ps.setTimestamp(3, new Timestamp(t.getFechaCompra().getTime())); 
            ps.setTimestamp(4, new Timestamp(t.getFechaFuncion().getTime())); 
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) t.setIdTicketCompra(rs.getInt(1));
            
            ps.close();
            
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }
    
    //BUSCAR POR ID
    public TicketCompra buscarTicketCompra(int id){
        TicketCompra t=null;
        String sql ="SELECT * FROM TicketCompra WHERE idTicketCompra=?";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
                if (rs.next()) { 
                    Comprador c = new Comprador();
                    c.setDni(rs.getInt("Dni"));
                    
                    Asiento a =  new Asiento();
                    a.setIdAsiento(rs.getInt("idAsiento"));
                    
                    t = new TicketCompra(
                        rs.getInt("idTicketCompra"),
                        c,
                        a,
                        rs.getDate("fechCompra"),
                        rs.getDate("fechaFuncion"),
                        rs.getDouble("monto")
                    );
                }
                ps.close();
            } catch (SQLException ex) {
                System.out.println("Error al buscar TikcetCompra: " + ex.getMessage());
            }
        return t;
    }
    
    //LISTAR
    public ArrayList<TicketCompra> listarTicketCompra() {
        ArrayList<TicketCompra> lista = new ArrayList<>();
        String sql = "SELECT * FROM ticketCompra";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                TicketCompra t = new TicketCompra();
                t.setIdTicketCompra(rs.getInt("idTicketCompra"));
                
                // Comprador
                    Comprador c = new Comprador();
                    c.setDni(rs.getInt("dni"));
                    t.setIdComprador(c);

                // Asiento
                    Asiento a = new Asiento();
                    a.setIdAsiento(rs.getInt("idAsiento"));
                    t.setAsiento(a);
                
                t.setFechaCompra(rs.getDate("fechaCompra"));
                t.setFechaFuncion(rs.getDate("fechaFuncion"));
                
                t.setMonto(rs.getDouble("monto"));
                lista.add(t);
            }   
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al listar TicketCompra: " + ex.getMessage());
        }
        return lista;
    }
    
    
    //ACTUALIZAR
     public void actualizarTicketCompra(TicketCompra t) {
    String sql = "UPDATE ticketCompra SET idTicketCompra=?, comprador=?,  asiento=?,  fechaCompra=?,  fechaFuncion=?,  monto=? WHERE idTicketCompra=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, t.getComprador().getDni());
            ps.setInt(2, t.getAsiento().getIdAsiento());
            ps.setTimestamp(3, new Timestamp(t.getFechaCompra().getTime()));
            ps.setTimestamp(4, new Timestamp(t.getFechaFuncion().getTime()));
            ps.setDouble(5, t.getMonto());
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al actualizar funcion: " + ex.getMessage());
        }
    }
    
     //borrar
    public void borrarFuncion(int id) {
        String sql = "DELETE FROM ticketCompra WHERE idTicketCompra=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al borrar ticketCompra: " + ex.getMessage());
        }
    }
}
