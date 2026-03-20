package inventario.repository.mapper;

import inventario.model.Inventario;
import inventario.model.dto.InventarioDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IInventarioMapper {
    IInventarioMapper INSTANCE = Mappers.getMapper(IInventarioMapper.class);

    InventarioDto toInventarioDto (Inventario inventorio);
    Inventario toInventario (InventarioDto innventarioDto);
}
