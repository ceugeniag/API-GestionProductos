package APIGestionProductos.Repositorios;

import APIGestionProductos.Modelos.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductosRepositorio extends JpaRepository <Productos, Long>{

}
