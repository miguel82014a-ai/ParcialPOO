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
public class RegistrarLibro {
    
    public Libro[] agregar(Libro[] libros) {

        int n = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos libros desea registrar?"));
        Libro[] nuevos = new Libro[libros.length + n];

        // Copiar los existentes
        System.arraycopy(libros, 0, nuevos, 0, libros.length);

        for (int i = libros.length; i < nuevos.length; i++) {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código:"));
            String nombre = JOptionPane.showInputDialog("Nombre:");
            String autor = JOptionPane.showInputDialog("Autor:");
            String genero = JOptionPane.showInputDialog("Género:");

            nuevos[i] = new Libro(codigo, nombre, autor, genero);
        }

        JOptionPane.showMessageDialog(null, "Libros agregados con éxito.");
        return nuevos;
    }   
}
