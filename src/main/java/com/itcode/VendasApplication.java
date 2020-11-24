package com.itcode;

import com.itcode.domain.entity.Cliente;
import com.itcode.domain.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClienteRepository clientes){
        return args -> {
            clientes.salvar(new Cliente(1,"Anderson S. Andrade"));
            clientes.salvar(new Cliente(2,"Débora Q. Maciel Andrade"));
            clientes.salvar(new Cliente(3,"Miriã F. Maciel"));
            clientes.salvar(new Cliente(4,"Helena M. Andrade"));
            List<Cliente> listaTodos = clientes.obterTodos();
            listaTodos.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
