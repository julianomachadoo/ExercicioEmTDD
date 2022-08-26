package com.github.julianomachadoo.exercicioTdd.domain.controller;

import com.github.julianomachadoo.exercicioTdd.domain.entity.Cliente;
import com.github.julianomachadoo.exercicioTdd.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/api/clientes/")
public class ClienteController {

    /**
     * todo: implementar métodos por nome
     */
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> obterTodos(){
        return clienteService.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> obterPorId(@PathVariable Integer id){
        return clienteService.obterPorId(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
        return clienteService.cadastrar(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deletarCliente(@PathVariable Integer id){
        clienteService.deletar(id);
    }

    /**
     *
     * todo: consertar método put
     */
    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void atualizarCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
        clienteService.atualizar(id, cliente);
    }
}
