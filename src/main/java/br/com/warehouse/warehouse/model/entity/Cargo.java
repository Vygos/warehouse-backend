package br.com.warehouse.warehouse.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cargo")
public class Cargo {

    @Id
    @Column(name = "id_cargo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCargo;

    @NotNull
    @Column(name = "ds_cargo")
    private String dsCargo;

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getDsCargo() {
        return dsCargo;
    }

    public void setDsCargo(String dsCargo) {
        this.dsCargo = dsCargo;
    }
}
