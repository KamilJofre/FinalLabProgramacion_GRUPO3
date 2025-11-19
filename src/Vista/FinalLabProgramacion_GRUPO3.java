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
        
        //Conexion a base de datos
        Connection con = Conexion.getConexion();
        
        

        //ComrpadorData
        CompradorData cd = new CompradorData(con);

        // 1) Crear comprador
        Comprador c = new Comprador(1232456, "Juan asda", new java.util.Date(), "abc123", "Debito");
        Comprador k = new Comprador(45562799, "Kamil Jofré", new java.util.Date(2004-04-21),"abcbc","Efectivo" );

        // 2) Insertar
        cd.insertar(c);
        

        // 3) Buscar
        Comprador resultado = cd.buscarComprador(123324);
        System.out.println("Buscado: " + resultado.getNombre());

        // 4) Actualizar
        c.setNombre("Juan Carlos Pérez");
        cd.actualizarComprador(c);

        // 5) Listar todos
        for (Comprador x : cd.listarCompradores()) {
            System.out.println("Comprador: " + x.getNombre());
        }

        
        
        
        //SalatData
        SalaData salaData = new SalaData(con);

        System.out.println("\nPrueba de SalaData");

        // 1) Crear una sala
        Sala nuevaSala = new Sala(1, true, 120, true);
        salaData.insertar(nuevaSala);

        // 2) Buscar sala
        Sala salaBuscada = salaData.buscarSala(1);
        System.out.println("Sala encontrada: " + salaBuscada.getNroSala());

        // 3) Actualizar sala
        salaBuscada.setCapacidad(150);
        salaData.actualizarSala(salaBuscada);

        // 4) Listar salas
        for (Sala s : salaData.listarSalas()) {
            System.out.println("Sala listada: " + s.getNroSala());
        }


        
        
        
        //PeliculaData
        PeliculaData pd = new PeliculaData(con);

        // 1) Crear pelicula
        Pelicula p = new Pelicula("Matrix", "Wachowski", "USA", "Sci-Fi", new Date(), true);
        pd.guardarPelicula(p);

        // 2) Buscar
        Pelicula encontrada = pd.buscarPelicula(p.getIdPelicula());
        System.out.println("Película encontrada: " + encontrada.getTitulo());

        // 3) Actualizar
        encontrada.setTitulo("Matrix Reloaded");
        pd.actualizarPelicula(encontrada);

        // 4) Listar
        for (Pelicula peli : pd.listarPeliculas()) {
            System.out.println("Película: " + peli.getIdPelicula() + " - " + peli.getTitulo());
        }


        //FuncionData
        FuncionData fd = new FuncionData(con);

        Funcion f = new Funcion(
                p,                  
                nuevaSala,          
                "Español",          
                false,              
                true,               
                new Date(),         
                new Date(),         
                new Date(),         
                1500                
        );

        fd.guardarFuncion(f);
        System.out.println("Función guardada ID: " + f.getIdFuncion());

        Funcion funEncontrada = fd.buscarFuncion(f.getIdFuncion());
        System.out.println("Idioma función encontrada: " + funEncontrada.getIdioma());



        //AsientoData
        AsientoData ad = new AsientoData(con);

        // 1) Insertar asiento
        Asiento a = new Asiento(f, "A1", "A", 1, true);
        ad.insertar(a);

        System.out.println("Asiento insertado con ID: " + a.getIdAsiento());

        // 2) Buscar asiento
        Asiento encontradoAsiento = ad.buscarAsiento(a.getIdAsiento());
        System.out.println("Asiento hallado: " + encontradoAsiento.getCodLugar());

        // 3) Listar asientos por función
        for (Asiento x : ad.listarAsientos(f.getIdFuncion())) {
            System.out.println("Asiento listado: " + x.getCodLugar());
        }


        

        //TicketCompraDaata (Final)
        TicketCompraData tcd = new TicketCompraData(con);

        // 1) Crear ticket
        TicketCompra ticket = new TicketCompra(
                c,          // comprador
                a,          // asiento
                f,          // funcion
                new Date(), // fechaCompra
                f.getPrecio()
        );

        tcd.guardarTicket(ticket);

        System.out.println("Ticket guardado ID: " + ticket.getIdTicketCompra());

        // 2) Buscar ticket
        TicketCompra tBuscado = tcd.buscarTicketCompra(ticket.getIdTicketCompra());
        System.out.println("Ticket encontrado monto: " + tBuscado.getMonto());

        // 3) Listar tickets de comprador
        for (TicketCompra t : tcd.listarTicketCompra(c.getDni())) {
            System.out.println("Ticket listado ID: " + t.getIdTicketCompra());
        }
        
        
        

        System.out.println("\n Fin Pruebas");

    }
}
