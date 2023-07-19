package APIGestionProductos.Servicios;

import APIGestionProductos.DTO.ProductosDTO;
import APIGestionProductos.Modelos.Productos;

import java.util.List;

public interface ProductosServicio {
List<ProductosDTO> obtenerProductos();
Productos obtenerProductoPorID(Long id);

void guardarProducto (Productos productos);

void eliminarProducto (Long id);

}
