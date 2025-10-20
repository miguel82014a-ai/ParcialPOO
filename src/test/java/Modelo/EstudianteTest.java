/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author migue
 */
public class EstudianteTest {
    
    @Test
    void testConstructorAndGetters() {
        Estudiante estudiante = new Estudiante("Ana Garcia", "Carrera 45", "9876543", "2005-03-15", "10A", 4.5);
        assertEquals("Ana Garcia", estudiante.getNombre());
        assertEquals("Carrera 45", estudiante.getDireccion());
        assertEquals("9876543", estudiante.getTelefono());
        assertEquals("2005-03-15", estudiante.getFechaNacimiento());
        assertEquals("10A", estudiante.getGrado());
        assertEquals(4.5, estudiante.getPromedio());
    }

    @Test
    void testObtenerDatosFormateados() {
        Estudiante estudiante = new Estudiante("Pedro Ramirez", "Calle 10", "1122334", "2006-07-20", "9B", 3.8);
        String expected = " DATOS DEL ESTUDIANTE \n" +
                          "Nombre: Pedro Ramirez\n" +
                          "Dirección: Calle 10\n" +
                          "Teléfono: 1122334\n" +
                          "Fecha Nacimiento: 2006-07-20\n" +
                          "Grado: 9B\n" +
                          "Promedio: 3.8\n" +
                          "------------------------";
        assertEquals(expected, estudiante.obtenerDatosFormateados());
    }
}
