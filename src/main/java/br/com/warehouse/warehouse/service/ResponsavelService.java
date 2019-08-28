package br.com.warehouse.warehouse.service;

import br.com.warehouse.warehouse.exceptionhandler.exceptions.ResponsavelNotFoundException;
import br.com.warehouse.warehouse.model.entity.Responsavel;
import br.com.warehouse.warehouse.model.vo.ResponsavelVO;
import br.com.warehouse.warehouse.repository.ResponsavelReposity;
import static br.com.warehouse.warehouse.util.WarehouseUtil.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResponsavelService {

    @Autowired
    private ResponsavelReposity responsavelReposity;

    @Autowired
    private UsuarioService usuarioService;

    public Responsavel salvarResponsavel(Responsavel responsavel){
        usuarioService.encodarUsuario(responsavel.getUsuario());
        return responsavelReposity.save(responsavel);
    }

    public Page<ResponsavelVO> consultar(Map<String, Object> filtros, Pageable pageable){
        String userName = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer idEmpresa = recuperarResponsavelPorEmail(userName).getEmpresa().getIdEmpresa();

        return criarConsultaPaginada(idEmpresa, filtros, pageable);
    }

    private Page<ResponsavelVO> criarConsultaPaginada(Integer idEmpresa, Map<String, Object> filtros, Pageable pageable){
        List<ResponsavelVO> responsavelVOS = new ArrayList<>();
        if(!StringUtils.isEmpty(filtros.get("noResponsavel"))){
            String noResponsavel = (String) filtros.get("noResponsavel");
            Page<Responsavel> listaPaginada = responsavelReposity.consultarResponsavelPaginado(idEmpresa, PORCENTO + noResponsavel + PORCENTO, pageable);
            listaPaginada.forEach(r -> responsavelVOS.add(montarResponsavel(r)));
            return new PageImpl<>(responsavelVOS, pageable, listaPaginada.getTotalElements());
        }
        Page<Responsavel> listaPaginada = responsavelReposity.consultarResponsavelPaginado(idEmpresa, pageable);
        listaPaginada.forEach(r -> responsavelVOS.add(montarResponsavel(r)));
        return new PageImpl<>(responsavelVOS, pageable, listaPaginada.getTotalElements());
    }

    public void atualizarResponsavel(Responsavel responsavel){
         responsavelReposity.save(responsavel);
    }

    public Responsavel recuperarResponsavelPorEmail(String email){
        Optional<Responsavel> responsavel = responsavelReposity.obterResponsavelLogado(email);
        return responsavel.orElse(null);
    }

    public List<ResponsavelVO> recuperarResponsavelVinculadosEmpresa() {
        String userName = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer idEmpresa = recuperarResponsavelPorEmail(userName).getEmpresa().getIdEmpresa();

        Optional<List<Responsavel>> listaResponsavel = responsavelReposity.recuperarResponsavelVinculadosEmpresa(idEmpresa);
        List<ResponsavelVO> responsavelVOS = new ArrayList<>();
        listaResponsavel.ifPresent(i -> listaResponsavel.get().forEach(responsavel -> responsavelVOS.add(montarResponsavel(responsavel))));
        return responsavelVOS;
    }

    public Responsavel buscarResponsavelPorId(Integer id) {
        return responsavelReposity.findById(id).orElseThrow(ResponsavelNotFoundException::new);
    }

    public List<ResponsavelVO> recuperarResponsavelPorNome(String noResponsavel) {
        List<ResponsavelVO> listaResponsavel = recuperarResponsavelVinculadosEmpresa();
        List<ResponsavelVO> listaResponsavelBusca =
                listaResponsavel
                    .stream()
                    .filter(p -> p.getNoResponsavel().toLowerCase().contains(noResponsavel.toLowerCase()))
                    .collect(Collectors.toList());

        return listaResponsavelBusca;
    }

    public ResponsavelVO montarResponsavel(Responsavel responsavel){
        return new ResponsavelVO
                .ResponsavelVOBuilder()
                .setIdResponsavel(responsavel.getIdResponsavel())
                .setNoResponsavel(responsavel.getNoResponsavel())
                .setEmail(responsavel.getNoResponsavel())
                .setDataNascimento(responsavel.getDataNascimentoResponsavel())
                .build();
    }
}
