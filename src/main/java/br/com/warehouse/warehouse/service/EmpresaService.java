package br.com.warehouse.warehouse.service;

import br.com.warehouse.warehouse.model.entity.Empresa;
import br.com.warehouse.warehouse.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa salvarEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public List<Empresa> consultarEmpresas() {
        return empresaRepository.findAll();
    }
}
