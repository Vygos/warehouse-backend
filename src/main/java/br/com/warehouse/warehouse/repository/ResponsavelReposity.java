package br.com.warehouse.warehouse.repository;

import br.com.warehouse.warehouse.model.entity.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ResponsavelReposity extends JpaRepository<Responsavel, Integer> {

    @Query("select r from Responsavel r join r.usuario u where u.email = :email")
    Optional<Responsavel> obterResponsavelLogado(@Param("email") String email);
}
