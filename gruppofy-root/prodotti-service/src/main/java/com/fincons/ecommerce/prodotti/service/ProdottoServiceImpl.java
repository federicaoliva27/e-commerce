package com.fincons.ecommerce.prodotti.service;

import com.fincons.ecommerce.prodotti.exception.NotFoundException;
import com.fincons.ecommerce.prodotti.model.Prodotto;
import com.fincons.ecommerce.prodotti.repository.IProdottoRepository;
import com.fincons.ecommerce.prodotti.repository.mapper.IProdottoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdottoServiceImpl implements IProdottoService {

    private final IProdottoRepository prodottoRepository;
    private final IProdottoMapper prodottoMapper;

    @Override
    public List<Prodotto> getAllProdotti() {
        return prodottoRepository.findAll();
    }

    @Override
    public Prodotto getProdottoById(Integer idProdotto) throws NotFoundException {
        Optional<Prodotto> optional = prodottoRepository.findById(idProdotto);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NotFoundException("Prodotto con id " + idProdotto + " non trovato");
        }
    }
    @Override
    public Prodotto saveNewProdotto(Prodotto prodotto) {
        return prodottoRepository.save(prodotto);
    }

    @Override
    public Prodotto updateProdotto(Integer idProdotto, Prodotto prodotto) throws NotFoundException {
        Prodotto prodotto1 = getProdottoById(idProdotto);
        prodotto1.setNome(prodotto.getNome());
        prodotto1.setPrezzo(prodotto.getPrezzo());
        return prodottoRepository.save(prodotto1);
    }

    @Override
    public void deleteProdottoById(Integer idProdotto) throws NotFoundException {
        Prodotto product = getProdottoById(idProdotto);
        prodottoRepository.delete(product);
    }
}
