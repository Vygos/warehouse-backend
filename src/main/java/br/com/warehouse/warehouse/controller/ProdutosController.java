package br.com.warehouse.warehouse.controller;

import br.com.warehouse.warehouse.model.entity.Produto;
import br.com.warehouse.warehouse.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProdutosController {

    @Autowired
    private ProdutosService produtosService;

    @PostMapping
    @RequestMapping("company/consultar")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<Page<Produto>> listarProdutos(Map<String, Object> filtros, Pageable pageable){
        return new ResponseEntity<>(produtosService.listarProdutos(filtros, pageable), HttpStatus.OK);
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

    @GetMapping
    @RequestMapping("buscar-nome/{nome}")
    public ResponseEntity buscarProdutoPorNome(@PathVariable("nome") String noProduto){
        return ResponseEntity.ok(produtosService.buscarPorNome(noProduto));
    }
}
