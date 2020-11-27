/*
 * Copyright (c) 2020. Olá todos os direitos reservados para IT CODE TECHS SYSTEMS.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/vendas/src/main/java/com/itcode/api/controllers/ClienteController.java)
 * Projeto: vendas -> vendas -> ClienteController
 * Criador: andersons.andrade
 * Última Modificação: 26/11/2020 09:36
 */

package com.itcode.api.controllers;

import com.itcode.domain.entity.Cliente;
import com.itcode.domain.repositories.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import static org.springframework.http.HttpStatus.*;


@AllArgsConstructor
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private ClienteRepository repo;

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Integer id){
        return repo.findById(id).orElseThrow(() ->
                new ResponseStatusException(NOT_FOUND, "Cliente não encontrado"));
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
        Cliente req = repo.save(cliente);
        return ResponseEntity.ok(req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id){
        repo.findById(id).map(c -> {
            repo.delete(c);
            return c;
        }).orElseThrow(() ->
                new ResponseStatusException(NOT_FOUND, "Cliente não encontrado"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Cliente cliente){
        repo.findById(id).map(c -> {
            cliente.setId(c.getId());
            repo.save(cliente);
            return c;
        }).orElseThrow(() ->
                new ResponseStatusException(NOT_FOUND, "Cliente não encontrado"));
    }

    @GetMapping()
    public List<Cliente> find(Cliente filtro){
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
        return repo.findAll(example);
    }


}
