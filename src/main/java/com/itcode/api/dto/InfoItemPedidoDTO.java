/*
 * Copyright (c) 2020. Olá todos os direitos reservados para IT CODE TECHS SYSTEMS.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/vendas/src/main/java/com/itcode/api/dto/InfoItemPedidoDTO.java)
 * Projeto: vendas -> vendas -> InfoItemPedidoDTO
 * Criador: andersons.andrade
 * Última Modificação: 27/11/2020 04:50
 */

package com.itcode.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InfoItemPedidoDTO {
    private String descricaoProduto;
    private BigDecimal precoUnitario;
    private Integer quantidadeProduto;
}
