package br.com.warehouse.warehouse.controller;

import br.com.warehouse.warehouse.model.entity.Setor;
import br.com.warehouse.warehouse.service.SetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/setor")
public class SetorController {

    @Autowired
    private SetorService setorService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Setor>> retornarSetores(){
        return new ResponseEntity<>(setorService.retornarSetores(), HttpStatus.OK);
    }
}
