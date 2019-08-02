package br.com.warehouse.warehouse.controller;

import br.com.warehouse.warehouse.model.entity.Permissao;
import br.com.warehouse.warehouse.service.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/permissao")
public class PermissaoController {

    @Autowired
    private PermissaoService permissaoService;

    @GetMapping
    public ResponseEntity<List<Permissao>> listarPermissao(){
        return new ResponseEntity<>(permissaoService.listarPermissao(), HttpStatus.OK);
    }
}
