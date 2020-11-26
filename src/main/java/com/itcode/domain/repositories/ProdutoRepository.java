/*
 * Copyright (c) 2020. Olá todos os direitos reservados para IT CODE TECHS SYSTEMS.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/vendas/src/main/java/com/itcode/domain/repositories/ProdutoRepository.java)
 * Projeto: vendas -> vendas -> ProdutoRepository
 * Criador: andersons.andrade
 * Última Modificação: 26/11/2020 01:59
 */

package com.itcode.domain.repositories;

import com.itcode.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
