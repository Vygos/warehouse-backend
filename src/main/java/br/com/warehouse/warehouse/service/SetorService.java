package br.com.warehouse.warehouse.service;

import br.com.warehouse.warehouse.model.entity.Setor;
import br.com.warehouse.warehouse.repository.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetorService {

    @Autowired
    private SetorRepository setorRepository;

    public List<Setor> retornarSetores(){
        return setorRepository.findAll();
    }
}
