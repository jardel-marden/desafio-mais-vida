/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.model.repository;

import com.desafio.api.model.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author deoprog
 */
@Transactional(readOnly = true)
@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Medico findByNome(String nome);

    Medico findBySobreNome(String sobrenome);

    Medico findByNomeOrSobreNome(String nome, String sobrenome);
    
    Medico findByEmail(String email);
    
    Page<Medico> findByNome(Pageable pageable);
}
