/*
 * Copyright (c) 2020. Olá todos os direitos reservados para IT CODE TECHS SYSTEMS.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/vendas/src/main/java/com/itcode/domain/entity/Produto.java)
 * Projeto: vendas -> vendas -> Produto
 * Criador: andersons.andrade
 * Última Modificação: 24/11/2020 19:10
 */

package com.itcode.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length = 100)
    private String descricao;
    @Column(name = "preco_unitario")
    private BigDecimal preco;
}
