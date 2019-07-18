package br.com.warehouse.warehouse.controller;

import br.com.warehouse.warehouse.model.entity.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {


    @PostMapping
    public ResponseEntity salvarUsuario(@Valid @RequestBody Usuario usuario){
        Usuario usuario1 = usuario;
        return ResponseEntity.ok("");
    }
}
