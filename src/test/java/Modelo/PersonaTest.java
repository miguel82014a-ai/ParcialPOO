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
public class PersonaTest {
        @Test
    void testConstructorAndGetters() {
        Persona persona = new Persona("Juan Perez", "Calle 123", "1234567", "2000-01-01");
        assertEquals("Juan Perez", persona.getNombre());
        assertEquals("Calle 123", persona.getDireccion());
        assertEquals("1234567", persona.getTelefono());
        assertEquals("2000-01-01", persona.getFechaNacimiento());
    }

    @Test
    void testObtenerDatosFormateados() {
        Persona persona = new Persona("Maria Lopez", "Av. Siempre Viva", "7654321", "1995-05-10");
        String expected = "Nombre: Maria Lopez\n" +
                          "Dirección: Av. Siempre Viva\n" +
                          "Teléfono: 7654321\n" +
                          "Fecha Nacimiento: 1995-05-10";
        assertEquals(expected, persona.obtenerDatosFormateados());
    }
}
