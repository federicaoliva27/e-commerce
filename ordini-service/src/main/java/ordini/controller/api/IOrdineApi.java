package ordini.controller.api;


import jakarta.validation.Valid;
import ordini.model.dto.OrdineDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IOrdineApi {

    @GetMapping("/{ordineId}")
    ResponseEntity<OrdineDto> getOrdineById(@Valid @PathVariable Integer ordineId);

    @DeleteMapping("/{ordineId}")
    ResponseEntity<Void> deleteOrdineById(@Valid @PathVariable Integer ordineId);

    @PatchMapping("/{ordineId}")
    ResponseEntity<OrdineDto> updateOrdineById(
            @Valid @PathVariable Integer ordineId,
            @Valid @RequestBody OrdineDto ordineDto
    );

}
