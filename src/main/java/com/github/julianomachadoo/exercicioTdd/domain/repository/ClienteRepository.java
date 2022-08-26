package com.github.julianomachadoo.exercicioTdd.domain.repository;

import com.github.julianomachadoo.exercicioTdd.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
