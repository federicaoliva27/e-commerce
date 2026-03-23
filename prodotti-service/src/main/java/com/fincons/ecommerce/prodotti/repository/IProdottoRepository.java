package com.fincons.ecommerce.prodotti.repository;

import com.fincons.ecommerce.prodotti.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProdottoRepository extends JpaRepository<Prodotto, Integer> {

}