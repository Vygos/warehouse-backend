package br.com.warehouse.warehouse.controller;

import br.com.warehouse.warehouse.model.entity.Responsavel;
import br.com.warehouse.warehouse.model.vo.ResponsavelVO;
import br.com.warehouse.warehouse.service.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/responsavel")
public class ResponsavelController {

    @Autowired
    private ResponsavelService responsavelService;



    @PostMapping
    @RequestMapping("consultar")
    public ResponseEntity<Page<ResponsavelVO>> recuperarUsuariosVinculadosEmpresa(@RequestBody Map<String, Object> filtros, Pageable pageable){
        return new ResponseEntity<>(responsavelService.consultar(filtros,pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Responsavel> salvarResponsavel(@Valid @RequestBody Responsavel responsavel){
        return new ResponseEntity<>(responsavelService.salvarResponsavel(responsavel), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity atualizarResponsavel(@RequestBody @Valid Responsavel responsavel){
        responsavelService.atualizarResponsavel(responsavel);
        return ResponseEntity.ok("");
    }

    @GetMapping
    @RequestMapping("/logado")
    public ResponseEntity<Responsavel> responsavelLogado(){
        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new ResponseEntity<>(responsavelService.recuperarResponsavelPorEmail(principal), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity buscarResponsavelPorId(@PathVariable Integer id){
        Responsavel responsavel = responsavelService.buscarResponsavelPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(responsavel);
    }

    @GetMapping
    @RequestMapping("/buscar-nome/{nome}")
    public ResponseEntity buscarResponsavel(@PathVariable("nome") String noResponsavel){
        return ResponseEntity.ok(responsavelService.recuperarResponsavelPorNome(noResponsavel));
    }

}
