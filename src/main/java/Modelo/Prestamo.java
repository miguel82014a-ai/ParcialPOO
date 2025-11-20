/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Angello
 */
public interface Prestamo {
    
     void prestar(String usuario, String fechaPrestamo, String fechaEntrega);
    void devolver();  
    
}
