package inventario.model;

import jakarta.persistence.*;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Entity
@Table(name = "INVENTORY")
@Getter
@Setter
public class Inventario extends RepresentationModel<Inventario> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer inventarioId;
    private String nomeInventario;
    private Integer idProdotto;
    private Integer quantita;

}
