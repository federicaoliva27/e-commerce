package inventario.model;

import jakarta.persistence.*;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Entity
@Table(name = "INVENTARIO")
@Getter
@Setter
public class Inventario extends RepresentationModel<Inventario> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INVENTARIO_ID")
    private Integer inventarioId;

    @Column(name = "INVENTARIO_NOME")
    private String nomeInventario;

    @Column(name = "PRODOTTI_ID")
    private Integer prodottoId;

    @Column(name = "QUANTITA")
    private Integer quantita;

}
