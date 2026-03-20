package inventario.model.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventarioDto {

    private Integer inventarioId;
    private Integer idProdotto;
    private Integer quantita;

}
