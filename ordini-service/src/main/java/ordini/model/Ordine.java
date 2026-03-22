package ordini.model;

import jakarta.persistence.*;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.hateoas.RepresentationModel;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "INVENTARIO")
@Getter
@Setter
public class Ordine extends RepresentationModel<Ordine> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDINE_ID")
    private Integer ordineId;

    @ElementCollection
    @CollectionTable(name = "ORDINE_PRODOTTI", joinColumns = @JoinColumn(name = "ORDINE_ID"))
    @Column(name = "PRODOTTO_ID")
    private List<Integer> prodottoId;

    @CreationTimestamp
    @Column(name = "ORA_CREAZIONE")
    private Timestamp oraCreazione;

    @UpdateTimestamp
    @Column(name = "ULTIMO_UPDATE")
    private Timestamp ultimoUpdate;
}
