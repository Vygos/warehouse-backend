package br.com.warehouse.warehouse.service;

import br.com.warehouse.warehouse.model.entity.Permissao;
import br.com.warehouse.warehouse.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;


    public List<Permissao> listarPermissao(){
        return permissaoRepository.findAll();
    }
}
