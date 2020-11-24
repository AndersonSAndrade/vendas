/*
 * Copyright (c) 2020. Olá todos os direitos reservados para IT CODE TECHS SYSTEMS.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/vendas/src/main/java/com/itcode/config/CompanyConfiguration.java)
 * Projeto: vendas -> vendas -> Configuration
 * Criador: andersons.andrade
 * Última Modificação: 23/11/2020 22:19
 */

package com.itcode.config;

import com.itcode.annotations.Development;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Development
public class CompanyConfiguration {

    @Bean
    public CommandLineRunner execute(){
        return args -> {
            System.out.println("-> RODANDO A CONFIGURACAO DE DESENVOLVIMENTO! <-");
        };
    }

}

