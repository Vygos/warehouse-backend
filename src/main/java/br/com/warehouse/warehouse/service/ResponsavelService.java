package br.com.warehouse.warehouse.service;

import br.com.warehouse.warehouse.model.entity.Responsavel;
import br.com.warehouse.warehouse.repository.ResponsavelReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ResponsavelService {

    @Autowired
    private ResponsavelReposity responsavelReposity;

    @Autowired
    private UsuarioService usuarioService;
    public Responsavel salvarResponsavel(Responsavel responsavel){
        responsavel.setDataNascimentoResponsavel(LocalDate.of(1990,1,1));
        usuarioService.salvarUsuario(responsavel.getUsuario());
        return responsavelReposity.save(responsavel);
    }
}
