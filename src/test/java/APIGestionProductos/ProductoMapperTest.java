package APIGestionProductos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import APIGestionProductos.DTO.ProductosDTO;
import APIGestionProductos.Mapper.ProductoMapper;
import APIGestionProductos.Modelos.Productos;
import org.junit.jupiter.api.Test;

public class ProductoMapperTest {

    private final ProductoMapper mapper = ProductoMapper.INSTANCE;



    @Test
    public void testToDTOMapping() {
        Productos producto = new Productos();
        producto.setNombre("Nombre del producto");
        producto.setDescripcion("Descripción del producto");

        ProductosDTO productoDTO = mapper.toDTO(producto);

        assertEquals(producto.getNombre(), productoDTO.getNombre());
        assertEquals(producto.getDescripcion(), productoDTO.getDescripcion());
    }

    @Test
    public void testToEntityMapping() {
        ProductosDTO productoDTO = new ProductosDTO();
        productoDTO.setNombre("Nombre del producto");
        productoDTO.setDescripcion("Descripción del producto");

        Productos producto = mapper.toEntity(productoDTO);

        assertEquals(productoDTO.getNombre(), producto.getNombre());
        assertEquals(productoDTO.getDescripcion(), producto.getDescripcion());
    }
}

