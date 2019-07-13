package br.com.warehouse.warehouse.repository;

import br.com.warehouse.warehouse.model.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {
}
