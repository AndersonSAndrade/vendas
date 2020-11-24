/*
 * Copyright (c) 2020. Olá todos os direitos reservados para IT CODE TECHS SYSTEMS.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/vendas/src/main/java/com/itcode/services/ClientService.java)
 * Projeto: vendas -> vendas -> ClientService
 * Criador: andersons.andrade
 * Última Modificação: 23/11/2020 22:58
 */

package com.itcode.services;

import com.itcode.models.Client;
import com.itcode.repositories.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private ClientRepository repo;

    public ClientService(ClientRepository repo) {
        this.repo = repo;
    }

    public void salvarCliente(Client cliente){
        validarCliente(cliente);
        repo.persistir(cliente);
    }

    public void validarCliente(Client clinte){

    }
}
