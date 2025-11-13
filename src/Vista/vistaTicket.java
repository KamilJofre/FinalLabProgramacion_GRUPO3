/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;


import Modelo.TicketCompra;
import Persistencia.TicketCompraData;
import Persistencia.Conexion;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class vistaTicket extends JInternalFrame {

    private TicketCompraData ticketData;
    private Conexion conexion;

    private JTextField tfId, tfIdComprador, tfIdAsiento, tfFechaCompra, tfFechaFuncion, tfMonto;

    public vistaTicket() {
        super("TicketCompra - ABMC", true, true, true, true);
        setSize(700, 350);
        
        try { conexion = new Conexion(); ticketData = new TicketCompraData((Connection) conexion); } catch (Exception e) {}

        JPanel p = new JPanel(new GridLayout(0,2));
        tfId = new JTextField();
        tfIdComprador = new JTextField();
        tfIdAsiento = new JTextField();
        tfFechaCompra = new JTextField();
        tfFechaFuncion = new JTextField();
        tfMonto = new JTextField();

        p.add(new JLabel("ID Ticket:")); p.add(tfId);
        p.add(new JLabel("ID Comprador:")); p.add(tfIdComprador);
        p.add(new JLabel("ID Asiento:")); p.add(tfIdAsiento);
        p.add(new JLabel("Fecha Compra:")); p.add(tfFechaCompra);
        p.add(new JLabel("Fecha Funcion:")); p.add(tfFechaFuncion);
        p.add(new JLabel("Monto:")); p.add(tfMonto);

        add(p, BorderLayout.NORTH);

        JPanel btns = new JPanel();
        JButton bGuardar = new JButton("Guardar");
        bGuardar.addActionListener(e -> {

            JOptionPane.showMessageDialog(this, "Guardar ticket (adaptar)");
        });
        JButton bListar = new JButton("Listar");
        bListar.addActionListener(e -> { JOptionPane.showMessageDialog(this, "Listar tickets (adaptar)"); });

        btns.add(bGuardar); btns.add(bListar);
        add(btns, BorderLayout.CENTER);
    }
}
