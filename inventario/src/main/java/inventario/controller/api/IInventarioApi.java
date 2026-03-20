package inventario.controller.api;

import inventario.model.Inventario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/default")
public interface IInventarioApi {

    @GetMapping("/{inventarioId}")
    ResponseEntity<Inventario> getInventarioById(@PathVariable

                                                 Integer inventarioId);

    @DeleteMapping("/{inventarioId}")
    ResponseEntity<Void> deleteInventarioById(@PathVariable Integer inventarioId);


}
