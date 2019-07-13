package br.com.warehouse.warehouse.repository;

import br.com.warehouse.warehouse.model.entity.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissaoRepository extends JpaRepository<Permissao, Integer> {
}
