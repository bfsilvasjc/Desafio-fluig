package com.teste.bruno.apidesafio.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity(name = "veiculo")
@Table(name="veiculo")
@Data
public class VeiculoModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idVeiculo;

    @Column(nullable = false, length = 30)
    private String nome;

    @Column(nullable = false, length = 30)
    private String marca;

    @Column(nullable = false, length = 30)
    private String modelo;

    @Column(nullable = false, length = 30)
    private Date data_fabric;

    @Column(nullable = false, length = 30)
    private Double cons_med_cidade;

    @Column(nullable = false, length = 30)
    private Double cons_med_rodov;
}
