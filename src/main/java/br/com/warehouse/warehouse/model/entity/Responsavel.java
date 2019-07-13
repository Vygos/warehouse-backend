package br.com.warehouse.warehouse.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "responsavel")
public class Responsavel {

    @Id
    @Column(name = "id_responsavel")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idResponsavel;

    @NotNull
    @Column(name = "no_responsavel")
    private String noResponsavel;

    @NotNull
    @Column(name = "data_nascimento_responsavel")
    private LocalDate dataNascimentoResponsavel;

    @OneToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @OneToOne
    @JoinColumn(name = "id_cargo")
    private Cargo cargo;


    public Integer getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(Integer idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public String getNoResponsavel() {
        return noResponsavel;
    }

    public void setNoResponsavel(String noResponsavel) {
        this.noResponsavel = noResponsavel;
    }

    public LocalDate getDataNascimentoResponsavel() {
        return dataNascimentoResponsavel;
    }

    public void setDataNascimentoResponsavel(LocalDate dataNascimentoResponsavel) {
        this.dataNascimentoResponsavel = dataNascimentoResponsavel;
    }
}
