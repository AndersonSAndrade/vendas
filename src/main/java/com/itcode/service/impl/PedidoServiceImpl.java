/*
 * Copyright (c) 2020. Olá todos os direitos reservados para IT CODE TECHS SYSTEMS.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/vendas/src/main/java/com/itcode/service/impl/PedidoServiceImpl.java)
 * Projeto: vendas -> vendas -> PedidoServiceImpl
 * Criador: andersons.andrade
 * Última Modificação: 26/11/2020 19:14
 */

package com.itcode.service.impl;

import com.itcode.api.dto.ItemPedidoDTO;
import com.itcode.api.dto.PedidoDTO;
import com.itcode.domain.entity.Cliente;
import com.itcode.domain.entity.ItemPedido;
import com.itcode.domain.entity.Pedido;
import com.itcode.domain.entity.Produto;
import com.itcode.domain.repositories.ClienteRepository;
import com.itcode.domain.repositories.ItemPedidoRepository;
import com.itcode.domain.repositories.PedidoRepository;
import com.itcode.domain.repositories.ProdutoRepository;
import com.itcode.exception.BusinessExceptionRule;
import com.itcode.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;
    private final ItemPedidoRepository itemPedidoRepository;

    @Override
    @Transactional
    public Pedido save(PedidoDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new BusinessExceptionRule("Código de Cliente Inválido!"));
        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);
        List<ItemPedido> itemsPedido = convertItems(pedido, dto.getItems());
        pedidoRepository.save(pedido);
        itemPedidoRepository.saveAll(itemsPedido);
        pedido.setItems(itemsPedido);
        return pedido;
    }

    private List<ItemPedido> convertItems(Pedido pedido, List<ItemPedidoDTO> items){
        if(items.isEmpty()){
            throw new BusinessExceptionRule("Não é possível realizar um pedido sem items");
        }

        return items.stream().map(dto -> {
            Integer idProduto = dto.getProduto();
            Produto produto = produtoRepository.findById(idProduto).orElseThrow(() -> new BusinessExceptionRule("Código do produto inválido! COD: "+ idProduto));
            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setQuantidade(dto.getQuantidade());
            itemPedido.setPedido(pedido);
            itemPedido.setProduto(produto);
            return itemPedido;
        }).collect(Collectors.toList());
    }
}
