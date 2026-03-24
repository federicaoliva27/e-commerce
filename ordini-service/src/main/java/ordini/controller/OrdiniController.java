package ordini.controller;


import lombok.extern.slf4j.Slf4j;
import ordini.controller.api.IOrdineApi;
import ordini.model.dto.OrdineDto;
import ordini.repository.mapper.IOrdineMapper;
import ordini.service.IOrdineService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/ordini")
public class OrdiniController implements IOrdineApi {

    private final IOrdineService ordineService;
    private final IOrdineMapper ordineMapper;


    public OrdiniController(IOrdineService ordineService, IOrdineMapper ordineMapper)
    {
        this.ordineService = ordineService ;
        this.ordineMapper = ordineMapper;
    }

    @Override
    public ResponseEntity<OrdineDto> getOrdineById(@PathVariable Integer ordineId) {
        // log.info("Metodo Richiamato InventarioController.getInventarioById(), with inventarioId = {}", inventarioId);

        OrdineDto ordineDto = ordineMapper.toOrdineDto(ordineService.getOrdineById(ordineId)); // Conversion to DTO
        return new ResponseEntity<>(ordineDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteOrdineById(@PathVariable Integer ordineId) {
        // log.info("Metodo richiamato InventarioController.deleteInventarioById(), with inventarioId = {}", inventarioId);
        ordineService.deleteOrdineById(ordineId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrdineDto> updateOrdineById(
            @PathVariable Integer ordineId,
            @Valid @RequestBody OrdineDto ordineDto
    ) {
        // log.info("Metodo richiamato inventarioController.updateInventarioById(), with inventarioId = {}", ordineDto.getInventarioId());

        OrdineDto newOrdine = ordineMapper.toOrdineDto(ordineService.updateOrdineById(ordineMapper.toOrdine(ordineDto))); // inline converison from Dto to Entity and again to Dto
        return new ResponseEntity<>(newOrdine, HttpStatus.OK);
    }
}
