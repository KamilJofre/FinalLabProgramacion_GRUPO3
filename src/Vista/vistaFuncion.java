/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Modelo.Funcion;
import Persistencia.Conexion;
import Persistencia.FuncionData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.List;

public class vistaFuncion extends JInternalFrame {

    private FuncionData funcionData;
    private Conexion conexion;

    // componentes
    private JTextField tfId, tfHoraInicio, tfHoraFin, tfPrecio, tfIdPelicula;
    private JCheckBox cbEs3D, cbSubtitulado;
    private JTextArea taLista;
    private JTable tabla;
    private DefaultListModel<String> listModel;

    public vistaFuncion() {
        super("Función - ABMC", true, true, true, true);
        setSize(700, 450);
        setLayout(new BorderLayout());

        try {
            conexion = new Conexion(); 
            funcionData = new FuncionData((Connection) conexion);
        } catch (Exception ex) {
            System.out.println("Error conectando: " + ex.getMessage());
        }

        initComponents();
        cargarTabla();
    }

    private void initComponents() {
        JPanel form = new JPanel(new GridLayout(0, 2, 5, 5));
        tfId = new JTextField();
        tfHoraInicio = new JTextField();
        tfHoraFin = new JTextField();
        tfPrecio = new JTextField();
        tfIdPelicula = new JTextField();
        cbEs3D = new JCheckBox("3D");
        cbSubtitulado = new JCheckBox("Subtitulada");
        taLista = new JTextArea(3, 20);

        form.add(new JLabel("ID:"));
        form.add(tfId);
        form.add(new JLabel("idPelicula:"));
        form.add(tfIdPelicula);
        form.add(new JLabel("Hora Inicio (YYYY-MM-DD HH:MM):"));
        form.add(tfHoraInicio);
        form.add(new JLabel("Hora Fin (YYYY-MM-DD HH:MM):"));
        form.add(tfHoraFin);
        form.add(new JLabel("Precio:"));
        form.add(tfPrecio);
        form.add(cbEs3D);
        form.add(cbSubtitulado);
        form.add(new JLabel("Lugares disponibles (cadena):"));
        form.add(new JScrollPane(taLista));

        add(form, BorderLayout.NORTH);

        JPanel botones = new JPanel();
        JButton btnGuardar = new JButton("Guardar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnBuscar = new JButton("Buscar por ID");
        JButton btnListar = new JButton("Listar todos");

        btnGuardar.addActionListener(e -> guardar());
        btnActualizar.addActionListener(e -> actualizar());
        btnEliminar.addActionListener(e -> eliminar());
        btnBuscar.addActionListener(e -> buscar());
        btnListar.addActionListener(e -> cargarTabla());

        botones.add(btnGuardar);
        botones.add(btnActualizar);
        botones.add(btnEliminar);
        botones.add(btnBuscar);
        botones.add(btnListar);

        add(botones, BorderLayout.CENTER);


        tabla = new JTable();
        add(new JScrollPane(tabla), BorderLayout.SOUTH);
    }

    private void guardar() {
        try {
            Funcion f = new Funcion();

            JOptionPane.showMessageDialog(this, "Guardado (adaptar método)");
            cargarTabla();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void actualizar() {
        try {

            JOptionPane.showMessageDialog(this, "Actualizar (adaptar)");
            cargarTabla();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void eliminar() {
        try {
            int id = Integer.parseInt(tfId.getText());

            JOptionPane.showMessageDialog(this, "Eliminado (adaptar)");
            cargarTabla();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void buscar() {
        try {
            int id = Integer.parseInt(tfId.getText());

            JOptionPane.showMessageDialog(this, "Buscar (adaptar)");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void cargarTabla() {
        try {

        } catch (Exception ex) {
            System.out.println("Error cargando tabla: " + ex.getMessage());
        }
    }
}
