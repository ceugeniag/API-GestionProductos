package APIGestionProductos.Mapper;
import APIGestionProductos.DTO.ProductosDTO;
import APIGestionProductos.Modelos.Productos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductoMapper {

    ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);

    ProductosDTO toDTO(Productos productos);

    Productos toEntity(ProductosDTO productoDTO);
}
