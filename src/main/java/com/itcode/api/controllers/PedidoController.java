/*
 * Copyright (c) 2020. Olá todos os direitos reservados para IT CODE TECHS SYSTEMS.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/vendas/src/main/java/com/itcode/api/controllers/PedidoController.java)
 * Projeto: vendas -> vendas -> PedidoController
 * Criador: andersons.andrade
 * Última Modificação: 26/11/2020 19:10
 */

package com.itcode.api.controllers;

import com.itcode.api.dto.PedidoDTO;
import com.itcode.domain.entity.Pedido;
import com.itcode.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private PedidoService pedidoService;

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save(@RequestBody PedidoDTO dto){
        Pedido pedido = pedidoService.save(dto);
        return pedido.getId();
    }

}
