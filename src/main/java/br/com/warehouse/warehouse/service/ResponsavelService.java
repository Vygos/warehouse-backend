package br.com.warehouse.warehouse.service;

import br.com.warehouse.warehouse.model.entity.Responsavel;
import br.com.warehouse.warehouse.repository.ResponsavelReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Responsavel> recuperarResponsavelVinculadosEmpresa() {
        String userName = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer idEmpresa = recuperarResponsavelPorEmail(userName).getEmpresa().getIdEmpresa();
        Optional<List<Responsavel>> responsavel = responsavelReposity.recuperarResponsavelVinculadosEmpresa(idEmpresa);
        return responsavel.orElse(null);
    }

    public Responsavel buscarResponsavelPorId(Integer id) {
        return responsavelReposity.findById(id).orElse(null);
    }
}
