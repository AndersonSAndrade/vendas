/*
 * Copyright (c) 2020. Olá todos os direitos reservados para IT CODE TECHS SYSTEMS.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/vendas/src/main/java/com/itcode/domain/entity/Pedido.java)
 * Projeto: vendas -> vendas -> Pedido
 * Criador: andersons.andrade
 * Última Modificação: 24/11/2020 19:12
 */

package com.itcode.domain.entity;

import com.itcode.domain.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @Column(name = "data_pedido")
    private LocalDate dataPedido;
    @Column(name = "total", precision = 20, scale = 2)
    private BigDecimal total;
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> items;
}
