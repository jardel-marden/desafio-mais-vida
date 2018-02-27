/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.model.service;

import com.desafio.api.model.Medico;
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
}
