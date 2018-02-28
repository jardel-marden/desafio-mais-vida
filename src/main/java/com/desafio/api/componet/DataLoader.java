/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.componet;

import com.desafio.api.enuns.EnumEspecialidade;
import com.desafio.api.enuns.EnumStatus;
import com.desafio.api.domain.Medico;
import com.desafio.api.domain.Usuario;
import com.desafio.api.repository.MedicoRepository;
import com.desafio.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author deoprog
 */
@Component
public class DataLoader implements ApplicationRunner {
    
    private final MedicoRepository medicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    public DataLoader(MedicoRepository medicoRepository, UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.medicoRepository = medicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @Override
    public void run(ApplicationArguments aa) throws Exception {
        medicoRepository.deleteAll();        
        
        medicoRepository.save(new Medico(null, "Jardel", "Marden", "deoprog@gmail.com", true, EnumStatus.OCULPADO, EnumEspecialidade.PEDIATRIA, "Parnaiba", "PI", 2200202l, 22l));
        medicoRepository.save(new Medico(null, "Luanna", "Fretas", "luannacrhisthie@hotmail.com", true, EnumStatus.DISPONIVEL, EnumEspecialidade.ANESTESIOLOGIA, "Piripiri", "PI", 2200202l, 22l));
        
        usuarioRepository.deleteAll();
        usuarioRepository.save(new Usuario(null, "admin", bCryptPasswordEncoder.encode("010203")));
    }
    
}
