/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Modelo.Sala;
import Persistencia.Conexion;
import Persistencia.SalaData;

import javax.swing.*;
import java.awt.*;

public class vistaSala extends JInternalFrame {

    private SalaData salaData;
    private Conexion conexion;
    private JTextField tfNroSala, tfCapacidad;
    private JCheckBox cbApta3D, cbEstado;

    public vistaSala() {
        super("Sala - ABMC", true, true, true, true);
        setSize(500, 300);
        setLayout(new BorderLayout());

        try { conexion = new Conexion(); salaData = new SalaData(conexion); } catch (Exception e) {}

        JPanel p = new JPanel(new GridLayout(0, 2));
        tfNroSala = new JTextField();
        tfCapacidad = new JTextField();
        cbApta3D = new JCheckBox("Apta 3D");
        cbEstado = new JCheckBox("Estado (activo)");

        p.add(new JLabel("Nro Sala:")); p.add(tfNroSala);
        p.add(new JLabel("Capacidad:")); p.add(tfCapacidad);
        p.add(cbApta3D); p.add(cbEstado);

        add(p, BorderLayout.NORTH);

        JPanel botones = new JPanel();
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> {

            JOptionPane.showMessageDialog(this, "Guardar sala (adaptar)");
        });
        JButton btnListar = new JButton("Listar");
        btnListar.addActionListener(e -> {

            JOptionPane.showMessageDialog(this, "Listar salas (adaptar)");
        });
        botones.add(btnGuardar); botones.add(btnListar);
        add(botones, BorderLayout.CENTER);
    }
}
