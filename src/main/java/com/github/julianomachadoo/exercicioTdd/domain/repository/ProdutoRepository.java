package com.github.julianomachadoo.exercicioTdd.domain.repository;

import com.github.julianomachadoo.exercicioTdd.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
