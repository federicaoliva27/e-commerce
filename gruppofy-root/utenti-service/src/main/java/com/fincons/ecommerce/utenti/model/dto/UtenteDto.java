package com.fincons.ecommerce.utenti.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UtenteDto {

    private Integer idUtente;
    private String nome;
    private String cognome;
    private String email;
    private String indirizzo;

}