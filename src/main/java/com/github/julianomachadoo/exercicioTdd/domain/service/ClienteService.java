package com.github.julianomachadoo.exercicioTdd.domain.service;

import com.github.julianomachadoo.exercicioTdd.domain.entity.Cliente;
import com.github.julianomachadoo.exercicioTdd.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * todo: Implementar regras:
     *                  atualização precisa verificar os campos
     *                  delete precisa verificar os campos;
     *
     * todo: Implementar serviços por nome;
     */

    public List<Cliente> obterTodos() { return clienteRepository.findAll(); }

    public Optional<Cliente> obterPorId(Integer id) { return clienteRepository.findById(id); }

    public Cliente cadastrar(Cliente cliente) { return clienteRepository.save(cliente); }

    public void deletar(Integer id) { clienteRepository.deleteById(id);}

    public Optional<Cliente> atualizar(Integer id, Cliente cliente) {

        clienteRepository
                .findById(id)
                .map( clienteExistente -> {
                    cliente.setId(clienteExistente.getId());
                    clienteRepository.save(cliente);
                    return cliente;
                });
        return Optional.empty();
    }
}
