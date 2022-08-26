package com.github.julianomachadoo.exercicioTdd.domain.service;

import com.github.julianomachadoo.exercicioTdd.domain.entity.Cliente;
import com.github.julianomachadoo.exercicioTdd.domain.entity.Produto;
import com.github.julianomachadoo.exercicioTdd.domain.repository.ProdutoRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
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
    private ProdutoRepository produtoRepository;

    public List<Produto> obterTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> obterPorId(Integer id) {
        return produtoRepository.findById(id);
    }

    public Produto cadastrar(Produto produto) {
        if(produto.getEstoque() == null) {
            produto.setEstoque(0);
        }
        return produtoRepository.save(produto);
    }

    public void deletarPorId(Integer id) {
       produtoRepository.deleteById(id);
    }

    public Optional<Produto> atualizar(Integer id, Produto produto) {
        produtoRepository
                .findById(id)
                .map(clienteExistente -> {
                    produto.setId(clienteExistente.getId());
                    produtoRepository.save(produto);
                    return produto;
                });
        return Optional.empty();
    }
}
