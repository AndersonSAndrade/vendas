/*
 * Copyright (c) 2020. Olá todos os direitos reservados para IT CODE TECHS SYSTEMS.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/vendas/src/main/java/com/itcode/api/controllers/ProdutoController.java)
 * Projeto: vendas -> vendas -> ProdutoController
 * Criador: andersons.andrade
 * Última Modificação: 26/11/2020 08:40
 */

package com.itcode.api.controllers;

import com.itcode.domain.entity.Produto;
import com.itcode.domain.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    private ProdutoRepository produtoRepository;

    @PostMapping
    @ResponseStatus(CREATED)
    public Produto save (@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Produto produto){
        produtoRepository.findById(id).map(p -> {
            produto.setId(p.getId());
            produtoRepository.save(produto);
            return produto;
        }).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Produto não encontrado!"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id){
        produtoRepository.findById(id).map(p -> {
            produtoRepository.delete(p);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Produto não encontrado!"));
    }

    @GetMapping("/{id}")
    public Produto getProdutoById(@PathVariable Integer id){
        return produtoRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(NOT_FOUND, "Cliente não encontrado"));
    }

    @GetMapping()
    public List<Produto> find(Produto filtro){
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
        return produtoRepository.findAll(example);
    }


}
