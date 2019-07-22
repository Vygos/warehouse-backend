package br.com.warehouse.warehouse.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "permissao")
@JsonIgnoreProperties({"usuario"})
public class Permissao {

    @Id
    @Column(name = "id_permissao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPermissao;

    @NotNull
    @Column(name = "ds_permissao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String dsPermissao;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usuario_permissao",
            joinColumns = {@JoinColumn(name = "id_permissao")},
            inverseJoinColumns = {@JoinColumn(name = "id_usuario")}
    )
    private List<Usuario> usuario;

    public Integer getIdPermissao() {
        return idPermissao;
    }

    public void setIdPermissao(Integer idPermissao) {
        this.idPermissao = idPermissao;
    }

    public String getDsPermissao() {
        return dsPermissao;
    }

    public void setDsPermissao(String dsPermissao) {
        this.dsPermissao = dsPermissao;
    }

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }
}

