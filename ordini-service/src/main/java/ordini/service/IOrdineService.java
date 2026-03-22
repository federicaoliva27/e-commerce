package ordini.service;


import ordini.model.Ordine;
import org.springframework.stereotype.Component;

@Component
public interface IOrdineService {
    Ordine getOrdineById(Integer ordineId);
    void deleteOrdineById(Integer ordineId);
    Ordine updateOrdineById(Ordine ordine);
}
