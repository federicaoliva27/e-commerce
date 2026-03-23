package ordini.repository;


import ordini.model.Ordine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IOrdineDbRepository extends JpaRepository<Ordine, Integer> {
    // Ordine getInventarioById(Integer ordineId);
    // void deleteInventarioById(Integer ordineId);
    // Ordine updateInventarioById(Ordine ordine);
}
