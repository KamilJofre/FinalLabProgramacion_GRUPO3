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
public class PeliculaData {
    //CONECTAR
    private Connection conexion=null;
    
    public PeliculaData(Connection con){
        conexion =  Conexion.getConexion();
    }
    
    //INSERTAR
    public void guardarPelicula(Pelicula p){
        String sql ="INSERT INTO pelicula (titulo,  director,  origen,  genero,  estreno,   enCartelera) VALUES (?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getTitulo());
            ps.setString(2, p.getDirector());
            ps.setString(4, p.getOrigen());
            ps.setString(5, p.getGenero());
            ps.setDate(6, new java.sql.Date(p.getEstreno().getTime()));
            ps.setBoolean(7, p.isEnCartelera());
            

            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) p.setIdPelicula(rs.getInt(1));
            
            ps.close();
            
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }
    
    //BUSCAR
    public Pelicula buscarPelicula(int idPelicula){
        Pelicula p=null;
        String sql="SELECT * FROM pelicula WHERE idPelicula=?";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idPelicula);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p = new Pelicula();
                p.setIdPelicula(rs.getInt("idPelicula"));
                p.setTitulo(rs.getString("titulo"));
                p.setDirector(rs.getString("director"));
                p.setOrigen(rs.getString("origen"));
                p.setGenero(rs.getString("genero"));
                p.setEstreno(rs.getDate("estreno"));
                p.setEnCartelera(rs.getBoolean("enCartelera"));
                }
            ps.close();
            } catch (SQLException ex) {
            System.out.println("❌ Error al buscar película: " + ex.getMessage());
            }
        return p;
    }
    
    //LISTAR TODOS              
    public List<Pelicula> listarPeliculas(){
        List<Pelicula> lista = new ArrayList<>();
        String sql ="SELECT * FROM pelicula where idPelicula=?";
        
        try{
            PreparedStatement ps= conexion.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            
            while(rs.next()){
                Pelicula p = new Pelicula(
                        rs.getInt("idPelicula"),
                        rs.getString("titulo"),
                        rs.getString("director"),
                        rs.getString("origen"),
                        rs.getString("genero"),
                        rs.getDate("estreno"),
                        rs.getBoolean("enCartelera")
                );
                lista.add(p);
            }
            ps.close();
        }   catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
        }
        return lista;
    }

    
    //ACTUALIZAR
    public void actualizarPelicula(Pelicula p) {
    String sql = "UPDATE pelicula SET titulo=?, director=?, origen=?, genero=?, estreno=?, enCartelera=?  WHERE idPelicula=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setInt(1, p.getIdPelicula());
                ps.setString(2, p.getTitulo());
                ps.setString(3, p.getDirector());
                ps.setString(4, p.getOrigen());
                ps.setString(5, p.getGenero());
                ps.setTimestamp(6, new Timestamp(p.getEstreno().getTime()));
                ps.setBoolean(7, p.isEnCartelera());
                ps.executeUpdate();
                ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al actualizar funcion: " + ex.getMessage());
        }
    }
    
     //borrar
    public void borrarFuncion(int idPelicula) {
        String sql = "DELETE FROM pelicula WHERE idPelicula=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idPelicula);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al borrar funcion: " + ex.getMessage());
        }
    }
}
