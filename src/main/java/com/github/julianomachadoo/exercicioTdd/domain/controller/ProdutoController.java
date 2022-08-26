package com.github.julianomachadoo.exercicioTdd.domain.controller;

import com.github.julianomachadoo.exercicioTdd.domain.entity.Cliente;
import com.github.julianomachadoo.exercicioTdd.domain.entity.Produto;
import com.github.julianomachadoo.exercicioTdd.domain.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/produtos/")
public class ProdutoController {

    /**
     * todo: implementar classe:
     *                          obterTodos,
     *                          obterPorId,
     *                          cadastrar,
     *                          deletar,
     *                          atualizar;
     */

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    @ResponseStatus(OK)
    public List<Produto> obterTodosProdutos() {
        return produtoService.obterTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public Optional<Produto> obterProdutoPorId(@PathVariable Integer id) {
        return produtoService.obterPorId(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Produto cadastraProduto(@RequestBody Produto produto) {
        return produtoService.cadastrar(produto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deletaProdutoPorId(@PathVariable Integer id) {
        produtoService.deletarPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public Optional<Produto> atualizaProduto(@PathVariable Integer id, @RequestBody Produto produto) {
        return produtoService.atualizar(id, produto);
    }
}
