/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.service.impl;

import com.desafio.api.domain.Medico;
import com.desafio.api.repository.MedicoRepository;
import com.desafio.api.service.MedicoService;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author deoprog
 */
@Service
public class MedicoServiceImpl implements MedicoService {

    private static final Logger log = LoggerFactory.getLogger(Medico.class);

    @Autowired
    private MedicoRepository medicoRepository;

    private final EntityManager entityManager;

    @Autowired
    public MedicoServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Medico> findByNome(String nome) {
        log.info("Buscando nome do medico {}", nome);
        return Optional.ofNullable(this.medicoRepository.findByNome(nome));
    }

    @Override
    @Cacheable("medicoPorId")
    public Optional<Medico> findById(Long id) {
        return Optional.ofNullable(this.medicoRepository.findOne(id));
    }

    @Override
    public Medico save(Medico entity) {
        log.info("Persistir medico: {}", entity);
        return this.medicoRepository.save(entity);
    }

    @Override
    @CachePut("medicoPorId")
    public void update(Medico entity) {
        this.medicoRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        this.medicoRepository.delete(id);
    }

    @Override
    public List<Medico> findAll() {
        return this.medicoRepository.findAll();
    }

    @Override
    public Medico find(Long id) {
        return this.medicoRepository.findOne(id);
    }

    public void initializeHibernate() {
        try {
            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(this.entityManager);
            fullTextEntityManager.createIndexer().startAndWait();
        } catch (InterruptedException ex) {
            java.util.logging.Logger.getLogger(MedicoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Medico> fuzzySearch(String searchTearm) {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(this.entityManager);
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Medico.class).get();
        
        Query luceneQuery = queryBuilder.keyword().fuzzy().withEditDistanceUpTo(1).withEditDistanceUpTo(1)
                .onFields("nome","sobrenome").matching(searchTearm).createQuery();
        
        javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, Medico.class);
        
        List<Medico> medicos = null;
        try {
            medicos = jpaQuery.getResultList();
        } catch (NoResultException e) {
        }
        
        return medicos;
    }

}
