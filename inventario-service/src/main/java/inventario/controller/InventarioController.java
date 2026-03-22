package inventario.controller;

import inventario.controller.api.IInventarioApi;


import inventario.model.dto.InventarioDto;
import inventario.repository.mapper.IInventarioMapper;
import inventario.service.IInventarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/inventario")
public class InventarioController implements IInventarioApi {

    private IInventarioService inventarioService;
    private IInventarioMapper inventarioMapper;

    public InventarioController(@Qualifier("IInventarioService") IInventarioService inventarioService, IInventarioMapper inventarioMapper)
    {
        this.inventarioService = inventarioService;
        this.inventarioMapper = inventarioMapper;
    }

    @Override
    public ResponseEntity<InventarioDto> getInventarioById(Integer inventarioId) {
        log.info("Metodo Richiamato InventarioController.getInventarioById(), with inventarioId = {}", inventarioId);
        InventarioDto inventarioDto = inventarioMapper.INSTANCE.toInventarioDto(inventarioService.getInventarioById(inventarioId)); // Conversion to DTO
        return new ResponseEntity<>(inventarioDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteInventarioById(Integer inventarioId) {
        log.info("Metodo richiamato InventarioController.deleteInventarioById(), with inventarioId = {}", inventarioId);
        inventarioService.deleteInventarioById(inventarioId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<InventarioDto> updateInventarioById(InventarioDto inventarioDto) {
        log.info("Metodo richiamato inventarioController.updateInventarioById(), with inventarioId = {}", inventarioDto.getInventarioId());
        InventarioDto newInventario = inventarioMapper.INSTANCE.toInventarioDto(
                inventarioService.updateInventarioById(
                        inventarioMapper.INSTANCE.toInventario(inventarioDto)
                )
        ); // inline converison from Dto to Entity and again to Dto
        return new ResponseEntity<>(newInventario, HttpStatus.OK);
    }
}
