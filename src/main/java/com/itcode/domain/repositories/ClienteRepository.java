/*
 * Copyright (c) 2020. Olá todos os direitos reservados para IT CODE TECHS SYSTEMS.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/vendas/src/main/java/com/itcode/domain/repositories/ClienteRepository.java)
 * Projeto: vendas -> vendas -> ClienteRepository
 * Criador: andersons.andrade
 * Última Modificação: 24/11/2020 19:16
 */

package com.itcode.domain.repositories;

import com.itcode.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query(value = " select c from Cliente c where c.nome like :nome ")
    List<Cliente> encontrarPorNome(@Param("nome") String nome);
    @Query(" select c from Cliente c left join fetch c.pedidos where c.id=:id")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);
}
