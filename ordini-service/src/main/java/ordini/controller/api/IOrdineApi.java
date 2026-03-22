package ordini.controller.api;


import jakarta.validation.Valid;
import ordini.model.dto.OrdineDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/default")
public interface IOrdineApi {

    @GetMapping("/{ordineId}")
    public ResponseEntity<OrdineDto> getOrdineById(Integer ordineId);

    @DeleteMapping("/{ordineId}")
    ResponseEntity<Void> deleteOrdineById(@Valid @PathVariable Integer ordineId);

    @PatchMapping("/{ordineId}")
    ResponseEntity<OrdineDto> updateOrdineById(@Valid @RequestBody OrdineDto ordineDto);

}
