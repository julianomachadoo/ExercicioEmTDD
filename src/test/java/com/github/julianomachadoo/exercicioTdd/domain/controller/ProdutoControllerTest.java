package com.github.julianomachadoo.exercicioTdd.domain.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.julianomachadoo.exercicioTdd.domain.entity.Produto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ProdutoController.class)
@ExtendWith(SpringExtension.class)
class ProdutoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ProdutoController produtoController;

    @Autowired
    ObjectMapper mapper;

    @Test
    void obterTodosProdutosTeste()  throws Exception {
        mockMvc.perform(get("/api/produtos/"))
                .andExpect(status().isOk());
    }

    @Test
    void obterProdutosPorIdTeste() throws Exception {
        // cenário:
        Produto p = new Produto("Celular", BigDecimal.valueOf(100), 0);
        produtoController.cadastraProduto(p);
        String url = "/api/produtos/1";

        mockMvc.perform(get(url))
                .andExpect(status().isOk());
    }

    @Test
    void cadastraProdutoTeste() throws Exception {
        Produto p = new Produto("Celular", BigDecimal.valueOf(100), 0);

        mockMvc.perform(post("/api/produtos/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(p)))
                .andExpect(status().isCreated());
    }

    @Test
    void deletaProdutoPorIdTeste() throws Exception {
        Produto p = new Produto("Celular", BigDecimal.valueOf(100), 0);
        produtoController.cadastraProduto(p);
        String url = "/api/produtos/1";

        mockMvc.perform(delete(url))
                .andExpect(status().isNoContent());
    }

    @Test
    void atualizaProdutoTeste() throws Exception {
        Produto p = new Produto("Celular", BigDecimal.valueOf(100), 0);
        produtoController.cadastraProduto(p);
        String url = "/api/produtos/1";

        p.setNome("Celular v3");
        mockMvc.perform(put(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(p)))
                .andExpect(status().isOk());
    }
}