package ordini.service;

import lombok.extern.slf4j.Slf4j;

import ordini.model.Ordine;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrdineServiceImpl implements IOrdineService {

    @Qualifier("IOrdineDbRepository")
    private final ordini.repository.IOrdineDbRepository ordineDbRepository;

    public OrdineServiceImpl(ordini.repository.IOrdineDbRepository ordineDbRepository) {
        this.ordineDbRepository = ordineDbRepository;
    }

    @Override
    public Ordine getOrdineById(Integer inventarioId) {
        Ordine res = new Ordine();
        try {
             res = ordineDbRepository.getReferenceById(inventarioId);
        } catch (Exception e) {
            // log.error("Errore nel ottenere l'inventario con id: {}.\nError message: {}", inventarioId, e.getMessage());
        }
        return res;
    }

    @Override
    public void deleteOrdineById(Integer inventarioId) {
        try {
            ordineDbRepository.getReferenceById(inventarioId);
        } catch (Exception e) {
            // log.error("Errore nel ottenere l'inventario con id: {}.\nError message: {}", inventarioId,  e.getMessage());
        }
    }

    @Override
    public Ordine updateOrdineById(Ordine inventario) {
        Ordine res = new Ordine();

        try {
            res = ordineDbRepository.save(inventario);
        }  catch (Exception e) {
            // log.error("Errore nel ottenere l'inventario con id: {}.\nError message: {}", inventario.getOrdineId(),  e.getMessage());
        }
        return res;
    }
}
