package com.teste.bruno.apidesafio.model;

import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "veiculo")
@Table(name="veiculo")
@Data
public class VeiculoModel {

    public VeiculoModel(String nome, String marca, String modelo, Date data_fabric, Double cons_med_cidade, Double cons_med_rodov) {
        this.setNome(nome);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setData_fabric(data_fabric);
        this.setCons_med_cidade(cons_med_cidade);
        this.setCons_med_rodov(cons_med_rodov);
    }

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
