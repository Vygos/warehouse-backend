package br.com.warehouse.warehouse.controller;

import br.com.warehouse.warehouse.model.entity.Empresa;
import br.com.warehouse.warehouse.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public List<Empresa> consultar(){
        return empresaService.consultarEmpresas();
    }

    @PostMapping
    public ResponseEntity salvarEmpresa(@Valid @RequestBody Empresa empresa){
        return ResponseEntity.ok(empresaService.salvarEmpresa(empresa));
    }
}
