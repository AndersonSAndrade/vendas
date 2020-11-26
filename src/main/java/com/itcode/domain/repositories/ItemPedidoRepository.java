/*
 * Copyright (c) 2020. Olá todos os direitos reservados para IT CODE TECHS SYSTEMS.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/vendas/src/main/java/com/itcode/domain/repositories/ItemPedidoRepository.java)
 * Projeto: vendas -> vendas -> ItemPedidoRepository
 * Criador: andersons.andrade
 * Última Modificação: 26/11/2020 02:00
 */

package com.itcode.domain.repositories;

import com.itcode.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
}
