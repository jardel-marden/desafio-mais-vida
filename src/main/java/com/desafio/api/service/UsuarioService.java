/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.service;

import com.desafio.api.domain.Usuario;
import java.util.Optional;

/**
 *
 * @author deoprog
 */
public interface UsuarioService extends Crud<Usuario>{

    /**
     * Retorna consulta de usuario por username
     *
     * @param username
     * @return Optional
     */
    Optional<Usuario> findByUsername(String username);
}
