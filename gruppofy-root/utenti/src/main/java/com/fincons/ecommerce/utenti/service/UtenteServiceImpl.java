package com.fincons.ecommerce.utenti.service;

import com.fincons.ecommerce.utenti.model.Utente;
import com.fincons.ecommerce.utenti.repository.IUtenteRepository;
import com.fincons.ecommerce.utenti.repository.mapper.IUtenteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UtenteServiceImpl implements IUtenteService {

    @Qualifier("utenteRepository")
    private IUtenteRepository utenteRepository;

    private IUtenteMapper iUtenteMapper;

    @Override
    public List<Utente> getAllUsers() {
        return List.of();
    }

    @Override
    public Utente getUserById(Integer idUtente) {
        return null;
    }

    @Override
    public Utente getUserByUsername(String cognome) {
        return null;
    }

    @Override
    public Utente saveNewUser(Utente utente) {
        return null;
    }

    @Override
    public Utente updateUser(Integer idUtente, Utente utente) {
        return null;
    }

    @Override
    public void deleteUserById(Integer idUtente) {

    }
}