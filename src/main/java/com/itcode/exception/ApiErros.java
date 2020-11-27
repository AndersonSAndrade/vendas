/*
 * Copyright (c) 2020. Olá todos os direitos reservados para IT CODE TECHS SYSTEMS.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/vendas/src/main/java/com/itcode/exception/ApiErros.java)
 * Projeto: vendas -> vendas -> ApiErros
 * Criador: andersons.andrade
 * Última Modificação: 27/11/2020 04:37
 */

package com.itcode.exception;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiErros {
    @Getter
    private List<String> erros;

    public ApiErros(String msgError){
        this.erros = Arrays.asList(msgError);
    }


}
