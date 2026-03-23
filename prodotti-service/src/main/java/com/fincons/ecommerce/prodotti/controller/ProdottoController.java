package com.fincons.ecommerce.prodotti.controller;

import com.fincons.ecommerce.prodotti.controller.api.IProdottoApi;
import com.fincons.ecommerce.prodotti.exception.NotFoundException;
import com.fincons.ecommerce.prodotti.repository.mapper.IProdottoMapper;
import com.fincons.ecommerce.prodotti.model.Prodotto;
import com.fincons.ecommerce.prodotti.model.dto.ProdottoDto;
import com.fincons.ecommerce.prodotti.service.IProdottoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/prodotti")
@RequiredArgsConstructor
public class ProdottoController implements IProdottoApi {

    private final IProdottoService prodottoService;
    private final IProdottoMapper prodottoMapper;

    @Override
    public ResponseEntity<ProdottoDto> saveNewProdotto(ProdottoDto dto) {
        log.info("Creazione nuovo prodotto: {}", dto.getNome());
        Prodotto prodotto = prodottoMapper.toDomain(dto);
        Prodotto saved = prodottoService.saveNewProdotto(prodotto);
        return ResponseEntity.status(HttpStatus.CREATED).body(prodottoMapper.toDto(saved));
    }

    @Override
    public ResponseEntity<ProdottoDto> getProdottoById(Integer id) throws NotFoundException {
        log.info("Ricerca prodotto con id: {}", id);
        Prodotto prodotto = prodottoService.getProdottoById(id);
        return ResponseEntity.ok(prodottoMapper.toDto(prodotto));
    }

    @Override
    public ResponseEntity<List<ProdottoDto>> getAllProdotti() {
        log.info("Recupero lista di tutti i prodotti");
        List<Prodotto> prodotti = prodottoService.getAllProdotti();
        List<ProdottoDto> result = new ArrayList<>();
        for (Prodotto prodotto : prodotti) {
            result.add(prodottoMapper.toDto(prodotto));
        }
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<ProdottoDto> updateProdotto(Integer id, ProdottoDto dto) throws NotFoundException {
        log.info("Aggiornamento prodotto con id: {}", id);
        Prodotto prodotto = prodottoMapper.toDomain(dto);
        Prodotto updated = prodottoService.updateProdotto(id, prodotto);
        return ResponseEntity.ok(prodottoMapper.toDto(updated));
    }

    @Override
    public ResponseEntity<String> deleteProdottoById(Integer id) {
        log.info("Eliminazione prodotto con id: {}", id);
        try {
            prodottoService.deleteProdottoById(id);
            return ResponseEntity.ok("Prodotto con id " + id + " eliminato con successo");
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<List<ProdottoDto>> searchProdottiByNome(String nome) {
        log.info("Ricerca prodotti per nome: {}", nome);
        List<Prodotto> tutti = prodottoService.getAllProdotti();
        List<ProdottoDto> result = new ArrayList<>();
        for (Prodotto prodotto : tutti) {
            if (prodotto.getNome().equalsIgnoreCase(nome)) {
                result.add(prodottoMapper.toDto(prodotto));
            }
        }
        return ResponseEntity.ok(result);
    }
}