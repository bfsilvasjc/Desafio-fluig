package com.teste.bruno.apidesafio.service;

import com.teste.bruno.apidesafio.model.VeiculoModel;
import com.teste.bruno.apidesafio.model.VeiculoResponseModel;
import com.teste.bruno.apidesafio.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalcularService {

    @Autowired
    private VeiculoRepository repository;

    public List<VeiculoResponseModel> calcularPrevisaoGastos(Double preco, Double kmCidade, Double kmRodovia){

        List<VeiculoResponseModel> resposta = new ArrayList<VeiculoResponseModel>();

        List<VeiculoModel> veiculos = this.listarVeiculos();

        for (VeiculoModel veiculo: veiculos) {
            resposta.add(new VeiculoResponseModel(
                    veiculo.getIdVeiculo(),
                    veiculo.getNome(),
                    veiculo.getMarca(),
                    veiculo.getModelo(),
                    veiculo.getData_fabric(),
                    calcularQtdCombustGasto(kmCidade, kmRodovia, veiculo),
                    calcularQtdCombustGasto(kmCidade, kmRodovia, veiculo) * preco
            ));
        }

        return resposta;
    }

    public List<VeiculoModel> listarVeiculos(){
        return repository.findAll();
    }

    public Double calcularQtdCombustGasto(Double kmCidade, Double kmRodovia, VeiculoModel veiculo){
        return kmCidade / (veiculo.getCons_med_cidade()) + (kmRodovia / veiculo.getCons_med_rodov());
    }
}
