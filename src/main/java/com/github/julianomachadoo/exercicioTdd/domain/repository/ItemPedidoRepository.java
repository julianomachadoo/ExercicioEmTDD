package com.github.julianomachadoo.exercicioTdd.domain.repository;

import com.github.julianomachadoo.exercicioTdd.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
}
