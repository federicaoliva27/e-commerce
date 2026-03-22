package inventario.service;

import inventario.model.Inventario;
import inventario.repository.IInventarioDbRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class InventarioServiceImpl implements IInventarioService {

    @Qualifier("IInventarioDbRepository")
    private final IInventarioDbRepository inventarioDbRepository;

    @Override
    public Inventario getInventarioById(Integer inventarioId) {
        Inventario res = new Inventario();
        try {
             res = inventarioDbRepository.getReferenceById(inventarioId);
        } catch (Exception e) {
            log.error("Errore nel ottenere l'inventario con id: {}.\nError message: {}", inventarioId, e.getMessage());
        }
        return res;
    }

    @Override
    public void deleteInventarioById(Integer inventarioId) {
        try {
            inventarioDbRepository.getReferenceById(inventarioId);
        } catch (Exception e) {
            log.error("Errore nel ottenere l'inventario con id: {}.\nError message: {}", inventarioId,  e.getMessage());
        }
    }

    @Override
    public Inventario updateInventarioById(Inventario inventario) {
        Inventario res = new Inventario();

        try {
            res = inventarioDbRepository.save(inventario);
        }  catch (Exception e) {
            log.error("Errore nel ottenere l'inventario con id: {}.\nError message: {}", inventario.getInventarioId(),  e.getMessage());
        }
        return res;
    }
}
