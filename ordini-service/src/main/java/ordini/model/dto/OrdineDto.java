package ordini.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdineDto {

    @NotNull
    private Integer ordineId;
    private List<Integer> prodottoId;

}
