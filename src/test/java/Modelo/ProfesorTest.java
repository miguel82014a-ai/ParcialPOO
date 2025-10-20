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
public class ProfesorTest {

    @Test
    void testConstructorAndGetters() {
        Profesor profesor = new Profesor("Carlos Gomez", "Av. Principal", "5551122", "1980-11-22", "123456789", "Matemáticas", 50.0, 160);
        assertEquals("Carlos Gomez", profesor.getNombre());
        assertEquals("Av. Principal", profesor.getDireccion());
        assertEquals("5551122", profesor.getTelefono());
        assertEquals("1980-11-22", profesor.getFechaNacimiento());
        assertEquals("123456789", profesor.getCedula());
        assertEquals("Matemáticas", profesor.getArea());
        assertEquals(50.0, profesor.getSalarioHora());
        assertEquals(160, profesor.getHorasTrabajadas());
    }

    @Test
    void testCalcularSalario() {
        Profesor profesor = new Profesor("Laura Perez", "Calle Falsa", "5553344", "1975-02-01", "987654321", "Literatura", 40.0, 100);
        assertEquals(4800.0, profesor.calcularSalario(), 0.001);
    }

    @Test
    void testCalcularPrestaciones() {
        Profesor profesor = new Profesor("Laura Perez", "Calle Falsa", "5553344", "1975-02-01", "987654321", "Literatura", 40.0, 100);
        assertEquals(816.0, profesor.calcularPrestaciones(), 0.001);
    }

    @Test
    void testObtenerDatosFormateados() {
        Profesor profesor = new Profesor("Roberto Sanchez", "Av. Siempre Viva", "5556677", "1982-09-05", "112233445", "Historia", 60.0, 120);
        String expected = "=== DATOS DEL PROFESOR ===\n" +
                          "Nombre: Roberto Sanchez\n" +
                          "Dirección: Av. Siempre Viva\n" +
                          "Teléfono: 5556677\n" +
                          "Fecha Nacimiento: 1982-09-05\n" +
                          "Cédula: 112233445\n" +
                          "Área: Historia\n" +
                          "Salario por Hora: $60\n" +
                          "Horas Trabajadas: 120";
        assertEquals(expected, profesor.obtenerDatosFormateados());
    }  
}
