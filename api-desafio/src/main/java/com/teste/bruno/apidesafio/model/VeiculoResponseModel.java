package com.teste.bruno.apidesafio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class VeiculoResponseModel {
    private String nome;

    private String marca;

    private String modelo;

    private Date ano;

    private Double qtdCombustGasto;

    private Double valCombustivel;
}
