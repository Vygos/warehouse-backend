package br.com.warehouse.warehouse.repository;

import br.com.warehouse.warehouse.model.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
}
