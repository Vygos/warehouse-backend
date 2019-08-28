package br.com.warehouse.warehouse.repository;

import br.com.warehouse.warehouse.model.entity.Responsavel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ResponsavelReposity extends JpaRepository<Responsavel, Integer> {

    @Query("select r from Responsavel r join r.usuario u where u.email = :email")
    Optional<Responsavel> obterResponsavelLogado(@Param("email") String email);

    @Query("select r from Responsavel r join r.empresa e where e.idEmpresa = :idEmpresa ")
    Optional<List<Responsavel>> recuperarResponsavelVinculadosEmpresa(@Param("idEmpresa") Integer idEmpresa);

    @Query("select r from Responsavel r join r.empresa e where e.idEmpresa = :idEmpresa")
    Page<Responsavel> consultarResponsavelPaginado(@Param("idEmpresa") Integer idEmpresa, Pageable pageable);

    @Query("select r from Responsavel r join r.empresa e where e.idEmpresa = :idEmpresa and r.noResponsavel like :nome")
    Page<Responsavel> consultarResponsavelPaginado(@Param("idEmpresa") Integer idEmpresa, String nome, Pageable pageable);

}
