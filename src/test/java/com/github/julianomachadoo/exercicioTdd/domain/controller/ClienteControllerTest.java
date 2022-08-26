package com.github.julianomachadoo.exercicioTdd.domain.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.julianomachadoo.exercicioTdd.domain.entity.Cliente;
import com.github.julianomachadoo.exercicioTdd.domain.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ClienteController.class)
@ExtendWith(SpringExtension.class)
class ClienteControllerTest {

    /**
     * todo: incrementar o rigor dos testes
     *
     */

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ClienteService clienteService;

    @Autowired
    ClienteController clienteController;

    @Autowired
    ObjectMapper mapper;

    @Test
    void obterTodosTeste() throws Exception {
        mockMvc.perform(get("/api/clientes/"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void obterPorIdTeste() throws Exception {
        // cenário:
        Cliente c = new Cliente("Juliano", "juliano@gmail.com");
        clienteController.cadastrarCliente(c);
        String url = "/api/clientes/1";

        mockMvc.perform(get(url))
                .andExpect(status().isOk());
    }

    @Test
    void cadastrarClienteTeste() throws Exception {
        // Given:
        Cliente c = new Cliente("Juliano", "juliano@gmail.com");
        // Then:
        mockMvc.perform(post("/api/clientes/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(c)))
                .andExpect(status().isCreated());
    }

    @Test
    void deletarClienteTeste() throws Exception {
        // cenário:
        Cliente c = new Cliente("Juliano", "juliano@gmail.com");
        clienteController.cadastrarCliente(c);

        // caso:
        mockMvc.perform(delete("/api/clientes/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void atualizarClienteTeste() throws Exception {
        // cenário:
        Cliente c = new Cliente("Juliano", "juliano@gmail.com");
        clienteController.cadastrarCliente(c);

        // caso:
        c.setEmail("jul@gmail.com");
        mockMvc.perform(put("/api/clientes/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(c)))
                .andExpect(status().isNoContent());
    }
}
