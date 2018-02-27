/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.model.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author deoprog
 */
public class Password {

    public static String encrypt(String password) {
        if (password == null && password.isEmpty()) {
            throw new NullPointerException("Password value not null");
        }
        return (new BCryptPasswordEncoder()).encode(password);
    }
}
