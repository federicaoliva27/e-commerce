package com.fincons.ecommerce.utenti.service;

import com.fincons.ecommerce.utenti.model.Utente;

import java.util.List;

public interface IUtenteService {

    List<Utente> getAllUsers();

    Utente getUserById(Integer idUtente);

    Utente getUserByUsername(String cognome);

    Utente saveNewUser(Utente utente);

    Utente updateUser(Integer idUtente, Utente utente);

    void deleteUserById(Integer idUtente);
}
