package com.itcode;

import com.itcode.domain.entity.Cliente;
import com.itcode.domain.entity.Pedido;
import com.itcode.domain.repositories.ClienteRepository;
import com.itcode.domain.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClienteRepository clientes, @Autowired PedidoRepository pedidos){
        return args -> {
            System.out.println("Salvando Clientes");
            Cliente ads = new Cliente("Anderson S. Andrade");
            clientes.save(ads);
            Pedido p = new Pedido();
            p.setCliente(ads);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100));
            pedidos.save(p);

//            Cliente cliente = clientes.findClienteFetchPedidos(ads.getId());
//            System.out.println(cliente);
//            System.out.println(cliente.getPedidos());

            pedidos.findByCliente(ads).forEach(System.out::println);

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
