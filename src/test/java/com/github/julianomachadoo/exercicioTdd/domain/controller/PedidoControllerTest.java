package com.github.julianomachadoo.exercicioTdd.domain.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.julianomachadoo.exercicioTdd.domain.entity.Pedido;
import com.github.julianomachadoo.exercicioTdd.domain.entity.Produto;
import com.github.julianomachadoo.exercicioTdd.domain.service.PedidoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PedidoController.class)
@ExtendWith(SpringExtension.class)
class PedidoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PedidoService pedidoService;

    @Autowired
    ObjectMapper mapper;

    @Test
    void obterTodosPedidosTeste() throws Exception {
        mockMvc.perform(get("/api/produtos/"))
                .andExpect(status().isOk());
    }

    @Test
    void obterPedidoPorIdTeste() {
//        // cenário:
//        Pedido p = new Pedido("Celular", BigDecimal.valueOf(100), 0);
//        produtoController.cadastraProduto(p);
//        String url = "/api/produtos/1";
//
//        mockMvc.perform(get(url))
//                .andExpect(status().isOk());
    }

    @Test
    void cadastrarPedidoTeste() {
    }

    @Test
    void deletarPedidoTeste() {
    }

    @Test
    void atualizarPedidoTeste() {
    }
}