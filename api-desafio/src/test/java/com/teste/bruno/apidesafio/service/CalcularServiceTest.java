package com.teste.bruno.apidesafio.service;

import com.teste.bruno.apidesafio.model.VeiculoModel;
import com.teste.bruno.apidesafio.model.VeiculoResponseModel;
import com.teste.bruno.apidesafio.repository.VeiculoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CalcularServiceTest {

    @Autowired
    private VeiculoRepository repository;

    @Mock
    CalcularService service;

    @Test
    void testCalcularPrevisaoGastos(){
        List<VeiculoResponseModel> lista =
                service.calcularPrevisaoGastos(1.0, 1.0, 1.0);

        Assertions.assertNotNull(lista);
    }

    @Test
    void testListarVeiculos(){
        List<VeiculoModel> lista = service.listarVeiculos();

        Assertions.assertNotNull(lista);
    }

    @Test
    void testCalcularQtdCombustGasto(){

        VeiculoModel veiculo = new VeiculoModel();

        Double qtdCombustGasto = service.calcularQtdCombustGasto(1.0,1.0,veiculo);

        Assertions.assertNotNull(qtdCombustGasto);
    }
}
