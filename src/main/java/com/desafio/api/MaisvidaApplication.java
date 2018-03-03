package com.desafio.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MaisvidaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaisvidaApplication.class, args);
    }  
}
