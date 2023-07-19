package APIGestionProductos.Controladores;

import APIGestionProductos.DTO.ProductosDTO;
import APIGestionProductos.Modelos.Productos;
import APIGestionProductos.Servicios.ProductosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductosControlador {

    @Autowired
    private ProductosServicio productosServicio;


    // CREAR UN PRODUCTO
    @PostMapping("/productos")
    public ResponseEntity<Object> crearProducto(@RequestBody Productos productos){
        List<ProductosDTO> productosDTO = productosServicio.obtenerProductos();
        if (productos.getNombre().isBlank() || productos.getDescripcion().isBlank() || productos.getPrecio() < 0 || productos.getCantidad() < 0){
            return new ResponseEntity<>("Falta información para crear el producto", HttpStatus.FORBIDDEN);
        } else if (!productosServicio.obtenerProductos().stream().filter(productosDTO1 -> productosDTO1.getNombre().equalsIgnoreCase(productos.getNombre())).collect(Collectors.toList()).isEmpty()) {
            return new ResponseEntity<>("El nombre "+ productos.getNombre()+ " ya está en uso", HttpStatus.FORBIDDEN);
        }
        Productos nuevoProducto = new Productos(productos.getNombre(), productos.getDescripcion(), productos.getPrecio(), productos.getCantidad(), LocalDate.now());
        productosServicio.guardarProducto(nuevoProducto);

        return new ResponseEntity<>("Respuesta exitosa", HttpStatus.CREATED);
    }

    //RETORNA LA LISTA DE PRODUCTOS
    @GetMapping("/productos")
    public List<ProductosDTO> obtenerProductos(){
        return productosServicio.obtenerProductos();
    }

    // RETORNA UN PRODUCTO POR ID
    @GetMapping("/productos/{id}")
    public ResponseEntity<Object> productoID(@PathVariable Long id){
        Productos producto = productosServicio.obtenerProductoPorID(id);
        if (producto != null){
            return new ResponseEntity<>("Respuesta exitosa", HttpStatus.ACCEPTED);
        } else return new ResponseEntity<>("El producto no existe", HttpStatus.FORBIDDEN);
    }

    //ELIMINAR UN PRODUCTO POR ID
    @DeleteMapping("/producto/{id}")
    public ResponseEntity<Object> eliminarProducto(@PathVariable Long id){
        Productos productoAEliminar = productosServicio.obtenerProductoPorID(id);
        if (productoAEliminar != null){
            productosServicio.eliminarProducto(id);
            return new ResponseEntity<>("Producto eliminado exitosamente", HttpStatus.NO_CONTENT);
        } else  return new ResponseEntity<>("El producto no existe", HttpStatus.FORBIDDEN);
    }
}
