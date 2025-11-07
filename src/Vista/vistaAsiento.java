/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Modelo.Asiento;
import Persistencia.AsientoData;
import Persistencia.Conexion;

import javax.swing.*;
import java.awt.*;

public class vistaAsiento extends JInternalFrame {

    private AsientoData asientoData;
    private Conexion conexion;

    private JTextField tfId, tfFila, tfNumero, tfCodLugar, tfIdFuncion;
    private JCheckBox cbEstado;

    public vistaAsiento() {
        super("Asiento - ABMC", true, true, true, true);
        setSize(500, 350);
        
        try { conexion = new Conexion(); asientoData = new AsientoData(conexion); } catch (Exception e) {}

        JPanel p = new JPanel(new GridLayout(0,2));
        tfId = new JTextField();
        tfFila = new JTextField();
        tfNumero = new JTextField();
        tfCodLugar = new JTextField();
        tfIdFuncion = new JTextField();
        cbEstado = new JCheckBox("ocupado");

        p.add(new JLabel("ID Asiento:")); p.add(tfId);
        p.add(new JLabel("Fila:")); p.add(tfFila);
        p.add(new JLabel("Número:")); p.add(tfNumero);
        p.add(new JLabel("CodLugar:")); p.add(tfCodLugar);
        p.add(new JLabel("IdFuncion:")); p.add(tfIdFuncion);
        p.add(cbEstado);

        add(p, BorderLayout.NORTH);

        JPanel botones = new JPanel();
        JButton bGuardar = new JButton("Guardar");
        bGuardar.addActionListener(e -> {
            // crear Asiento, setear, llamar a asientoData.guardar/asientoData.insertar
            JOptionPane.showMessageDialog(this, "Guardar Asiento (adaptar)");
        });
        JButton bListar = new JButton("Listar");
        bListar.addActionListener(e -> { JOptionPane.showMessageDialog(this,"Listar (adaptar)"); });

        botones.add(bGuardar);
        botones.add(bListar);
        add(botones, BorderLayout.CENTER);
    }
}
