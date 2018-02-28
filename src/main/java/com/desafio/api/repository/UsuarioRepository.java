/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.repository;

import com.desafio.api.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author deoprog
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    @Transactional(readOnly = true)
    Usuario findByUsername(String username);  
}
