package inventario.repository;

import inventario.model.Inventario;
import inventario.model.dto.InventarioDto;

public interface IInventarioDbRepository {
    Inventario findInventarioById(Integer id);
    void deleteInventarioById(Integer id);
    Inventario saveInventario(Inventario Inventario);
}
