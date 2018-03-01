/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.repository;

import com.desafio.api.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author deoprog
 */
@Transactional(readOnly = true)
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Medico findByNome(String nome);

    Medico findBySobrenome(String sobrenome);
    
    Medico findByNomeOrSobrenome(String nome, String sobrenome);

    Medico findByEmail(String email);

}
