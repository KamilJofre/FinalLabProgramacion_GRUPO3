/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Modelo.Comprador;
import Persistencia.CompradorData;
import Persistencia.Conexion;

import javax.swing.*;
import java.awt.*;

public class vistaComprador extends JInternalFrame {

    private CompradorData compradorData;
    private Conexion conexion;

    private JTextField tfDni, tfNombre, tfFechaNac, tfPassword, tfMedioPago;

    public vistaComprador() {
        super("Comprador - ABMC", true, true, true, true);
        setSize(600, 300);
        try { conexion = new Conexion(); compradorData = new CompradorData(conexion); } catch (Exception e) {}

        JPanel p = new JPanel(new GridLayout(0,2));
        tfDni = new JTextField();
        tfNombre = new JTextField();
        tfFechaNac = new JTextField();
        tfPassword = new JTextField();
        tfMedioPago = new JTextField();

        p.add(new JLabel("DNI:")); p.add(tfDni);
        p.add(new JLabel("Nombre:")); p.add(tfNombre);
        p.add(new JLabel("Fecha nac (YYYY-MM-DD):")); p.add(tfFechaNac);
        p.add(new JLabel("Password:")); p.add(tfPassword);
        p.add(new JLabel("Medio Pago:")); p.add(tfMedioPago);

        add(p, BorderLayout.NORTH);

        JPanel botones = new JPanel();
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> {

            JOptionPane.showMessageDialog(this, "Guardar comprador (adaptar)");
        });
        JButton btnListar = new JButton("Listar");
        btnListar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Listar compradores (adaptar)");
        });

        botones.add(btnGuardar);
        botones.add(btnListar);
        add(botones, BorderLayout.CENTER);
    }
}