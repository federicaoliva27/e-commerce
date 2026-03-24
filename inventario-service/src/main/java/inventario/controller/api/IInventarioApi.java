package inventario.controller.api;

import inventario.model.dto.InventarioDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IInventarioApi {

    @GetMapping("/{inventarioId}")
    ResponseEntity<InventarioDto> getInventarioById(@Valid @PathVariable Integer inventarioId);

    @DeleteMapping("/{inventarioId}")
    ResponseEntity<Void> deleteInventarioById(@Valid @PathVariable Integer inventarioId);

    @PatchMapping("/{inventarioId}")
    ResponseEntity<InventarioDto> updateInventarioById(
            @Valid @RequestBody InventarioDto inventarioDto
    );

}
