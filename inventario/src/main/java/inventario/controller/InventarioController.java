package inventario.controller;

import inventario.controller.api.IInventarioApi;
import inventario.model.Inventario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/inventario")
public class InventarioController implements IInventarioApi {
    @Override
    public ResponseEntity<Inventario> getInventarioById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteInventarioById(Integer inventarioId) {
        return null;
    }
}
