package org.me.mvnspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MvnSpringApplication {
    @Autowired
    CashCardRepository repository;
    public static void main(String[] args) {
        SpringApplication.run(MvnSpringApplication.class, args);
    }

}
