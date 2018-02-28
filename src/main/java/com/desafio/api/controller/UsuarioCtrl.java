/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.controller;

import com.desafio.api.domain.Usuario;
import com.desafio.api.repository.UsuarioRepository;
import com.desafio.api.domain.std.UsuarioSerializer;
import com.desafio.api.service.impl.UsuarioServiceImpl;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author deoprog
 */
@RestController
@RequestMapping("/usuarios")
@BasePathAwareController
@JsonSerialize(using = UsuarioSerializer.class)
@CrossOrigin(origins = "*")
public class UsuarioCtrl {

    @Autowired
    private UsuarioServiceImpl userService;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;    
    
    @PostMapping
    public void signUp(@RequestBody Usuario user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.save(user);
    }
}
