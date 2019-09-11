package br.com.warehouse.warehouse.repository;

import br.com.warehouse.warehouse.model.entity.Produto;
import br.com.warehouse.warehouse.model.entity.Responsavel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query("select p from Produto p join p.empresa e where e.idEmpresa = :idEmpresa")
    List<Produto> listarProdutosPorIdEmpresa(@Param("idEmpresa") Integer idEmpresa);

    @Query("select p from Produto p join p.empresa e where e.idEmpresa = :idEmpresa")
    Page<Produto> produtosPaginado(@Param("idEmpresa") Integer idEmpresa, Pageable pageable);

    @Query("select p from Produto p join p.empresa e where e.idEmpresa = :idEmpresa and p.noProduto like :noProduto")
    Page<Produto> produtosPaginado(@Param("idEmpresa") Integer idEmpresa,String noProduto, Pageable pageable);

    List<Produto> findByNoProdutoIsLike(String nome);
}
