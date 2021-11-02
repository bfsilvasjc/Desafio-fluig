package com.teste.bruno.apidesafio.controller;

import com.teste.bruno.apidesafio.AbstractControllerTest;
import com.teste.bruno.apidesafio.model.VeiculoModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional
public class VeiculoControllerTest extends AbstractControllerTest {
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testConsultar() throws Exception {
        String uri = "/api/veiculo/{codigo}";
        Integer codigo = 1;

        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri, codigo)).andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        Assert.assertEquals(status, 200);
        Assert.assertNotNull(content);
    }

    @Test
    public void testConsultarNotFound() throws Exception {
        String uri = "/api/veiculo/{codigo}";
        Integer codigo = 0;

        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri, codigo)).andReturn();

        int status = result.getResponse().getStatus();

        Assert.assertEquals(status, 404);
    }

    @Test
    public void testCadastrarVeiculo() throws Exception {
        String uri = "/api/cadastrar";

        VeiculoModel veiculoModel = new VeiculoModel(
                "Nome Teste", "Honda", "Civic", new Date(), 10.0, 12.0);

        String inputJson = super.mapToJson(veiculoModel);

        MvcResult result = mvc.perform(
                MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(inputJson))
                .andReturn();

        int status = result.getResponse().getStatus();
        Assert.assertEquals(status, 200);

        String content = result.getResponse().getContentAsString();
        VeiculoModel veiculoModelCriado = super.mapFromJson(content, VeiculoModel.class);

        Assert.assertNotNull(veiculoModelCriado);
        Assert.assertEquals(veiculoModel.getNome(), veiculoModelCriado.getNome());
    }

    @Test
    public void testCalcular() throws Exception {
        String uri = "/api/calcular";

        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri)
                .queryParam("preco", "10.0")
                .queryParam("kmCidade", "100.0")
                .queryParam("kmRodovia", "120.0")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        Assert.assertNotNull(content);
        Assert.assertEquals(status, 200);
    }
}
