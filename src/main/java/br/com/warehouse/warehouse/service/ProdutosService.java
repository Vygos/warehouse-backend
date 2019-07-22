package br.com.warehouse.warehouse.service;

import br.com.warehouse.warehouse.model.entity.Produto;
import br.com.warehouse.warehouse.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> salvarProdutos(List<Produto> produtos){
        return salvarProdutos(produtos);
    }
}
