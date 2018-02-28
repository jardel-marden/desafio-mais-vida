/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.controller;

import com.desafio.api.enuns.EnumEspecialidade;
import com.desafio.api.domain.Medico;
import com.desafio.api.service.impl.MedicoServiceImpl;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author deoprog
 */
@Controller
@RequestMapping(value = "/medicos")
@BasePathAwareController
@CrossOrigin(origins = "*")
public class MedicoCtrl {

    private static final Logger log = LoggerFactory.getLogger(Medico.class);

    @Autowired
    private MedicoServiceImpl medicoService;

    @GetMapping
    public @ResponseBody
    List<Medico> getMedicoAll() {
        return medicoService.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> createMedico(@Valid @RequestBody Medico medico) {
        medicoService.save(medico);
        return ResponseEntity.ok().body(medico);
    }

    @GetMapping(value = "/view/{id}")
    public ResponseEntity<Medico> getMedicoById(@PathVariable(value = "id") Long id) {
        Medico medico = medicoService.find(id);

        if (medico == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(medico);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Medico> updateMedico(@PathVariable(value = "id") Long id, @Valid @RequestBody Medico medico) {
        if (medicoService.find(id) == null) {
            return ResponseEntity.notFound().build();
        }

        medicoService.update(medico);
        return ResponseEntity.ok(medico);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Medico> deleteMedico(@PathVariable(value = "id") Long id) {
        Medico medico = medicoService.find(id);
        if (medico == null) {
            return ResponseEntity.notFound().build();
        }        
        medicoService.delete(medico.getId());
        return ResponseEntity.ok(medico);
    }

    @GetMapping(value = "/especialidade")
    public ResponseEntity<Map<EnumEspecialidade, String>> getMedicoEspecialiadeAll() {
        Map<EnumEspecialidade, String> especialidades = new EnumMap<EnumEspecialidade, String>(EnumEspecialidade.class);

        for (EnumEspecialidade action : EnumEspecialidade.values()) {
            especialidades.put(action, action.getLabel());
        }

        return ResponseEntity.ok().body(especialidades);
    }
}
