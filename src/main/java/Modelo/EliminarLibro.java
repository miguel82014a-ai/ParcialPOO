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
public class EliminarLibro {
 public void eliminar(Libro[] libros) {

        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código del libro a inactivar:"));

        for (Libro l : libros) {
            if (l != null && l.getCodigo() == codigo) {
                l.setEstado("Inactivo");
                JOptionPane.showMessageDialog(null, "Libro marcado como INACTIVO.");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Libro no encontrado.");
    }   
}
