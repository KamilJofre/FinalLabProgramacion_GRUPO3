/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Sala;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaData {
    
    private Connection con = null;
    
    public SalaData(Conexion conexion) {
        con = Conexion.getConexion();
    }
    

    public void insertar(Sala s) {
        String sql = "INSERT INTO sala (apta3D, capacidad, estado) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setBoolean(1, s.isApta3D());
            ps.setInt(2, s.getCapacidad());
            ps.setBoolean(3, s.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) s.setNroSala(rs.getInt(1));
            ps.close();
            System.out.println("Sala insertada correctamente.");
        } catch (SQLException ex) {
            System.out.println("Error al insertar sala: " + ex.getMessage());
        }
    }
    public void actualizar(Sala s) {
        String sql = "UPDATE sala SET apta3D=?, capacidad=?, estado=? WHERE NroSala=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, s.isApta3D());
            ps.setInt(2, s.getCapacidad());
            ps.setBoolean(3, s.isEstado());
            ps.setInt(4, s.getNroSala());
            ps.executeUpdate();
            ps.close();
            System.out.println("Sala actualizada correctamente.");
        } catch (SQLException ex) {
            System.out.println("Error al actualizar sala: " + ex.getMessage());
        }
    }
    public void borrar(int idSala) {
        String sql = "DELETE FROM sala WHERE NroSala=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idSala);
            ps.executeUpdate();
            ps.close();
            System.out.println("Sala eliminada (física).");
        } catch (SQLException ex) {
            System.out.println("Error al eliminar sala: " + ex.getMessage());
        }
    }

    public void baja(int idSala) {
        String sql = "UPDATE sala SET estado=0 WHERE NroSala=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idSala);
            ps.executeUpdate();
            ps.close();
            System.out.println("Sala dada de baja (lógica).");
        } catch (SQLException ex) {
            System.out.println("Error en baja lógica: " + ex.getMessage());
        }
    }

    public Sala buscarPorId(int idSala) {
        Sala s = null;
        String sql = "SELECT * FROM sala WHERE NroSala=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idSala);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                s = new Sala();
                s.setNroSala(rs.getInt("NroSala"));
                s.setApta3D(rs.getBoolean("apta3D"));
                s.setCapacidad(rs.getInt("capacidad"));
                s.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar sala: " + ex.getMessage());
        }
        return s;
    }

    public List<Sala> listarTodos() {
        List<Sala
