package br.com.warehouse.warehouse.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table
@Entity
public class Usuario {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @NotNull
    @Column(name = "email", unique = true)
    private String email;

    @NotNull
    @Column(name = "secret")
    private String secret;

    @ManyToMany
    @JoinTable(name = "usuario_permissao",
            joinColumns = {@JoinColumn(name = "id_usuario")},
            inverseJoinColumns = { @JoinColumn(name="id_permissao")})
    private List<Permissao> permissaoUsuario;

    @OneToOne(mappedBy = "usuario")
    private Responsavel responsavel;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public List<Permissao> getPermissaoUsuario() {
        return permissaoUsuario;
    }

    public void setPermissaoUsuario(List<Permissao> permissaoUsuario) {
        this.permissaoUsuario = permissaoUsuario;
    }
}
