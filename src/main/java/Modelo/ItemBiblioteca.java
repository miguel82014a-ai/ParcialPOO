/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Angello
 */
public abstract class ItemBiblioteca {
    
 protected int codigo;
    protected String nombre;
    protected String estado; // Disponible, Prestado, Inactivo

    public ItemBiblioteca(int codigo, String nombre, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

    public abstract String info();
    
}
