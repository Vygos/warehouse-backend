package br.com.warehouse.warehouse.service;

import br.com.warehouse.warehouse.model.entity.Usuario;
import br.com.warehouse.warehouse.repository.ResponsavelReposity;
import br.com.warehouse.warehouse.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ResponsavelReposity responsavelReposity;

    public void salvarUsuario(Usuario usuario){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        usuario.setSecret(bCryptPasswordEncoder.encode(usuario.getSecret()));
    }

}
