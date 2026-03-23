package com.fincons.ecommerce.prodotti.repository.mapper;

import com.fincons.ecommerce.prodotti.model.Prodotto;
import com.fincons.ecommerce.prodotti.model.dto.ProdottoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProdottoMapper {

    Prodotto toDomain(ProdottoDto dto);   // DTO → DOMAIN
    ProdottoDto toDto(Prodotto prodotto); // DOMAIN → DTO
}