package br.com.warehouse.warehouse.repository;

import br.com.warehouse.warehouse.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
