/*
 * Copyright (c) 2020. Olá todos os direitos reservados para IT CODE TECHS SYSTEMS.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/vendas/src/main/java/com/itcode/api/dto/ItemPedidoDTO.java)
 * Projeto: vendas -> vendas -> ItemPedidoDTO
 * Criador: andersons.andrade
 * Última Modificação: 26/11/2020 19:27
 */

package com.itcode.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemPedidoDTO {
   private Integer produto;
   private Integer quantidade;
}
