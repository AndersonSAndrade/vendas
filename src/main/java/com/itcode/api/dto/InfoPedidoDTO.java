/*
 * Copyright (c) 2020. Olá todos os direitos reservados para IT CODE TECHS SYSTEMS.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/vendas/src/main/java/com/itcode/api/dto/InfoPedidoDTO.java)
 * Projeto: vendas -> vendas -> InfoPedidoDTO
 * Criador: andersons.andrade
 * Última Modificação: 27/11/2020 04:47
 */

package com.itcode.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InfoPedidoDTO {
    private Integer codigo;
    private String cpf;
    private String nomeCliente;
    private String dataPedido;
    private String status;
    private BigDecimal total;
    private List<InfoItemPedidoDTO> items;
}
