package com.fincons.ecommerce.utenti.controller.api;

import com.fincons.ecommerce.utenti.exception.NotFoundException;
import com.fincons.ecommerce.utenti.model.dto.UtenteDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/utenti")
public interface IUtenteApi {

    @PostMapping
    ResponseEntity<UtenteDto> saveNewUtente(
            @Valid @RequestBody UtenteDto dto
    );

    @GetMapping("/{id}")
    ResponseEntity<UtenteDto> getUtenteById(
            @PathVariable
            @Min(1) @Max(1000) Integer id
    ) throws NotFoundException;

    @GetMapping
    ResponseEntity<List<UtenteDto>> getAllUtenti();

    @PutMapping("/{id}")
    ResponseEntity<UtenteDto> updateUtente(
            @PathVariable
            @Min(1) @Max(1000) Integer id,
            @Valid @RequestBody UtenteDto dto
    ) throws NotFoundException;

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteUtenteById(
            @PathVariable
            @Min(1) @Max(1000) Integer id
    );

    @GetMapping("/search")
    ResponseEntity<List<UtenteDto>> searchUtentiByNome(
            @RequestParam
            @Size(min = 1, max = 50) String nome
    );
}