package com.fincons.ecommerce.utenti.controller;

import com.fincons.ecommerce.utenti.controller.api.IUtenteApi;
import com.fincons.ecommerce.utenti.exception.NotFoundException;
import com.fincons.ecommerce.utenti.repository.mapper.IUtenteMapper;
import com.fincons.ecommerce.utenti.model.Utente;
import com.fincons.ecommerce.utenti.model.dto.UtenteDto;
import com.fincons.ecommerce.utenti.service.IUtenteService;

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
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UtenteController implements IUtenteApi {

    private final IUtenteService utenteService;
    private final IUtenteMapper utenteMapper;

    @Override
    public ResponseEntity<UtenteDto> saveNewUtente(UtenteDto dto) {
        log.info("Creazione nuovo utente: {}", dto.getEmail());
        Utente utente = utenteMapper.toDomain(dto);
        Utente saved = utenteService.saveNewUser(utente);
        UtenteDto result = utenteMapper.toDto(saved);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Override
    public ResponseEntity<UtenteDto> getUtenteById(Integer id) throws NotFoundException {
        log.info("Ricerca utente con id: {}", id);
        Utente utente = utenteService.getUserById(id);
        UtenteDto result = utenteMapper.toDto(utente);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<UtenteDto>> getAllUtenti() {
        log.info("Recupero lista di tutti gli utenti");
        List<Utente> utenti = utenteService.getAllUsers();
        List<UtenteDto> result = new ArrayList<>();
        for (Utente utente : utenti) {
            result.add(utenteMapper.toDto(utente));
        }
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<UtenteDto> updateUtente(Integer id, UtenteDto dto) throws NotFoundException {
        log.info("Aggiornamento utente con id: {}", id);
        Utente utente = utenteMapper.toDomain(dto);
        Utente updated = utenteService.updateUser(id, utente);
        UtenteDto result = utenteMapper.toDto(updated);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<String> deleteUtenteById(Integer id) {
        log.info("Eliminazione utente con id: {}", id);
        try {
            utenteService.deleteUserById(id);
            return ResponseEntity.ok("Utente con id " + id + " eliminato con successo");
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<List<UtenteDto>> searchUtentiByNome(String nome) {
        log.info("Ricerca utenti per nome: {}", nome);
        List<Utente> tutti = utenteService.getAllUsers();
        List<UtenteDto> result = new ArrayList<>();
        for (Utente utente : tutti) {
            if (utente.getNome().equalsIgnoreCase(nome)) {
                result.add(utenteMapper.toDto(utente));
            }
        }
        return ResponseEntity.ok(result);
    }
}