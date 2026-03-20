package com.fincons.ecommerce.utenti.repository.mapper;

import com.fincons.ecommerce.utenti.model.Utente;
import com.fincons.ecommerce.utenti.model.dto.UtenteDto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IUtenteMapper {

    IUtenteMapper INSTANCE = Mappers.getMapper(IUtenteMapper.class);

    Utente toDomain(UtenteDto entity);   // ENTITY → DOMAIN
    UtenteDto toEntity(Utente domain);   // DOMAIN → ENTITY
}