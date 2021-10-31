package com.teste.bruno.apidesafio.repository;

import com.teste.bruno.apidesafio.model.VeiculoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<VeiculoModel, Integer> {
}
