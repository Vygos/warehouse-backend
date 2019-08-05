package br.com.warehouse.warehouse.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "produto")
@JsonIgnoreProperties("empresa")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduto;

    @NotNull
    @Column(name = "no_produto")
    private String noProduto;

    @NotNull
    @Column(name = "fabricante")
    private String fabricante;
    
    @NotNull
    @Column(name = "qtde_produto")
    private Integer qtdeProduto;

    @NotNull
    @Size(max = 5)
    @Column(name = "codigo_produto")
    private String codigoProduto;

    @NotNull
    @OneToOne
    @JoinColumn(name = "id_setor")
    private Setor setor;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNoProduto() {
        return noProduto;
    }

    public void setNoProduto(String noProduto) {
        this.noProduto = noProduto;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Integer getQtdeProduto() {
        return qtdeProduto;
    }

    public void setQtdeProduto(Integer qtdeProduto) {
        this.qtdeProduto = qtdeProduto;
    }
    
    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
