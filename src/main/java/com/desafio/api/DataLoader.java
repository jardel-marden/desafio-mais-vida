/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api;

import com.desafio.api.enuns.EnumEspecialidade;
import com.desafio.api.enuns.EnumStatus;
import com.desafio.api.model.Medico;
import com.desafio.api.model.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author deoprog
 */
@Component
public class DataLoader implements ApplicationRunner {
    
    private MedicoRepository medicoRepository;
    
    @Autowired
    public DataLoader(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }
    
    @Override
    public void run(ApplicationArguments aa) throws Exception {
        medicoRepository.deleteAll();
        medicoRepository.save(new Medico(null, "Jardel", "Marden", "deoprog@gmail.com", true, EnumStatus.OCULPADO, EnumEspecialidade.PEDIATRIA, "Parnaiba", "PI", null, null));
        medicoRepository.save(new Medico(null, "Luanna", "Fretas", "luannacrhisthie@hotmail.com", true, EnumStatus.DISPONIVEL, EnumEspecialidade.ANESTESIOLOGIA, "Piripiri", "PI", null, null));
    }
    
}
