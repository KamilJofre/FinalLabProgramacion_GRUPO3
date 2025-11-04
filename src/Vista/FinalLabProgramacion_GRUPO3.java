/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Vista;

import Persistencia.AsientoData;
import Persistencia.*;
import Modelo.*;

/**
 *
 * @author kamil
 */
public class FinalLabProgramacion_GRUPO3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AsientoData ad = new AsientoData();
        
        // 1️⃣ Crear asiento e insertar
        Asiento asiento = new Asiento(1, "A1", "A", 5, true);
        ad.insertar(asiento);
        System.out.println("Insertado: " + asiento);

        // 2️⃣ Buscar asiento insertado
        Asiento buscado = ad.buscarAsiento(asiento.getIdAsiento());
        System.out.println("Buscado: " + buscado);

        // 3️⃣ Actualizar asiento
        asiento.setNumero(7);
        ad.actualizarAsiento(asiento);
        System.out.println("Actualizado: " + ad.buscarAsiento(asiento.getIdAsiento()));
        
        // 4️⃣ Listar todos
        System.out.println("\nListado:");
        for (Asiento a : ad.listarAsientos()) {
            System.out.println(a);
        }

        // 5️⃣ Baja lógica
        ad.darDeBaja(asiento.getIdAsiento());
        System.out.println("\nBaja lógica aplicada.");

        // 6️⃣ Mostrar después de baja
        System.out.println(ad.buscarAsiento(asiento.getIdAsiento()));
    }
    
}
