/*
 * Copyright (c) 2020. Olá todos os direitos reservados para IT CODE TECHS SYSTEMS.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/vendas/src/main/java/com/itcode/service/PedidoService.java)
 * Projeto: vendas -> vendas -> PedidoService
 * Criador: andersons.andrade
 * Última Modificação: 26/11/2020 19:13
 */

package com.itcode.service;

import com.itcode.api.dto.PedidoDTO;
import com.itcode.domain.entity.Pedido;

public interface PedidoService {
    Pedido save(PedidoDTO dto);
}
