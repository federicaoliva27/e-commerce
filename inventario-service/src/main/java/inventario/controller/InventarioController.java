package inventario.controller;

import inventario.controller.api.IInventarioApi;
import inventario.model.dto.InventarioDto;
import inventario.repository.mapper.IInventarioMapper;
import inventario.service.IInventarioService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/inventario")
public class InventarioController implements IInventarioApi {

    private final IInventarioService inventarioService;
    private final IInventarioMapper inventarioMapper;

    public InventarioController(IInventarioService inventarioService, IInventarioMapper inventarioMapper)
    {
        this.inventarioService = inventarioService;
        this.inventarioMapper = inventarioMapper;
    }

    @Override
    public ResponseEntity<InventarioDto> getInventarioById(@PathVariable Integer inventarioId) {
      //  log.info("Metodo Richiamato InventarioController.getInventarioById(), with inventarioId = {}", inventarioId);
        InventarioDto inventarioDto = inventarioMapper.toInventarioDto(inventarioService.getInventarioById(inventarioId)); // Conversion to DTO
        return new ResponseEntity<>(inventarioDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteInventarioById(@PathVariable Integer inventarioId) {
       //log.info("Metodo richiamato InventarioController.deleteInventarioById(), with inventarioId = {}", inventarioId);
        inventarioService.deleteInventarioById(inventarioId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<InventarioDto> updateInventarioById(@Valid @RequestBody InventarioDto inventarioDto) {
      //  log.info("Metodo richiamato inventarioController.updateInventarioById(), with inventarioId = {}", inventarioDto.getInventarioId());

        InventarioDto newInventario = inventarioMapper.toInventarioDto(
                inventarioService.updateInventarioById(
                        inventarioMapper.toInventario(inventarioDto)
                )
        ); // inline converison from Dto to Entity and again to Dto
        return new ResponseEntity<>(newInventario, HttpStatus.OK);
    }
}
