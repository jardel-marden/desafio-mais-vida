/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.service;

import com.desafio.api.domain.Medico;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author deoprog
 */
public interface MedicoService extends Crud<Medico> {

    /**
     * Retorna consulta de médicos por nome
     *
     * @param nome
     * @return Optional
     */
    Optional<Medico> findByNome(String nome);
    
    /**
     * Retorna consulta de médicos por Id
     *
     * @param id
     * @return Optional
     */
    Optional<Medico> findById(Long id);
    
    List<Medico> fuzzySearch(final String searchTearm);
}
