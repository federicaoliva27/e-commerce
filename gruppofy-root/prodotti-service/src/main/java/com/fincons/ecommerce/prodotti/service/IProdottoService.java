package com.fincons.ecommerce.prodotti.service;

import com.fincons.ecommerce.prodotti.exception.NotFoundException;
import com.fincons.ecommerce.prodotti.model.Prodotto;

import java.util.List;

public interface IProdottoService {

    List<Prodotto> getAllProdotti();

    Prodotto getProdottoById(Integer idProdotto) throws NotFoundException;

    Prodotto saveNewProdotto(Prodotto prodotto);

    Prodotto updateProdotto(Integer idProdotto, Prodotto prodotto) throws NotFoundException;

    void deleteProdottoById(Integer idProdotto) throws NotFoundException;
}