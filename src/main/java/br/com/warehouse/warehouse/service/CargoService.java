package br.com.warehouse.warehouse.service;

import br.com.warehouse.warehouse.model.entity.Cargo;
import br.com.warehouse.warehouse.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    public List<Cargo> retornarCargos(){
        return cargoRepository.findAll();
    }
}
