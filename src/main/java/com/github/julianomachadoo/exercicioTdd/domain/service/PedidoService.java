package com.github.julianomachadoo.exercicioTdd.domain.service;

import com.github.julianomachadoo.exercicioTdd.domain.entity.Pedido;
import com.github.julianomachadoo.exercicioTdd.domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    /**
     * todo: melhorar a segurança da implementação:
     *                          obter todos,
     *                          obter por id,
     *                          cadastrar,
     *                          deletar,
     *                          atualizar
     *
     */

    @Autowired
    PedidoRepository pedidoRepository;

    public List<Pedido> obterTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> obterPorId(Integer id) {
        return pedidoRepository.findById(id);
    }

    public Pedido cadastrar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public void deletarPorId(Integer id) {
        pedidoRepository.deleteById(id);
    }

    public Optional<Pedido> atualizar(Integer id, Pedido pedido) {
        pedidoRepository.findById(id)
                .map(pedidoExistente -> {
                    pedido.setId(pedidoExistente.getId());
                    pedidoRepository.save(pedido);
                    return pedido;
                });
        return Optional.empty();
    }


}
