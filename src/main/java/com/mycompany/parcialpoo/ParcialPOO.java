/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.parcialpoo;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import Modelo.Estudiante;
import Modelo.Profesor;

/**
 *
 * @author migue
 */
public class ParcialPOO {
    private static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private static ArrayList<Profesor> profesores = new ArrayList<>();
    
    public static void main(String[] args) {
                boolean continuar = true;
        
        while (continuar) {
            String opcion = JOptionPane.showInputDialog(
                "=== SISTEMA DEL COLEGIO ===\n\n" +
                "1. Agregar Estudiante\n" +
                "2. Agregar Profesor\n" +
                "3. Ver Reporte de Estudiantes\n" +
                "4. Ver Reporte de Profesores\n" +
                "5. Salir\n\n" +
                "Seleccione una opción:"
            );
            
            if (opcion == null) {
                break;
            }
            
            switch (opcion) {
                case "1":
                    agregarEstudiante();
                    break;
                case "2":
                    agregarProfesor();
                    break;
                case "3":
                    mostrarReporteEstudiantes();
                    break;
                case "4":
                    mostrarReporteProfesores();
                    break;
                case "5":
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Saliendo de el sistema");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        }
    }
    
    public static void agregarEstudiante() {
        try {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
            String direccion = JOptionPane.showInputDialog("Ingrese la dirección:");
            String telefono = JOptionPane.showInputDialog("Ingrese el teléfono:");
            String fechaNacimiento = JOptionPane.showInputDialog("Ingrese fecha de nacimiento (YYYY-MM-DD):");
            String grado = JOptionPane.showInputDialog("Ingrese el grado:");
            String promedioStr = JOptionPane.showInputDialog("Ingrese el promedio:");
            double promedio = Double.parseDouble(promedioStr);
            
            Estudiante estudiante = new Estudiante(nombre, direccion, telefono, fechaNacimiento, grado, promedio);
            estudiantes.add(estudiante);
            
            JOptionPane.showMessageDialog(null, "Estudiante agregado exitosamente!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar estudiante: " + e.getMessage());
        }
    }
    
    // Método para agregar profesor
    public static void agregarProfesor() {
        try {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del profesor:");
            String direccion = JOptionPane.showInputDialog("Ingrese la dirección:");
            String telefono = JOptionPane.showInputDialog("Ingrese el teléfono:");
            String fechaNacimiento = JOptionPane.showInputDialog("Ingrese fecha de nacimiento (YYYY-MM-DD):");
            String cedula = JOptionPane.showInputDialog("Ingrese la cédula:");
            String area = JOptionPane.showInputDialog("Ingrese el área:");
            String salarioStr = JOptionPane.showInputDialog("Ingrese el salario por hora:");
            String horasStr = JOptionPane.showInputDialog("Ingrese las horas trabajadas:");
            
            double salarioHora = Double.parseDouble(salarioStr);
            int horasTrabajadas = Integer.parseInt(horasStr);
            
            Profesor profesor = new Profesor(nombre, direccion, telefono, fechaNacimiento, cedula, area, salarioHora, horasTrabajadas);
            profesores.add(profesor);
            
            JOptionPane.showMessageDialog(null, "Profesor agregado exitosamente!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar profesor: " + e.getMessage());
        }
    }
    
    public static void mostrarReporteEstudiantes() {
        if (estudiantes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay estudiantes registrados.");
            return;
        }
        
        StringBuilder reporte = new StringBuilder();
        reporte.append(" REPORTE DE ESTUDIANTES \n\n");
        
        for (Estudiante estudiante : estudiantes) {
            reporte.append(estudiante.obtenerDatosFormateados()).append("\n");
        }
        
        JOptionPane.showMessageDialog(null, reporte.toString());
    }
    
    public static void mostrarReporteProfesores() {
        if (profesores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay profesores registrados.");
            return;
        }
        
        ordenarProfesoresPorSalario();
        
        StringBuilder reporte = new StringBuilder();
        reporte.append(" REPORTE DE PROFESORES (Ordenado por Salario) \n\n");
        
        double totalPrestaciones = 0;
        
        for (Profesor profesor : profesores) {
            reporte.append(profesor.obtenerDatosFormateados()).append("\n");
            double salarioTotal = profesor.calcularSalario();
            double prestaciones = profesor.calcularPrestaciones();
            totalPrestaciones += prestaciones;
            
            reporte.append("Salario Total: $").append(String.format("%,.0f", salarioTotal)).append("\n");
            reporte.append("Prestaciones Sociales: $").append(String.format("%,.0f", prestaciones)).append("\n");
            reporte.append("------------------------\n\n");
        }
        
        reporte.append("TOTAL PRESTACIONES SOCIALES: $").append(String.format("%,.0f", totalPrestaciones));
        
        JOptionPane.showMessageDialog(null, reporte.toString());
    }
    
    public static void ordenarProfesoresPorSalario() {
        for (int i = 0; i < profesores.size() - 1; i++) {
            for (int j = 0; j < profesores.size() - i - 1; j++) {
                double salario1 = profesores.get(j).calcularSalario();
                double salario2 = profesores.get(j + 1).calcularSalario();
                if (salario1 > salario2) {
                    Profesor temp = profesores.get(j);
                    profesores.set(j, profesores.get(j + 1));
                    profesores.set(j + 1, temp);
                }
            }
        }
    }
    
}

