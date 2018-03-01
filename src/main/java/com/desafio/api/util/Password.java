/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author deoprog
 */
public class Password {
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public String encode(String password) {
        return bCryptPasswordEncoder.encode(password);
    }
}
