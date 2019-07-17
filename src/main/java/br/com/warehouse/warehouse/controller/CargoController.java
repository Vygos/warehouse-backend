package br.com.warehouse.warehouse.controller;

import br.com.warehouse.warehouse.model.entity.Cargo;
import br.com.warehouse.warehouse.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Cargo>> retornarCargos(){
        return new ResponseEntity<>(cargoService.retornarCargos(), HttpStatus.OK);
    }
}
