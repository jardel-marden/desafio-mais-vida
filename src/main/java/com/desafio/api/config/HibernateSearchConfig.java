/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.config;

import com.desafio.api.service.impl.MedicoServiceImpl;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author deoprog
 */
@Configuration
public class HibernateSearchConfig {
    
    @Autowired
    private EntityManager entityManager;
    
    @Bean
    MedicoServiceImpl medicoServiceImpl() {
        MedicoServiceImpl medicoService = new MedicoServiceImpl(entityManager);
        medicoService.initializeHibernate();
        
        return medicoService;
    }
}
