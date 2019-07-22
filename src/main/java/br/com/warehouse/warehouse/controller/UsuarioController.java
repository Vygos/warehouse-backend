package br.com.warehouse.warehouse.controller;

import br.com.warehouse.warehouse.model.entity.Usuario;
import br.com.warehouse.warehouse.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity salvarUsuario(@Valid @RequestBody Usuario usuario){
        System.out.println(usuario);
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok("");
    }
}
