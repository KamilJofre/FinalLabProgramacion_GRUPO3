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
        String sql ="INSERT INTO funcion ( idPelicula,  idSala,  idioma,  es3D,  subtitulada,  horaInicio,  horaFin,relacionAsientoFuncion,  precio) VALUES (?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, f.getPelicula().getIdPelicula());
            ps.setInt(2, f.getSala().getNroSala());
            ps.setString(3, f.getIdioma());
            ps.setBoolean(4, f.isEs3D());
            ps.setBoolean(5, f.isSubtitulada());
            ps.setDate(6, new java.sql.Date(f.getHoraInicio().getTime()));
            ps.setDate(7, new java.sql.Date(f.getHoraFin().getTime()));
            ps.setInt(1, f.getRelacionAsientoFuncion().getIdRelacionAsientoFuncion());
            ps.setDouble(8, f.getPrecio());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) f.setIdFuncion(rs.getInt(1));
            
            ps.close();
            
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }
    
    //BUSCAR POR ID
    public Funcion buscarFuncion(int id){
        Funcion f=null;
        String sql ="SELECT * FROM funcion WHERE idFuncion=?";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
                if (rs.next()) { 
                    Pelicula p = new Pelicula();
                    p.setIdPelicula(rs.getInt("idPelicula"));
                    
                    Sala s = new Sala();
                    s.setNroSala(rs.getInt("setNroSala"));
                    
                    RelacionAsientoFuncion r = new RelacionAsientoFuncion();
                    r.setIdRelacionAsientoFuncion(rs.getInt("idRelacionAsientoFuncion"));
                    
                    f = new Funcion(
                        rs.getInt("idFuncion"),
                        p,
                        s,
                        rs.getString("idioma"),
                        rs.getBoolean("es3D"),
                        rs.getBoolean("subtitulada"),
                        rs.getDate("horaInicio"),
                        rs.getDate("horaFin"),
                        r,
                        rs.getDouble("precio")
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
        String sql = "SELECT * FROM funcion";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Funcion f = new Funcion();
                f.setIdFuncion(rs.getInt("idFuncion"));
                
                // Película
                    Pelicula p = new Pelicula();
                    p.setIdPelicula(rs.getInt("idPelicula"));
                    f.setPelicula(p);

                    // Sala
                    Sala s = new Sala();
                    s.setNroSala(rs.getInt("idSala"));
                    f.setSala(s);
                
                f.setIdioma(rs.getString("idioma"));
                f.setEs3D(rs.getBoolean("es3D"));
                f.setSubtitulada(rs.getBoolean("subtitulada"));
                f.setHoraInicio(rs.getTimestamp("horaInicio"));
                f.setHoraFin(rs.getTimestamp("horaFin"));
                
                RelacionAsientoFuncion raf = new RelacionAsientoFuncion();
                    raf.setIdRelacionAsientoFuncion(rs.getInt("idRelacionAsientoFuncion"));
                    f.setRelacionAsientoFuncion(raf);
                    
                f.setPrecio(rs.getDouble("precio"));
                lista.add(f);
            }   
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al listar funciones: " + ex.getMessage());
        }
        return lista;
    }
    
    
    //ACTUALIZAR
     public void actualizarFuncion(Funcion f) {
    String sql = "UPDATE funcion SET idPelicula=?, idSala=?, idioma=?, es3D=?, subtitulada=?, horaInicio=?, horaFin=?, precio=?, relacionAsientoFuncion=? WHERE idFuncion=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, f.getPelicula().getIdPelicula());
            ps.setInt(2, f.getSala().getNroSala());
            ps.setString(3, f.getIdioma());
            ps.setBoolean(4, f.isEs3D());
            ps.setBoolean(5, f.isSubtitulada());
            ps.setTimestamp(6, new Timestamp(f.getHoraInicio().getTime()));
            ps.setTimestamp(7, new Timestamp(f.getHoraFin().getTime()));
            ps.setDouble(8, f.getPrecio());
            ps.setInt(9 , f.getRelacionAsientoFuncion().getIdRelacionAsientoFuncion());
            ps.setInt(10, f.getIdFuncion());
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