package br.com.warehouse.warehouse.controller;

import br.com.warehouse.warehouse.model.entity.Usuario;
import br.com.warehouse.warehouse.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity salvarUsuario(@Valid @RequestBody Usuario usuario){
        System.out.println(usuario);
        return ResponseEntity.ok(usuarioService.salvarUsuario(usuario));
    }
}
