package ordini.repository.mapper;

import ordini.model.Ordine;
import ordini.model.dto.OrdineDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IOrdineMapper {
    OrdineDto toOrdineDto (Ordine ordine);
    Ordine toOrdine (OrdineDto ordineDto);
}
