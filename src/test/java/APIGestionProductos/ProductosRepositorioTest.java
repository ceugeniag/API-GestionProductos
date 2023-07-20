package APIGestionProductos;

import APIGestionProductos.Repositorios.ProductosRepositorio;
import APIGestionProductos.Modelos.Productos;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductosRepositorioTest {

    @Autowired
    private ProductosRepositorio productosRepositorio;

    @Test
    public void testGuardarProducto() {
        Productos producto = new Productos();
        producto.setNombre("Nombre del producto");
        producto.setDescripcion("Descripción del producto");

        productosRepositorio.save(producto);
        Productos productoGuardado = productosRepositorio.findById(producto.getId()).orElse(null);

        assertNotNull(productoGuardado);
        assertEquals(producto.getNombre(), productoGuardado.getNombre());
        assertEquals(producto.getDescripcion(), productoGuardado.getDescripcion());
    }

}

