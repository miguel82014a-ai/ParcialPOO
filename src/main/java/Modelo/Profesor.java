/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author migue
 */
public class Profesor extends Persona {
        private String cedula;
    private String area;
    private double salarioHora;
    private int horasTrabajadas;
    
    public Profesor(String nombre, String direccion, String telefono, String fechaNacimiento, String cedula, String area, double salarioHora, int horasTrabajadas) {
        super(nombre, direccion, telefono, fechaNacimiento);
        this.cedula = cedula;
        this.area = area;
        this.salarioHora = salarioHora;
        this.horasTrabajadas = horasTrabajadas;
    }
    

    public double calcularSalario() {
        double salarioBase = salarioHora * horasTrabajadas;
        double preparacionClase = salarioBase * 0.20;
        return salarioBase + preparacionClase;
    }
    

    public double calcularPrestaciones() {
        double salarioTotal = calcularSalario();
        return salarioTotal * 0.17;
    }
    
    public String obtenerDatosFormateados() {
        return "=== DATOS DEL PROFESOR ===\n" +
               super.obtenerDatosFormateados() + "\n" +
               "Cédula: " + cedula + "\n" +
               "Área: " + area + "\n" +
               "Salario por Hora: $" + String.format("%,.0f", salarioHora) + "\n" +
               "Horas Trabajadas: " + horasTrabajadas;
    }
    
}
