package com.desafio.api.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author deoprog
 */
@Configuration
@EnableConfigurationProperties
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.desafio.api.domain"})
@ComponentScan(basePackages = {"com.desafio.api.component"})
public class ApplicationConfig {

}
