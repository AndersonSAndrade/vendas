/*
 * Copyright (c) 2020. Olá todos os direitos reservados para IT CODE TECHS SYSTEMS.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/vendas/src/main/java/com/itcode/exception/PedidoNotFoudException.java)
 * Projeto: vendas -> vendas -> PedidoNotFoudException
 * Criador: andersons.andrade
 * Última Modificação: 27/11/2020 09:50
 */

package com.itcode.exception;

public class PedidoNotFoudException extends RuntimeException{
    public PedidoNotFoudException() {
        super("Pedido Não Encontrado!");
    }
}
