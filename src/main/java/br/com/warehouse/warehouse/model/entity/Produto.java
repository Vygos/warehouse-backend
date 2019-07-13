package br.com.warehouse.warehouse.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduto;

    @NotNull
    @Column(name = "no_produto")
    private String noProduto;

    @NotNull
    @Column(name = "codigo_produto")
    private String codigoProduto;

    @NotNull
    @OneToOne
    @JoinColumn(name = "id_setor")
    private Setor setor;

    @ManyToOne(fetch = FetchType.LAZY)
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
}
