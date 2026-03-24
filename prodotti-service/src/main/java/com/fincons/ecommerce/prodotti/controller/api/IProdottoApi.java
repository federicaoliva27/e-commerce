package com.fincons.ecommerce.prodotti.controller.api;
import com.fincons.ecommerce.prodotti.exception.NotFoundException;
import com.fincons.ecommerce.prodotti.model.dto.ProdottoDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IProdottoApi {

    @PostMapping
    ResponseEntity<ProdottoDto> saveNewProdotto(
            @Valid @RequestBody ProdottoDto dto
    );

    @GetMapping("/{id}")
    ResponseEntity<ProdottoDto> getProdottoById(
            @PathVariable
            @Min(1) @Max(1000) Integer id
    ) throws NotFoundException;

    @GetMapping
    ResponseEntity<List<ProdottoDto>> getAllProdotti();

    @PutMapping("/{id}")
    ResponseEntity<ProdottoDto> updateProdotto(
            @PathVariable
            @Min(1) @Max(1000) Integer id,
            @Valid @RequestBody ProdottoDto dto
    ) throws NotFoundException;

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteProdottoById(
            @PathVariable
            @Min(1) @Max(1000) Integer id
    );

    @GetMapping("/search")
    ResponseEntity<List<ProdottoDto>> searchProdottiByNome(
            @RequestParam
            @Size(min = 1, max = 50) String nome
    );
}
