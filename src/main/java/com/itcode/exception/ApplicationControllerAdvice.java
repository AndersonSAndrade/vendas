/*
 * Copyright (c) 2020. Olá todos os direitos reservados para IT CODE TECHS SYSTEMS.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/vendas/src/main/java/com/itcode/exception/ApplicationControllerAdvice.java)
 * Projeto: vendas -> vendas -> ApplicationControllerAdvice
 * Criador: andersons.andrade
 * Última Modificação: 27/11/2020 04:35
 */

package com.itcode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(BusinessExceptionRule.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handleBusinessRuleException(BusinessExceptionRule ex){
        String msgErro = ex.getMessage();
        return new ApiErros(msgErro);
    }

    @ExceptionHandler(PedidoNotFoudException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErros handlePedidoNotFoundException(PedidoNotFoudException ex){
        return new ApiErros(ex.getMessage());
    }
}
