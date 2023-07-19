package APIGestionProductos.Servicios.Implementacion;

import APIGestionProductos.DTO.ProductosDTO;
import APIGestionProductos.Modelos.Productos;
import APIGestionProductos.Repositorios.ProductosRepositorio;
import APIGestionProductos.Servicios.ProductosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductosServicioImplementacion implements ProductosServicio {

    @Autowired
    ProductosRepositorio productosRepositorio;


    @Override
    public List<ProductosDTO> obtenerProductos() {
        List<Productos> productosLista = productosRepositorio.findAll();
        return productosLista.stream().map(productos -> new ProductosDTO(productos)).collect(Collectors.toList());
    }


    @Override
    public Productos obtenerProductoPorID(Long id) {
        return productosRepositorio.findById(id).orElse(null);
    }

    @Override
    public void guardarProducto(Productos productos) {
        productosRepositorio.save(productos);

    }

    /*@Override
    public void eliminarProducto(Long id) {
        productosRepositorio.delete(id);
    }*/

    @Override
    public void eliminarProducto(Long id) {
        Productos productoAEliminar = productosRepositorio.findById(id).orElse(null);
        if (productoAEliminar != null) {
            productosRepositorio.delete(productoAEliminar);
        }
    }
}
