/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author migue
 */
public class ListarLibro {
public String[] listarArreglo(Libro[] libros) {

        String[] data = new String[libros.length];

        for (int i = 0; i < libros.length; i++) {
            Libro l = libros[i];

            if (l != null) {

                String base = l.getCodigo() + " - " + l.getNombre() + " (" + l.getEstado() + ")";

                if (l.getEstado().equals("Prestado")) {
                    base += " | Usuario: " + l.getUsuarioPrestamo();
                }

                data[i] = base;

            } else {
                data[i] = "";
            }
        }
        return data;
    }  
}
