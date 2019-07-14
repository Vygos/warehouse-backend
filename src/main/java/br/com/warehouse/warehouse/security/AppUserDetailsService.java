package br.com.warehouse.warehouse.security;

import br.com.warehouse.warehouse.model.entity.Usuario;
import br.com.warehouse.warehouse.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Usuario> usuario = usuarioRepository.findByEmail(username);
        usuario.orElseThrow(()-> new UsernameNotFoundException("Usuario não encontrado"));
        System.out.println(usuario.get().getEmail());
        
        return new User(username, usuario.get().getSecret(), getPermissoes(usuario.get()));
    }

    private Collection<? extends GrantedAuthority> getPermissoes(Usuario usuario) {
        Set<GrantedAuthority> autorities = new LinkedHashSet<>();
        if(!usuario.getPermissaoUsuario().isEmpty()){
            usuario.getPermissaoUsuario().forEach(p -> autorities.add(new SimpleGrantedAuthority(p.getDsPermissao().toUpperCase())));
            return autorities;
        }
        return autorities;
    }
}
