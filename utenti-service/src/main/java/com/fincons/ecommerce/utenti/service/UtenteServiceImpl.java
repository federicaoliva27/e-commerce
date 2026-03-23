package com.fincons.ecommerce.utenti.service;

import com.fincons.ecommerce.utenti.exception.NotFoundException;
import com.fincons.ecommerce.utenti.model.Utente;
import com.fincons.ecommerce.utenti.repository.IUtenteRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UtenteServiceImpl implements IUtenteService {

    private final IUtenteRepository utenteRepository;

    @Override
    public List<Utente> getAllUsers() {
        return utenteRepository.findAll();
    }

    @Override
    public Utente getUserById(Integer idUtente) throws NotFoundException {
        Optional<Utente> optional = utenteRepository.findById(idUtente);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NotFoundException("Utente con id " + idUtente + " non trovato");
        }
    }

    @Override
    public Utente getUserByUsername(String cognome) {
        return null;
    }

    @Override
    public Utente getUserByEmail(String email) throws NotFoundException {
        Optional<Utente> optional = utenteRepository.findByEmail(email);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NotFoundException("Utente con email '" + email + "' non trovato");
        }
    }

    @Override
    public Utente saveNewUser(Utente utente) {
        return utenteRepository.save(utente);
    }

    @Override
    public Utente updateUser(Integer idUtente, Utente utente) throws NotFoundException {
        Utente user = getUserById(idUtente);
        user.setNome(utente.getNome());
        user.setCognome(utente.getCognome());
        user.setEmail(utente.getEmail());
        user.setIndirizzo(utente.getIndirizzo());
        return utenteRepository.save(user);
    }

    @Override
    public void deleteUserById(Integer idUtente) throws NotFoundException {
        Utente user = getUserById(idUtente);
        utenteRepository.delete(user);
    }
}