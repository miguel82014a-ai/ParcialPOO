/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author migue
 */
public class EditarLibro {
    
    public void editar(Libro[] libros) {

        int codigo = Integer.parseInt(
                JOptionPane.showInputDialog("Código del libro a editar:")
        );

        for (Libro l : libros) {

            if (l != null && l.getCodigo() == codigo) {

                int op = Integer.parseInt(JOptionPane.showInputDialog(
                        "1. Prestar libro\n" +
                        "2. Devolver libro\n" +
                        "3. Activar libro"
                ));

                switch (op) {

                    case 1:
                        String usuario = JOptionPane.showInputDialog("Nombre del usuario:");
                        String fechaPrestamo = JOptionPane.showInputDialog("Fecha préstamo:");
                        String fechaEntrega = JOptionPane.showInputDialog("Fecha entrega:");
                        l.prestar(usuario, fechaPrestamo, fechaEntrega);
                        break;

                    case 2:
                        l.devolver();
                        break;

                    case 3:
                        l.setEstado("Disponible");
                        break;
                }

                JOptionPane.showMessageDialog(null, "Actualizado correctamente.");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Libro no encontrado.");
    }   
}
