/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Angello
 */
public class Libro extends ItemBiblioteca implements Prestamo{
    
    private String autor;
    private String genero;

    private String usuarioPrestamo;
    private String fechaPrestamo;
    private String fechaEntrega;

    public Libro(int codigo, String nombre, String autor, String genero) {
        super(codigo, nombre, "Disponible");
        this.autor = autor;
        this.genero = genero;
    }
    
    public String getUsuarioPrestamo() { return usuarioPrestamo; }
    public String getFechaPrestamo() { return fechaPrestamo; }
    public String getFechaEntrega() { return fechaEntrega; }
    
    public String getAutor() { return autor; }
    public String getGenero() { return genero; }
    @Override
    public String info() {
        String p = (estado.equals("Prestado"))
                ? "\nPrestado a: " + usuarioPrestamo +
                  "\nFecha préstamo: " + fechaPrestamo +
                  "\nFecha entrega: " + fechaEntrega
                : "";

        return "Código: " + codigo +
               "\nNombre: " + nombre +
               "\nAutor: " + autor +
               "\nGénero: " + genero +
               "\nEstado: " + estado + p;
    }

    @Override
    public void prestar(String usuario, String fechaPrestamo, String fechaEntrega) {
        this.estado = "Prestado";
        this.usuarioPrestamo = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
    }

    @Override
    public void devolver() {
        this.estado = "Disponible";
        usuarioPrestamo = null;
        fechaPrestamo = null;
        fechaEntrega = null;
    } 
}
