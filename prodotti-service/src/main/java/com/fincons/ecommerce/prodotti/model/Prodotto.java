package com.fincons.ecommerce.prodotti.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "prodotti")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProdotto;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "PREZZO", nullable = false)
    private Double prezzo;

}