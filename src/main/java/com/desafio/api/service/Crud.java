/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.service;

import java.util.List;

/**
 *
 * @author deoprog
 * @param <T>
 */
public interface Crud<T> {       
    T save(T entity);
    void update(T entity);
    void delete(Long id);
    T find(Long id);
    List<T> findAll();
}
