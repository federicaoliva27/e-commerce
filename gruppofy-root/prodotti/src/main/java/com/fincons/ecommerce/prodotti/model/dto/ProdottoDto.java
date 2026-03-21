package com.fincons.ecommerce.prodotti.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdottoDto {

    private Integer idProdotto;
    private String nome;
    private Double prezzo;
}