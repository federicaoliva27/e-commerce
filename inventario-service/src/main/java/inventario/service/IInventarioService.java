package inventario.service;

import inventario.model.Inventario;
import org.springframework.stereotype.Component;

@Component
public interface IInventarioService {
    Inventario getInventarioById(Integer inventarioId);
    void deleteInventarioById(Integer inventarioId);
    Inventario updateInventarioById(Inventario inventario);
}
