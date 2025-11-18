/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.*;
import java.sql.*;
import java.util.*;

public class FuncionData {

    private Connection conexion = null;

    public FuncionData(Connection con) {
        conexion = Conexion.getConexion();
    }

    // INSERTAR
    public void guardarFuncion(Funcion f) {
        String sql = "INSERT INTO funcion (NroSala, idPelicula, idioma, es3D, subtitulada, fechaFuncion, horaInicio, horaFin, precio) "
                   + "VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, f.getIdSala().getNroSala());
            ps.setInt(2, f.getIdPelicula().getIdPelicula());
            ps.setString(3, f.getIdioma());
            ps.setBoolean(4, f.isEs3D());
            ps.setBoolean(5, f.isSubtitulada());
            ps.setDate(6, new java.sql.Date(f.getFechaFuncion().getTime()));
            ps.setDate(7, new java.sql.Date(f.getHoraInicio().getTime()));
            ps.setDate(8, new java.sql.Date(f.getHoraFin().getTime()));
            ps.setDouble(9, f.getPrecio());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) f.setIdFuncion(rs.getInt(1));

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al guardar funcion: " + ex.getMessage());
        }
    }

    // BUSCAR POR ID
    public Funcion buscarFuncion(int idFuncion) {
        Funcion f = null;
        String sql = "SELECT * FROM funcion WHERE idFuncion=?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idFuncion);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Pelicula p = new Pelicula();
                p.setIdPelicula(rs.getInt("idPelicula"));

                Sala s = new Sala();
                s.setNroSala(rs.getInt("NroSala"));

                f = new Funcion(
                    rs.getInt("idFuncion"),
                    p,
                    s,
                    rs.getString("idioma"),
                    rs.getBoolean("es3D"),
                    rs.getBoolean("subtitulada"),
                    rs.getDate("fechaFuncion"),
                    rs.getDate("horaInicio"),
                    rs.getDate("horaFin"), (int) rs.getDouble("precio"));
            }

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al buscar funcion: " + ex.getMessage());
        }

        return f;
    }

    // LISTAR TODAS LAS FUNCIONES
    public ArrayList<Funcion> listarFunciones() {
        ArrayList<Funcion> lista = new ArrayList<>();
        String sql = "SELECT * FROM funcion";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Funcion f = new Funcion();

                f.setIdFuncion(rs.getInt("idFuncion"));

                Pelicula p = new Pelicula();
                p.setIdPelicula(rs.getInt("idPelicula"));
                f.setIdPelicula(p);

                Sala s = new Sala();
                s.setNroSala(rs.getInt("NroSala"));
                f.setIdSala(s);

                f.setIdioma(rs.getString("idioma"));
                f.setEs3D(rs.getBoolean("es3D"));
                f.setSubtitulada(rs.getBoolean("subtitulada"));
                f.setFechaFuncion(rs.getDate("fechaFuncion"));
                f.setHoraInicio(rs.getDate("horaInicio"));
                f.setHoraFin(rs.getDate("horaFin"));
                f.setPrecio((int) rs.getDouble("precio"));

                lista.add(f);
            }

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al listar funciones: " + ex.getMessage());
        }

        return lista;
    }

    // LISTAR ASIENTOS POR FUNCIÓN
    public ArrayList<Asiento> listarAsientos(int idFuncion) {
        ArrayList<Asiento> lista = new ArrayList<>();

        String sql = "SELECT a.* FROM asiento a WHERE a.idFuncion = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idFuncion);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Funcion f = new Funcion();
                f.setIdFuncion(idFuncion);

                Asiento a = new Asiento(
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

        } catch (SQLException ex) {
            System.out.println("Error al listar asientos: " + ex.getMessage());
        }

        return lista;
    }

    // ACTUALIZAR
    public void actualizarFuncion(Funcion f) {
        String sql = "UPDATE funcion SET NroSala=?, idPelicula=?, idioma=?, es3D=?, subtitulada=?, fechaFuncion=?, horaInicio=?, horaFin=?, precio=? "
                   + "WHERE idFuncion=?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, f.getIdSala().getNroSala());
            ps.setInt(2, f.getIdPelicula().getIdPelicula());
            ps.setString(3, f.getIdioma());
            ps.setBoolean(4, f.isEs3D());
            ps.setBoolean(5, f.isSubtitulada());
            ps.setDate(6, new java.sql.Date(f.getFechaFuncion().getTime()));
            ps.setDate(7, new java.sql.Date(f.getHoraInicio().getTime()));
            ps.setDate(8, new java.sql.Date(f.getHoraFin().getTime()));
            ps.setDouble(9, f.getPrecio());
            ps.setInt(10, f.getIdFuncion());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al actualizar funcion: " + ex.getMessage());
        }
    }

    // BORRAR
    public void borrarFuncion(int id) {
        String sql = "DELETE FROM funcion WHERE idFuncion=?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al borrar funcion: " + ex.getMessage());
        }
    }
}