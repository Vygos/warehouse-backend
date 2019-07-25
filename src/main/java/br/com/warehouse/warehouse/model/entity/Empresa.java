package br.com.warehouse.warehouse.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Integer idEmpresa;

    @NotNull
    @Column(name = "no_razao_social")
    private String noRazaoSocial;

    @NotNull
    @Column(name = "sigla_empresa")
    private String siglaEmpresa;

    @NotNull
    @Column(name = "nr_cnpj_empresa")
    private String nrCnpjEmpresa;

    @NotNull
    @Column(name = "telefone_empresa")
    private String telefoneEmpresa;

    @Column(name = "email_empresa")
    private String emailEmpresa;

    @NotNull
    @Column(name = "data_fundacao_empresa")
    private LocalDate dataFundacaoEmpresa;

    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
    private List<Produto> produto;

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNoRazaoSocial() {
        return noRazaoSocial;
    }

    public void setNoRazaoSocial(String noRazaoSocial) {
        this.noRazaoSocial = noRazaoSocial;
    }

    public String getSiglaEmpresa() {
        return siglaEmpresa;
    }

    public void setSiglaEmpresa(String siglaEmpresa) {
        this.siglaEmpresa = siglaEmpresa;
    }

    public String getNrCnpjEmpresa() {
        return nrCnpjEmpresa;
    }

    public void setNrCnpjEmpresa(String nrCnpjEmpresa) {
        this.nrCnpjEmpresa = nrCnpjEmpresa;
    }

    public String getTelefoneEmpresa() {
        return telefoneEmpresa;
    }

    public void setTelefoneEmpresa(String telefonEmpresa) {
        this.telefoneEmpresa = telefonEmpresa;
    }

    public String getEmailEmpresa() {
        return emailEmpresa;
    }

    public void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

    public LocalDate getDataFundacaoEmpresa() {
        return dataFundacaoEmpresa;
    }

    public void setDataFundacaoEmpresa(LocalDate dataFundacaoEmpresa) {
        this.dataFundacaoEmpresa = dataFundacaoEmpresa;
    }
}
