package com.itcode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VendasApplication {

    @Value("${company.name}")
    private String companyName;
    @Value("${company.slogan}")
    private String companySlogan;

    @GetMapping("/hello")
    public String helloWorld(){
        return "A " + companyName + " com slogan " + companySlogan + ", e a melhor do mundo!";
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
