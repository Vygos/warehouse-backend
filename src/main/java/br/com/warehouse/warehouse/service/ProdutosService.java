package br.com.warehouse.warehouse.service;

import br.com.warehouse.warehouse.model.entity.Produto;
import br.com.warehouse.warehouse.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.sound.sampled.Port;

import static br.com.warehouse.warehouse.util.WarehouseUtil.PORCENTO;

import java.util.List;
import java.util.Map;

@Service
public class ProdutosService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ResponsavelService responsavelService;

    public List<Produto> salvarProdutos(List<Produto> produtos){
        return produtoRepository.saveAll(produtos);
    }

    public Page<Produto> listarProdutos(Map<String, Object> filtros, Pageable pageable) {
        String userName = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer idEmpresa = responsavelService.recuperarResponsavelPorEmail(userName).getEmpresa().getIdEmpresa();
        filtros.put("empresa", idEmpresa);


        return criarConsultaPaginada(filtros, pageable);
    }

    private Page<Produto> criarConsultaPaginada(Map<String, Object> filtros, Pageable pageable) {
        String noProduto = (String) filtros.get("noProduto");
        if(StringUtils.isEmpty(noProduto)){
            Page<Produto> produtoPage = produtoRepository.produtosPaginado((Integer) filtros.get("empresa"), pageable);
            return produtoPage;
        }

        noProduto = PORCENTO + noProduto + PORCENTO;
        Page<Produto> produtoPage = produtoRepository.produtosPaginado((Integer) filtros.get("empresa"), noProduto, pageable);
        return produtoPage;
    }

    public void atualizarProduto(Produto produto) {
        produtoRepository.save(produto);
    }

    public void deletarProduto(Integer id) {
        produtoRepository.deleteById(id);
    }

    public List<Produto> buscarPorNome(String noProduto) {
        return produtoRepository.findByNoProdutoIsLike(PORCENTO + noProduto + PORCENTO);
    }
}
