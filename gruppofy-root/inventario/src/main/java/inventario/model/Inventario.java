package inventario.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "INVENTORY")
@Getter
@Setter

@Builder
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idProdotto;
    private Integer quantita;

}
