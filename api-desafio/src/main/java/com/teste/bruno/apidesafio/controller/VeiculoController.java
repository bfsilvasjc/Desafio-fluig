package com.teste.bruno.apidesafio.controller;

import com.teste.bruno.apidesafio.model.VeiculoModel;
import com.teste.bruno.apidesafio.model.VeiculoResponseModel;
import com.teste.bruno.apidesafio.repository.VeiculoRepository;
import com.teste.bruno.apidesafio.service.CalcularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VeiculoController {

    @Autowired
    private VeiculoRepository repository;

    @Autowired
    private CalcularService service;

    @GetMapping(path = "/api/veiculo/{codigo}")
    public ResponseEntity consultar(@PathVariable("codigo") Integer codigo){
        return repository.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/api/cadastrar")
    public VeiculoModel cadastrarVeiculo(@RequestBody VeiculoModel veiculo) {
        return repository.save(veiculo);
    }

    @GetMapping(path = "/api/calcular", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VeiculoResponseModel> calcular(@RequestParam("preco") Double preco, @RequestParam("kmCidade") Double kmCidade,
                                               @RequestParam("kmRodovia") Double kmRodovia){

        return service.calcularPrevisaoGastos(preco, kmCidade, kmRodovia);
    }
}
