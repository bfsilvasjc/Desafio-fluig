package com.teste.bruno.apidesafio.service;

import com.teste.bruno.apidesafio.AbstractTest;
import com.teste.bruno.apidesafio.model.VeiculoModel;
import com.teste.bruno.apidesafio.model.VeiculoResponseModel;
import com.teste.bruno.apidesafio.repository.VeiculoRepository;

import org.junit.Assert;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CalcularServiceTest extends AbstractTest {

    @Autowired
    private VeiculoRepository repository;

    @Autowired
    private CalcularService service;

    @Test
    public void testCalcularPrevisaoGastos(){
        List<VeiculoResponseModel> lista =
                service.calcularPrevisaoGastos(1.0, 1.0, 1.0);

        Assert.assertNotNull(lista);
        Assert.assertTrue(lista.size() > 0);
    }

    @Test
    public void testListarVeiculos(){
        List<VeiculoModel> lista = service.listarVeiculos();

        Assert.assertNotNull(lista);
        Assert.assertTrue(lista.size() > 0);
    }

    @Test
    public void testCalcularQtdCombustGasto(){

        VeiculoModel veiculo = new VeiculoModel();
        veiculo.setCons_med_cidade(12.0);
        veiculo.setCons_med_rodov(15.0);

        Double qtdCombustGasto = service.calcularQtdCombustGasto(1.0,1.0, veiculo);

        Assert.assertNotNull(qtdCombustGasto);
    }
}
