package br.com.warehouse.warehouse.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "setor")
public class Setor {

    @Id
    @Column(name = "id_setor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSetor;

    @NotNull
    @Column(name = "dsSetor")
    private String dsSetor;

    public Integer getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(Integer idSetor) {
        this.idSetor = idSetor;
    }

    public String getDsSetor() {
        return dsSetor;
    }

    public void setDsSetor(String dsSetor) {
        this.dsSetor = dsSetor;
    }
}
