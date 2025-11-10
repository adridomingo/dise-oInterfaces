package org.example.ej11listadoproductos;

public class Producto {
    private String nombre;
    private Integer unidades;
    private Double precio;
    private Double subtotal;

    public Producto(String nombre, Integer unidades, Double precio, Double subtotal) {
        this.nombre = nombre;
        this.unidades = unidades;
        this.precio = precio;
        this.subtotal = subtotal;
    }

    public Producto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", unidades='" + unidades + '\'' +
                ", precio=" + precio +
                ", subtotal=" + subtotal +
                '}';
    }
}
