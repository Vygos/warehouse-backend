package br.com.warehouse.warehouse.controller;

import br.com.warehouse.warehouse.model.entity.Responsavel;
import br.com.warehouse.warehouse.service.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/responsavel")
public class ResponsavelController {

    @Autowired
    private ResponsavelService responsavelService;

    @PostMapping
    public ResponseEntity<Responsavel> salvarResponsavel(@Valid @RequestBody Responsavel responsavel){
        return new ResponseEntity<>(responsavelService.salvarResponsavel(responsavel), HttpStatus.OK);
    }
}
