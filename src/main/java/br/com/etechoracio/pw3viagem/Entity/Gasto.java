package br.com.etechoracio.pw3viagem.Entity;

import br.com.etechoracio.pw3viagem.Enum.CategoriaEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

//Vinicius Mateos
@Getter
@Setter
@Entity
@Table(name = "TBL_GASTO")
public class Gasto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID_GASTO")
    private Long id;

    @Column(name = "TX_DESCRICAO")
    private String descricao;

    @Column(name = "TX_LOCAL")
    private String local;

    @Column(name = "TP_CATEGORIA")
    @Enumerated(EnumType.STRING)
    private CategoriaEnum categoria;

    @Column(name = "DT_GASTO")
    private LocalDate dataGasto;

    @Column(name = "VLR_GASTO")
    private double valorGasto;

    @JoinColumn(name = "ID_VIAGEM")
    @ManyToOne
    private Viagem viagem;
}
