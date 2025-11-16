/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Vista;

import Persistencia.*;
import Modelo.*;
import java.sql.*;
import java.util.Date;


/**
 *
 * @author kamil
 */
public class FinalLabProgramacion_GRUPO3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // Obtener conexión
        Conexion conexionDB = new Conexion();
        Connection con = Conexion.getConexion();

        FuncionData funcionData = new FuncionData(con);

        // Crear un objeto Funcion
        Funcion f = new Funcion();
        Pelicula pelicula= new Pelicula();
        f.setIdPelicula(pelicula);
        Sala sala= new Sala();
        f.setIdSala(sala);
        f.setIdioma("Español");
        f.setEs3D(false);
        f.setSubtitulada(false);
        f.setHoraInicio(new Date());
        f.setHoraFin(new Date(System.currentTimeMillis() + 7200000)); // +2hs


        // Guardar en la BD
        funcionData.guardarFuncion(f);
        System.out.println("Funcion guardada con ID: " + f.getIdFuncion());

        // Buscar la función recién creada
        Funcion buscada = funcionData.buscarFuncion(f.getIdFuncion());

        if(buscada != null){
            System.out.println("Función encontrada:");
            System.out.println("ID Película: " + buscada.getIdPelicula());
            System.out.println("ID Sala: " + buscada.getIdSala());
            System.out.println("Idioma: " + buscada.getIdioma());

        } else {
            System.out.println("No se encontró la función");
        }
    }
}
