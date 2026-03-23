package com.fincons.ecommerce.utenti.service;

import com.fincons.ecommerce.utenti.exception.NotFoundException;
import com.fincons.ecommerce.utenti.model.Utente;

import java.util.List;

public interface IUtenteService {

    List<Utente> getAllUsers();

    Utente getUserById(Integer idUtente) throws NotFoundException;

    Utente getUserByUsername(String cognome);

    Utente getUserByEmail(String email) throws NotFoundException;

    Utente saveNewUser(Utente utente);

    Utente updateUser(Integer idUtente, Utente utente) throws NotFoundException;

    void deleteUserById(Integer idUtente) throws NotFoundException;
}
