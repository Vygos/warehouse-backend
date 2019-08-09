package br.com.warehouse.warehouse.controller;

import br.com.warehouse.warehouse.model.entity.Produto;
import br.com.warehouse.warehouse.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProdutosController {

    @Autowired
    private ProdutosService produtosService;

    @GetMapping
    @RequestMapping("company/{id}")
    public ResponseEntity<List<Produto>> listarProdutos(@PathVariable("id") Integer id){
        return new ResponseEntity<>(produtosService.listarProdutos(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<Produto>> salvarProdutos(@Valid @RequestBody List<Produto> produtos){
        return ResponseEntity.ok(produtosService.salvarProdutos(produtos));
    }

    @PatchMapping
    public ResponseEntity atualizarProduto(@RequestBody @Valid Produto produto){
        produtosService.atualizarProduto(produto);
        return ResponseEntity.ok("");
    }

    @DeleteMapping
    @RequestMapping("/{id}")
    public ResponseEntity deletarProduto(@PathVariable Integer id){
        produtosService.deletarProduto(id);
        return ResponseEntity.ok("");
    }
}
