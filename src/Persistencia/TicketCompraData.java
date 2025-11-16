/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


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
        String sql ="INSERT INTO funcion ( idComprador,  asiento,  fechaCompra,  fechaFuncion,  monto) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, t.getIdComprador().getDni());
            ps.setInt(2, t.getIdAsiento().getIdAsiento());
            ps.setInt(3, t.getIdFuncion().getIdFuncion());
            ps.setTimestamp(4, new Timestamp(t.getFechaCompra().getTime())); 
            ps.setDouble(5, t.getMonto());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) t.setIdTicketCompra(rs.getInt(1));
            
            ps.close();
            
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }
    
    //BUSCAR POR ID
    public TicketCompra buscarTicketCompra(int idTicketCompra){
        TicketCompra t=null;
        String sql ="SELECT * FROM TicketCompra WHERE idTicketCompra=?";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idTicketCompra);
            
            ResultSet rs = ps.executeQuery();
                if (rs.next()) { 
                    Comprador c = new Comprador();
                    c.setDni(rs.getInt("Dni"));
                    
                    Asiento a =  new Asiento();
                    a.setIdAsiento(rs.getInt("idAsiento"));
                    
                    Funcion f = new Funcion();
                    f.setIdFuncion(rs.getInt("idFuncion"));
                    
                    t = new TicketCompra(
                        rs.getInt("idTicketCompra"),
                        c,
                        a,
                        f,
                        rs.getDate("fechCompra"),
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
    public ArrayList<TicketCompra> listarTicketCompra(int idComprador) {
        ArrayList<TicketCompra> lista = new ArrayList<>();
        String sql = "SELECT * FROM ticketCompra WHERE idComprador=?";
        
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
                    t.setIdAsiento(a);
                
                //Funcion
                    Funcion f= new Funcion();
                    f.setIdFuncion(rs.getInt("idFuncion"));
                    t.setIdFuncion(f);
                    
                t.setFechaCompra(rs.getDate("fechaCompra"));
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
            ps.setInt(1, t.getIdComprador().getDni());
            ps.setInt(2, t.getIdAsiento().getIdAsiento());
            ps.setInt(3, t.getIdFuncion().getIdFuncion());
            ps.setTimestamp(4, new Timestamp(t.getFechaCompra().getTime()));
            ps.setDouble(5, t.getMonto());
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al actualizar funcion: " + ex.getMessage());
        }
    }
    
     //borrar
    public void borrarTicketCompra(int idTicketCompra) {
        String sql = "DELETE FROM ticketCompra WHERE idTicketCompra=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idTicketCompra);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al borrar ticketCompra: " + ex.getMessage());
        }
    }
}
