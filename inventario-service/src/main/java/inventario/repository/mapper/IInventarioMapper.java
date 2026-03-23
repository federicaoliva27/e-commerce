package inventario.repository.mapper;

import inventario.model.Inventario;
import inventario.model.dto.InventarioDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface IInventarioMapper {
    InventarioDto toInventarioDto (Inventario inventorio);
    Inventario toInventario (InventarioDto innventarioDto);
}
