/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.controller;

import com.desafio.api.model.Usuario;
import com.desafio.api.model.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author deoprog
 */
@RestController
@RequestMapping("/api")
public class UsuarioCtrl {

    private final UsuarioRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsuarioCtrl(UsuarioRepository applicationUserRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @RequestMapping(value = "/usuarios/signup/", method = RequestMethod.POST)
    public void signUp(@RequestBody Usuario user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
