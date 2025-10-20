/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author migue
 */
public class Estudiante extends Persona{
    private String grado;
    private double promedio;
    
    public Estudiante(String nombre, String direccion, String telefono, String fechaNacimiento, String grado, double promedio) {
        super(nombre, direccion, telefono, fechaNacimiento);
        this.grado = grado;
        this.promedio = promedio;
    }
    

    public String obtenerDatosFormateados() {
        return " DATOS DEL ESTUDIANTE \n" +
               super.obtenerDatosFormateados() + "\n" +
               "Grado: " + grado + "\n" +
               "Promedio: " + promedio + "\n" +
               "------------------------";
    }
    
}
