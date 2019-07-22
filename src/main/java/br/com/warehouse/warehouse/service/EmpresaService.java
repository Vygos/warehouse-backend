package br.com.warehouse.warehouse.service;

import br.com.warehouse.warehouse.model.entity.Empresa;
import br.com.warehouse.warehouse.model.entity.Responsavel;
import br.com.warehouse.warehouse.repository.EmpresaRepository;
import br.com.warehouse.warehouse.repository.ResponsavelReposity;
import br.com.warehouse.warehouse.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private ResponsavelReposity responsavelReposity;

    public Empresa salvarEmpresa(Empresa empresa) {
        Empresa empresaSalva = empresaRepository.save(empresa);
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<Responsavel> responsavel = responsavelReposity.obterResponsavelLogado(username);
        responsavel.ifPresent( r -> {
            responsavel.get().setEmpresa(empresaSalva);
            responsavelReposity.saveAndFlush(responsavel.get());
        });
        return empresaSalva;
    }

    public List<Empresa> consultarEmpresas() {
        return empresaRepository.findAll();
    }
}
