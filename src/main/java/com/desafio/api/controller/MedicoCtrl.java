/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.controller;

import com.desafio.api.model.Medico;
import com.desafio.api.model.service.MedicoService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author deoprog
 */
@Controller
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class MedicoCtrl {

    private static final Logger log = LoggerFactory.getLogger(Medico.class);

    @Autowired
    private MedicoService medicoService;

    public MedicoCtrl() {
    }

    @RequestMapping(value = "/medicos/", method = RequestMethod.GET)
    public ResponseEntity<List<Medico>> getMedicoAll() {
        return ResponseEntity.ok().body(medicoService.findAll());
    }

    @RequestMapping(value = "/medicos/", method = RequestMethod.POST)
    public Medico createMedico(@Valid @RequestBody Medico medico) {
        return medicoService.save(medico);
    }

    @RequestMapping(value = "/medicos/search/{nome}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Medico>> getMedicoByNome(@PathVariable(value = "nome") String nome) {
        log.info("Buscanco medicos por nome {}", nome);
        Optional<Medico> medicos = medicoService.findByNome(nome);

        if (!medicos.isPresent()) {
            log.info("Nenhum medico encontrado para {}", nome);
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(medicos);
    }
    
    @RequestMapping(value = "/medicos/view/{id}", method = RequestMethod.GET)
    public ResponseEntity<Medico> getMedicoById(@PathVariable(value = "id") Long id) {
        Medico medico = medicoService.find(id);

        if (medico == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(medico);
    }
    
    @RequestMapping(value = "/medicos/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Medico> updateMedico(@PathVariable(value = "id") Long id,
            @Valid @RequestBody Medico medico) {
        Medico findById = medicoService.find(id);

        if (findById == null) {
            return ResponseEntity.notFound().build();
        }

        medico = findById;

        Medico updatedMedico = medicoService.save(medico);
        return ResponseEntity.ok(updatedMedico);
    }
    
    @RequestMapping(value = "/medicos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteMedico(@PathVariable(value = "id") Long id) {
        Medico medico = medicoService.find(id);

        if (medico == null) {
            return ResponseEntity.notFound().build();
        }

        medicoService.delete(medico.getId());
        return ResponseEntity.ok().build();
    }
}