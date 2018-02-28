/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.service.impl;

import com.desafio.api.domain.Usuario;
import com.desafio.api.repository.UsuarioRepository;
import com.desafio.api.service.UsuarioService;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author deoprog
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    private static final Logger log = LoggerFactory.getLogger(Usuario.class);
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public Optional<Usuario> findByUsername(String username) {
        log.info("Buscando nome do medico {}", username);
        return Optional.ofNullable(this.usuarioRepository.findByUsername(username));
    }

    @Override
    public Usuario save(Usuario entity) {        
        return this.usuarioRepository.save(entity);
    }

    @Override
    public void update(Usuario entity) {
        this.usuarioRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        this.usuarioRepository.delete(id);
    }    
    
    @Override
    public Usuario find(Long id) {
        return this.usuarioRepository.findOne(id);
    }

    @Override
    public List<Usuario> findAll() {
        return this.usuarioRepository.findAll();
    }
    
}
