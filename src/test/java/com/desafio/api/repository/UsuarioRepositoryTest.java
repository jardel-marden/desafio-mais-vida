/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.repository;

import com.desafio.api.domain.Usuario;
import java.util.Optional;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author deoprog
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Before
    public void setUp() throws Exception {
        this.usuarioRepository.save(new Usuario(1l, USERNAME, bCryptPasswordEncoder.encode(PASSWORD)));
    }

    @After
    public void tearDown() {
        this.usuarioRepository.deleteAll();
    }
    
    @Test
    public void testBuscarUsarioPorUsername() {
        Usuario usuario = this.usuarioRepository.findByUsername("admin2");
        Assert.assertNull(usuario);
    }
    
    @Test
    public void testLogin() {
        Optional<Usuario> usuario = this.usuarioRepository.findByUsernameAndPassword(USERNAME, bCryptPasswordEncoder.encode(PASSWORD));
        Assert.assertNotNull(usuario);
    }
    
    @Test
    public void testBuscarUsuarioPaginado() {
        PageRequest page = new PageRequest(0, 10);
        Page<Usuario> usuarios = this.usuarioRepository.findAll(page);
        
        Assert.assertEquals(1, usuarios.getTotalElements());
    }
        
}
