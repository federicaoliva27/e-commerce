package com.fincons.ecommerce.utenti.repository;

import com.fincons.ecommerce.utenti.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUtenteRepository extends JpaRepository<Utente, Integer> {

    Optional<Utente> findByEmail(String email);

}