package APIGestionProductos.Controladores;

import APIGestionProductos.DTO.ProductosDTO;
import APIGestionProductos.Modelos.Productos;
import APIGestionProductos.Repositorios.ProductosRepositorio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class ProductosControlador {

    private ProductosRepositorio productosRepositorio;

    @GetMapping("/api/productos")
    private List<ProductosDTO> obtenerProductos(){
        return productosRepositorio.findAll().stream().map(productos -> new ProductosDTO(productos)).collect(Collectors.toList());
    }

    //@PostMapping("/api/productos")
    //private ResponseEntity<Object> agregarProducto(@RequestBody Productos productos){

    //}


}
