package com.fincons.ecommerce.utenti.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "utenti")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUtente;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "COGNOME" , nullable = false)
    private String cognome;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "INDIRIZZO" , nullable = false)
    private String indirizzo;
}