package br.com.warehouse.warehouse.controller;

import br.com.warehouse.warehouse.model.entity.Responsavel;
import br.com.warehouse.warehouse.service.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/responsavel")
public class ResponsavelController {

    @Autowired
    private ResponsavelService responsavelService;


    @GetMapping
    public ResponseEntity<Responsavel> responsavelLogado(){
        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new ResponseEntity<>(responsavelService.obterResponsavelLogado(principal), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Responsavel> salvarResponsavel(@Valid @RequestBody Responsavel responsavel){
        return new ResponseEntity<>(responsavelService.salvarResponsavel(responsavel), HttpStatus.OK);
    }
}
