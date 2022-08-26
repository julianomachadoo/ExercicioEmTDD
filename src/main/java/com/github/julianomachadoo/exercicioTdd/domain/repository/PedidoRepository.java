package com.github.julianomachadoo.exercicioTdd.domain.repository;

import com.github.julianomachadoo.exercicioTdd.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
