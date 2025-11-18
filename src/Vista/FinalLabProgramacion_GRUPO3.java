/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Vista;

import Persistencia.*;
import Modelo.*;
import java.sql.*;
import java.util.Date;
import java.util.List;


/**
 *
 * @author kamil
 */
public class FinalLabProgramacion_GRUPO3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      
//         1) Obtener conexión UNA sola vez
        Connection con = Conexion.getConexion();
        

//         2) Crear pasando la conexión
        CompradorData cd = new CompradorData(con);


//***********PROBANDO COMPRADOR DATA**************

        // 3) Crear comprador
        Comprador c = new Comprador(123324, "Juan asda", 
                     new java.util.Date(), "abc123", "Debito");

        // 4) Insertarlo
        cd.insertar(c);
//        
//        
//        // 5) Buscarlo
//        Comprador resultado = cd.buscarComprador(12345678);
//        System.out.println("Buscado: " + resultado.getNombre());
//
//        // 6) Actualizarlo
//        c.setNombre("Juan Carlos Pérez");
//        cd.actualizarComprador(c);
//
//        // 7) Listar todos
//        for (Comprador x : cd.listarCompradores()) {
//            System.out.println(x.getNombre());
//        }
//
//        // 8) Eliminarlo
//        cd.darDeBaja(12345678);


//******************PROBANDO SALADATA************

//SalaData salaData = new SalaData(con);
//
//        System.out.println("=== PRUEBA DE SalaData ===");
//
//        // 1) Crear una sala
//        Sala nuevaSala = new Sala(true, 120, true); 
//        salaData.insertar(nuevaSala);
//        
//
//        // 2) Buscar la sala
//        Sala salaBuscada = salaData.buscarSala(1);
//        System.out.println("Sala encontrada: " + salaBuscada);
//        
//        
//        // 3) Actualizar sala
//        salaBuscada.setCapacidad(150);
//        salaData.actualizarSala(salaBuscada);
//        System.out.println("Sala actualizada: " + salaBuscada);
//
//        // 4) Listar todas las salas
//        System.out.println("=== Listando salas ===");
//        for (Sala s : salaData.listarSalas()) {
//            System.out.println(s);
//        }
//
//        // 5) Borrar sala
//        salaData.darDeBaja(1);
//        System.out.println("Sala borrada.");
//


//***********probando PELICULADATA***********

//// 1. Crear una película
//    PeliculaData pd = new PeliculaData(con);
//    
//        Pelicula p = new Pelicula(
//                "Matrix",
//                "Wachowski",
//                "USA",
//                "Sci-Fi",
//                new Date(),  // HOY
//                true
//        );
//
//        pd.guardarPelicula(p);
//        
        // 2) BUSCAR
//        Pelicula encontrada = pd.buscarPelicula(p.getIdPelicula());
//        System.out.println("Película encontrada: " + encontrada.getTitulo());
//
//        // 3) ACTUALIZAR
//        encontrada.setTitulo("Matrix Reloaded");
//        pd.actualizarPelicula(encontrada);
//        System.out.println("Película actualizada correctamente.");
//
//        // 4) LISTAR TODAS
//        System.out.println("==== LISTADO DE PELÍCULAS ====");
//        for (Pelicula peli : pd.listarPeliculas()) {
//            System.out.println(peli.getIdPelicula() + " - " + peli.getTitulo());
//        }
//
//        // 5) BORRAR
//        pd.borrarPelicula(encontrada.getIdPelicula());
//        System.out.println("Película borrada correctamente.");

//**probando ASIENTO DATA**
//AsientoData ad = new AsientoData(con);
//
////tiene que haber una funcion para que funcione el asiento
//
//Funcion f = new Funcion();
//        f.setIdFuncion(1);   
//
//        // 1) INSERTAR ASIENTO
//        Asiento a = new Asiento(
//                f,
//                "A1",
//                "A",
//                1,
//                true
//        );
//
//        ad.insertar(a);
//        System.out.println("Asiento insertado con ID: " + a.getIdAsiento());
//        
//        // 2) BUSCAR ASIENTO
//        Asiento encontrado = ad.buscarAsiento(a.getIdAsiento());
//        if (encontrado != null) {
//            System.out.println("Asiento hallado: " 
//                + encontrado.getCodLugar() + " - Fila: " + encontrado.getFila());
//        }
//
//        // 3) LISTAR ASIENTOS DE UNA FUNCIÓN
//        System.out.println("=== ASIENTOS DE LA FUNCIÓN 1 ===");
//        List<Asiento> lista = ad.listarAsientos(1);
//        for (Asiento x : lista) {
//            System.out.println(
//                x.getIdAsiento() + " | " + x.getCodLugar() + " | Fila: " + x.getFila() + " | Num: " + x.getNumero()
//            );
//        }
//
//        // 4) ACTUALIZAR ASIENTO
//        encontrado.setCodLugar("A2");
//        encontrado.setNumero(2);
//        encontrado.setEstado(false);
//        ad.actualizarAsiento(encontrado);
//        System.out.println("Asiento actualizado.");
//
//        // 5) DAR DE BAJA (estado = 0)
//        ad.darDeBaja(encontrado.getIdAsiento());
//        System.out.println("Asiento dado de baja.");
//








        
        
        
        



        
        
        
        
        
        
        
        
        
    } 
        
        


}
