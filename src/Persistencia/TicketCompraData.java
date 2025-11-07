/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.TicketCompra;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketCompraData {

    private Connection con = null;

    public TicketCompraData(Conexion conexion) {
        con = Conexion.getConexion();
    }

    // INSERTAR
    public void insertar(TicketCompra t) {
        String sql = "INSERT INTO ticketcompra (idComprador, idAsiento, fechaCompra, fechaFuncion, monto) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, t.getIdComprador());
            ps.setInt(2, t.getIdAsiento());
            ps.setDate(3, Date.valueOf(t.getFechaCompra()));
            ps.setDate(4, Date.valueOf(t.getFechaFuncion()));
            ps.setDouble(5, t.getMonto());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) t.setIdTicketCompra(rs.getInt(1));
            ps.close();
            System.out.println("Ticket insertado correctamente.");
        } catch (SQLException ex) {
            System.out.println("Error al insertar ticket: " + ex.getMessage());
        }
    }

    // ACTUALIZAR
    public void actualizar(TicketCompra t) {
        String sql = "UPDATE ticketcompra SET idComprador=?, idAsiento=?, fechaCompra=?, fechaFuncion=?, monto=? WHERE idTicketCompra=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, t.getIdComprador());
            ps.setInt(2, t.getIdAsiento());
            ps.setDate(3, Date.valueOf(t.getFechaCompra()));
            ps.setDate(4, Date.valueOf(t.getFechaFuncion()));
            ps.setDouble(5, t.getMonto());
            ps.setInt(6, t.getIdTicketCompra());
            ps.executeUpdate();
            ps.close();
            System.out.println("Ticket actualizado correctamente.");
        } catch (SQLException ex) {
            System.out.println("Error al actualizar ticket: " + ex.getMessage());
        }
    }

    // BORRAR (física)
    public void borrar(int idTicket) {
        String sql = "DELETE FROM ticketcompra WHERE idTicketCompra=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idTicket);
            ps.executeUpdate();
            ps.close();
            System.out.println("Ticket eliminado (física).");
        } catch (SQLException ex) {
            System.out.println("Error al eliminar ticket: " + ex.getMessage());
        }
    }

    // BAJA (lógica)
    public void baja(int idTicket) {
        // si tu tabla tiene campo estado, activa esta línea. si no, omite.
        String sql = "UPDATE ticketcompra SET estado=0 WHERE idTicketCompra=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idTicket);
            ps.executeUpdate();
            ps.close();
            System.out.println("Ticket dado de baja (lógica).");
        } catch (SQLException ex) {
            System.out.println("Error en baja lógica: " + ex.getMessage());
        }
    }

    // BUSCAR POR ID
    public TicketCompra buscarPorId(int idTicket) {
        TicketCompra t = null;
        String sql = "SELECT * FROM ticketcompra WHERE idTicketCompra=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idTicket);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                t = new TicketCompra();
                t.setIdTicketCompra(rs.getInt("idTicketCompra"));
                t.setIdComprador(rs.getInt("idComprador"));
                t.setIdAsiento(rs.getInt("idAsiento"));
                t.setFechaCompra(rs.getDate("fechaCompra").toLocalDate());
                t.setFechaFuncion(rs.getDate("fechaFuncion").toLocalDate());
                t.setMonto(rs.getDouble("monto"));
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar ticket: " + ex.getMessage());
        }
        return t;
    }

    // LISTAR TODOS
    public List<TicketCompra> listarTodos() {
        List<TicketCompra> lista = new ArrayList<>();
        String sql = "SELECT * FROM ticketcompra";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TicketCompra t = new TicketCompra();
                t.setIdTicketCompra(rs.getInt("idTicketCompra"));
                t.setIdComprador(rs.getInt("idComprador"));
                t.setIdAsiento(rs.getInt("idAsiento"));
                t.setFechaCompra(rs.getDate("fechaCompra").toLocalDate());
                t.setFechaFuncion(rs.getDate("fechaFuncion").toLocalDate());
                t.setMonto(rs.getDouble("monto"));
                lista.add(t);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al listar tickets: " + ex.getMessage());
        }
        return lista;
    }
}
