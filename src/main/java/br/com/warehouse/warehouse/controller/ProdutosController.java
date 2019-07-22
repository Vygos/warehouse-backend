package br.com.warehouse.warehouse.controller;

import br.com.warehouse.warehouse.model.entity.Produto;
import br.com.warehouse.warehouse.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProdutosController {

    @Autowired
    private ProdutosService produtosService;

    @PostMapping
    public ResponseEntity<List<Produto>> salvarProdutos(@Valid @RequestBody List<Produto> produtos){
        return ResponseEntity.ok(produtosService.salvarProdutos(produtos));
    }
}
