package br.com.etechoracio.pw3viagem.Entity;

import br.com.etechoracio.pw3viagem.Enum.CategoriaEnum;

import jakarta.persistence.*;

import lombok.Getter;

import lombok.Setter;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@Table(name = "TBL_GASTO")
public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_GASTO")
    private long id;

    @Column(name = "TX_DESCRICAO")
    private String descricao;

    @Column(name = "TX_LOCAL")
    private String local;

    @Enumerated (EnumType.STRING)
    @Column(name = "TP_CATEGORIA")
    private CategoriaEnum tipoCategoria;

    @Column(name = "DT_GASTO")
    private LocalDate dataGasto;

    @Column(name = "VLR_GASTO")
    private double valorGasto;

    @ManyToOne
    @JoinColumn(name = "ID_VIAGEM")
    private Viagem viagem;


}