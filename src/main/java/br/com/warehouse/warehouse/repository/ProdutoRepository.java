package br.com.warehouse.warehouse.repository;

import br.com.warehouse.warehouse.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query("select p from Produto p join p.empresa e where e.idEmpresa = :idEmpresa")
    List<Produto> listarProdutosPorIdEmpresa(@Param("idEmpresa") Integer idEmpresa);
}
