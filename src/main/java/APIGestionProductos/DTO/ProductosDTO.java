package APIGestionProductos.DTO;

import APIGestionProductos.Modelos.Productos;

import java.time.LocalDate;

public class ProductosDTO {
    private long id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidad;
    private LocalDate fecha;

    public ProductosDTO() {}

    public ProductosDTO(Productos productos) {
        this.id = productos.getId();
        this.nombre = productos.getNombre();
        this.descripcion = productos.getDescripcion();
        this.precio = productos.getPrecio();
        this.cantidad = productos.getCantidad();
        this.fecha = productos.getFecha();
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
