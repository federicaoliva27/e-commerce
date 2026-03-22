package inventario.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventarioDto {

    @NotNull
    private Integer inventarioId;;
    private String nomeInventario;
    private List<Integer> prodottiId;
    private Integer quantita;

}
