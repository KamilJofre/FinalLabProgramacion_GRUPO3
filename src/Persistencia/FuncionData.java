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
    
    public FuncionData(Connection con){
        conexion =  Conexion.getConexion();
    }
    
    //INSERTAR
    public void guardarFuncion(Funcion f){
        String sql ="INSERT INTO funcion ( idPelicula,  idSala,  idioma,  es3D,  subtitulada,  horaInicio,  horaFin) VALUES (?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, f.getIdPelicula().getIdPelicula());
            ps.setInt(2, f.getIdSala().getNroSala());
            ps.setString(3, f.getIdioma());
            ps.setBoolean(4, f.isEs3D());
            ps.setBoolean(5, f.isSubtitulada());
            ps.setDate(6, new java.sql.Date(f.getHoraInicio().getTime()));
            ps.setDate(7, new java.sql.Date(f.getHoraFin().getTime()));

            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) f.setIdFuncion(rs.getInt(1));
            
            ps.close();
            
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }
    
    //BUSCAR POR ID
    public Funcion buscarFuncion(int idFuncion){
        Funcion f=null;
        String sql ="SELECT * FROM funcion WHERE idFuncion=?";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idFuncion);
            
            ResultSet rs = ps.executeQuery();
                if (rs.next()) { 
                    Pelicula p = new Pelicula();
                    p.setIdPelicula(rs.getInt("idPelicula"));
                    
                    Sala s = new Sala();
                    s.setNroSala(rs.getInt("setNroSala"));
                    
                    
                    f = new Funcion(
                        rs.getInt("idFuncion"),
                        p,
                        s,
                        rs.getString("idioma"),
                        rs.getBoolean("es3D"),
                        rs.getBoolean("subtitulada"),
                        rs.getDate("fechaFuncion"),
                        rs.getDate("horaInicio"),
                        rs.getDate("horaFin")
                    );
                }
                ps.close();
            } catch (SQLException ex) {
                System.out.println("Error al buscar funcion: " + ex.getMessage());
            }
        return f;
    }
    
    //LISTAR
    public ArrayList<Funcion> listarFunciones() {
        ArrayList<Funcion> lista = new ArrayList<>();
        String sql = "SELECT * FROM funcion where idFuncion=?";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Funcion f = new Funcion();
                f.setIdFuncion(rs.getInt("idFuncion"));
                
                // Película
                    Pelicula p = new Pelicula();
                    p.setIdPelicula(rs.getInt("idPelicula"));
                    f.setIdPelicula(p);

                    // Sala
                    Sala s = new Sala();
                    s.setNroSala(rs.getInt("idSala"));
                    f.setIdSala(s);
                
                f.setIdioma(rs.getString("idioma"));
                f.setEs3D(rs.getBoolean("es3D"));
                f.setSubtitulada(rs.getBoolean("subtitulada"));
                f.setHoraInicio(rs.getTimestamp("horaInicio"));
                f.setHoraFin(rs.getTimestamp("horaFin"));
                
                lista.add(f);
            }   
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al listar funciones: " + ex.getMessage());
        }
        return lista;
    }
    
    public ArrayList<Asiento> listarAsientos(int idFuncion){
        ArrayList<Asiento> lista = new ArrayList<>();
        String sql = "SELECT a.* FROM funcion f JOIN asiento a ON f.idFuncion = a.idFuncion WHERE f.idFuncion = ?;";
        
        try {
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idFuncion);
        
        ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                    Funcion f = new Funcion();
                    f.setIdFuncion(rs.getInt("idFuncion"));

                Asiento a = new Asiento(
                    rs.getInt("idAsiento"),
                    f,
                    rs.getString("codLugar"),
                    rs.getString("fila"),  // si fila es CHAR(1)
                    rs.getInt("numero"),
                    rs.getBoolean("estado")
                    );
                lista.add(a);
                }
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return lista;
    }
    
    
    //ACTUALIZAR
     public void actualizarFuncion(Funcion f) {
    String sql = "UPDATE funcion SET idPelicula=?, idSala=?, idioma=?, es3D=?, subtitulada=?, horaInicio=?, horaFin=?  WHERE idFuncion=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, f.getIdPelicula().getIdPelicula());
            ps.setInt(2, f.getIdSala().getNroSala());
            ps.setString(3, f.getIdioma());
            ps.setBoolean(4, f.isEs3D());
            ps.setBoolean(5, f.isSubtitulada());
            ps.setTimestamp(6, new Timestamp(f.getHoraInicio().getTime()));
            ps.setTimestamp(7, new Timestamp(f.getHoraFin().getTime()));
            ps.setInt(8, f.getIdFuncion());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al actualizar funcion: " + ex.getMessage());
        }
    }
    
     //borrar
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