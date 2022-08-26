package com.github.julianomachadoo.exercicioTdd.domain.controller;

import com.github.julianomachadoo.exercicioTdd.domain.entity.Pedido;
import com.github.julianomachadoo.exercicioTdd.domain.entity.Produto;
import com.github.julianomachadoo.exercicioTdd.domain.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/pedidos/")
public class PedidoController {
    /**
     * todo: implementar classe:
     *                          obterTodos,
     *                          obterPorId,
     *                          cadastrar,
     *                          deletar,
     *                          atualizar;
     */

    @Autowired
    PedidoService pedidoService;

    @GetMapping
    @ResponseStatus(OK)
    public List<Pedido> obterTodosPedidos() {
        return pedidoService.obterTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public Optional<Pedido> obterPedidoPorId(@PathVariable Integer id){
        return pedidoService.obterPorId(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Pedido cadastrarPedido(@RequestBody Pedido pedido) {
        return pedidoService.cadastrar(pedido);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deletarPedido(@PathVariable Integer id) {
        pedidoService.deletarPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public Optional<Pedido> atualizarPedido(@PathVariable Integer id, @RequestBody Pedido pedido) {
        return pedidoService.atualizar(id, pedido);
    }
}
