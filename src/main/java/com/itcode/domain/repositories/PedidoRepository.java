/*
 * Copyright (c) 2020. Olá todos os direitos reservados para IT CODE TECHS SYSTEMS.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/vendas/src/main/java/com/itcode/domain/repositories/PedidoRepository.java)
 * Projeto: vendas -> vendas -> PedidoRepository
 * Criador: andersons.andrade
 * Última Modificação: 26/11/2020 01:59
 */

package com.itcode.domain.repositories;

import com.itcode.domain.entity.Cliente;
import com.itcode.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByCliente(Cliente cliente);
}
