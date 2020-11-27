/*
 * Copyright (c) 2020. Olá todos os direitos reservados para IT CODE TECHS SYSTEMS.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/vendas/src/main/java/com/itcode/exception/BusinessExceptionRule.java)
 * Projeto: vendas -> vendas -> BusinessExceptionRule
 * Criador: andersons.andrade
 * Última Modificação: 27/11/2020 01:26
 */

package com.itcode.exception;

public class BusinessExceptionRule extends RuntimeException{
    public BusinessExceptionRule(String msg){
        super(msg);
    }
}
