package inventario.repository;

import inventario.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInventarioDbRepository extends JpaRepository<Inventario, Integer> {
//    Inventario getInventarioById(Integer id);
//    void deleteInventarioById(Integer id);
//    Inventario updateInventarioById(Inventario inventario);
}
