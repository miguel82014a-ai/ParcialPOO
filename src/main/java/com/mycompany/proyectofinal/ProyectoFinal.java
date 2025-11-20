/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectofinal;
import javax.swing.*;
import Modelo.*;
/**
 *
 * @author migue
 */
public class ProyectoFinal {

    static Libro[] libros = {
        new Libro(1, "El extranjero", "Albert Camus", "Novela"),
        new Libro(2, "El príncipe", "Nicolás Maquiavelo", "Política"),
        new Libro(3, "Así habló Zaratustra", "Friedrich Nietzsche", "Filosofía"),
        new Libro(4, "Crimen y castigo", "Fiódor Dostoievski", "Novela")
    };
    
    public static void main(String[] args) {
        
        
        JFrame frame = new JFrame("Librería Open Mind");
        frame.setLocationRelativeTo(null);
        frame.setSize(600, 520);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Lista de libros
        JList<String> lista = new JList<>();
        JScrollPane scroll = new JScrollPane(lista);
        scroll.setBounds(20, 60, 350, 350);
        frame.add(scroll);

        // Campo de búsqueda
        JTextField txtBuscar = new JTextField();
        txtBuscar.setBounds(20, 20, 350, 30);
        frame.add(txtBuscar);

        // Botones
        JButton btnAgregar = new JButton("Registrar");
        btnAgregar.setBounds(400, 60, 150, 30);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(400, 110, 150, 30);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(400, 160, 150, 30);
        
        JButton btnDetalles = new JButton("Ver detalle");
        btnDetalles.setBounds(400, 210, 150, 30);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(400, 260, 150, 30);

        frame.add(btnAgregar);
        frame.add(btnEditar);
        frame.add(btnEliminar);
        frame.add(btnDetalles);
        frame.add(btnSalir);

        // Instancias
        RegistrarLibro registrar = new RegistrarLibro();
        EditarLibro editar = new EditarLibro();
        EliminarLibro eliminar = new EliminarLibro();
        ListarLibro listar = new ListarLibro();

        // Al iniciar: mostrar libros quemados
        lista.setListData(listar.listarArreglo(libros));

        // Buscar en tiempo real
        txtBuscar.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void changedUpdate(javax.swing.event.DocumentEvent e) { filtrar(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { filtrar(); }
            public void insertUpdate(javax.swing.event.DocumentEvent e) { filtrar(); }

            public void filtrar() {
                String txt = txtBuscar.getText().toLowerCase();
                String[] arr = listar.listarArreglo(libros);

                java.util.List<String> filtrados = new java.util.ArrayList<>();

                for (String s : arr) {
                    if (s.toLowerCase().contains(txt)) filtrados.add(s);
                }
                lista.setListData(filtrados.toArray(new String[0]));
            }
        });

        btnAgregar.addActionListener(e -> {
            libros = registrar.agregar(libros);
            lista.setListData(listar.listarArreglo(libros));
        });

        btnEditar.addActionListener(e -> {
            editar.editar(libros);
            lista.setListData(listar.listarArreglo(libros));
        });

        btnEliminar.addActionListener(e -> {
            eliminar.eliminar(libros);
            lista.setListData(listar.listarArreglo(libros));
        });

        // --- Acción: Ver detalles ---
        btnDetalles.addActionListener(e -> {
            int selectedIndex = lista.getSelectedIndex();
            if (selectedIndex == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un libro para ver detalles.");
                return;
            }

            String seleccionado = lista.getSelectedValue(); // formato: "1 - Nombre (Estado) ..." 
            if (seleccionado == null || seleccionado.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Elemento inválido seleccionado.");
                return;
            }

            // obtener el código (parte antes de " - ")
            String[] parts = seleccionado.split(" - ");
            String codigoStr = parts[0].trim();
            int codigo;
            try {
                codigo = Integer.parseInt(codigoStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "No se pudo leer el código del elemento seleccionado.");
                return;
            }

            // buscar el libro real
            Libro libro = null;
            for (Libro l : libros) {
                if (l != null && l.getCodigo() == codigo) {
                    libro = l;
                    break;
                }
            }

            if (libro == null) {
                JOptionPane.showMessageDialog(null, "Libro no encontrado.");
                return;
            }

            // mostrar toda la info (usa el método info() que ya formatea préstamo si existe)
            JOptionPane.showMessageDialog(null, libro.info(), "Detalles del libro", JOptionPane.INFORMATION_MESSAGE);
        });

        btnSalir.addActionListener(e -> System.exit(0));
        
        // CENTRAR VENTANA
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);     
    }
}
