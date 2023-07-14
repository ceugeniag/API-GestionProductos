package APIGestionProductos.Modelos;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidad;
    private LocalDate fecha;

    //CONSTRUCTORES
    public Productos() {}
    public Productos(String nombre, String descripcion, double precio, int cantidad, LocalDate fecha) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    //METODOS ACCESORES
    public long getId() { return id;}
    public String getNombre() { return nombre;}
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }
    public LocalDate getFecha() { return fecha; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setPrecio(double precio) { this.precio = precio;}
    public void setCantidad(int cantidad) { this.cantidad = cantidad;}
    public void setFecha(LocalDate fecha) { this.fecha = fecha;}

}
