package br.com.warehouse.warehouse.repository;

import br.com.warehouse.warehouse.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
