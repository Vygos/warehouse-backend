package br.com.warehouse.warehouse.controller;

import br.com.warehouse.warehouse.model.entity.Empresa;
import br.com.warehouse.warehouse.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping
    private List<Empresa> consultar(){
        return empresaRepository.findAll();
    }
}
