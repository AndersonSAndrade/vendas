/*
 * Copyright (c) 2020. Olá todos os direitos reservados para IT CODE TECHS SYSTEMS.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/vendas/src/main/java/com/itcode/api/controllers/PedidoController.java)
 * Projeto: vendas -> vendas -> PedidoController
 * Criador: andersons.andrade
 * Última Modificação: 26/11/2020 19:10
 */

package com.itcode.api.controllers;

import com.itcode.api.dto.InfoItemPedidoDTO;
import com.itcode.api.dto.InfoPedidoDTO;
import com.itcode.api.dto.PedidoDTO;
import com.itcode.api.dto.UpdateStatusPedidoDTO;
import com.itcode.domain.StatusPedido;
import com.itcode.domain.entity.ItemPedido;
import com.itcode.domain.entity.Pedido;
import com.itcode.service.PedidoService;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.AllArgsConstructor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save(@RequestBody PedidoDTO dto){
        Pedido pedido = pedidoService.save(dto);
        return pedido.getId();
    }
    @GetMapping("/{id}")
    public InfoPedidoDTO getById(@PathVariable Integer id){
        return pedidoService.viewPedidoAll(id).map(info -> convertViewPedido(info)
        ).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Pedido não encontrado!"));
    }

    @PatchMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateStatosPedido(@PathVariable Integer id, @RequestBody UpdateStatusPedidoDTO dto){
        String newStatus = dto.getNewStatus();
        pedidoService.updateStatusPedido(id, StatusPedido.valueOf(newStatus));
    }

    private InfoPedidoDTO convertViewPedido(Pedido pedido){
        return InfoPedidoDTO.builder()
                .codigo(pedido.getId())
                .dataPedido(pedido.getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .cpf(pedido.getCliente().getCpf())
                .nomeCliente(pedido.getCliente().getNome())
                .total(pedido.getTotal())
                .status(pedido.getStatus().name())
                .items(convertViewItemPedidoDTO(pedido.getItems()))
                .build();
    }

    private List<InfoItemPedidoDTO> convertViewItemPedidoDTO(List<ItemPedido> items){
        if(CollectionUtils.isEmpty(items)){
            return Collections.emptyList();
        }
        return  items.stream().map(item -> InfoItemPedidoDTO.builder()
                .descricaoProduto(item.getProduto().getDescricao())
        .precoUnitario(item.getProduto().getPreco())
        .quantidadeProduto(item.getQuantidade()).build()
        ).collect(Collectors.toList());
    }

}
