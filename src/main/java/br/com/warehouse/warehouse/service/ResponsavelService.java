package br.com.warehouse.warehouse.service;

import br.com.warehouse.warehouse.exceptionhandler.exceptions.ResponsavelNotFoundException;
import br.com.warehouse.warehouse.model.entity.Responsavel;
import br.com.warehouse.warehouse.model.vo.ResponsavelVO;
import br.com.warehouse.warehouse.repository.ResponsavelReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
