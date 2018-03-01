/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.repository;

import com.desafio.api.domain.Medico;
import com.desafio.api.enuns.EnumEspecialidade;
import com.desafio.api.enuns.EnumStatus;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author deoprog
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class MedicoRepositoryTest {

    @Autowired
    private MedicoRepository medicoRepository;

    private static final String NOME = "JARDEL";
    private static final String SOBRENOME = "MARDEN";    
    private static final String EMAIL_1 = "email_1@email.com";    

    @Before
    public void setUp() throws Exception {
        this.medicoRepository.save(new Medico(null, NOME, SOBRENOME, EMAIL_1, true, EnumStatus.OCULPADO, EnumEspecialidade.PEDIATRIA, null, null, null, null));
    }

    @After
    public void tearDown() {
        this.medicoRepository.deleteAll();
    }
    
    @Test
    public void testBuscarMedicoPorNome() {
        Medico medico = this.medicoRepository.findByNome(NOME);
        Assert.assertEquals(NOME, medico.getNome());
    }
    
    @Test
    public void testBuscarMedicoPorSobrenome() {
        Medico medico = this.medicoRepository.findBySobrenome(SOBRENOME);
        Assert.assertEquals(SOBRENOME, medico.getSobrenome());
    }
    
    @Test
    public void testBuscarMedicoPorNomeSobrenome() {
        Medico medico = this.medicoRepository.findByNomeOrSobrenome(NOME, SOBRENOME);
        Assert.assertNotNull(medico);
    }
    
    @Test
    public void testBuscarMedicoPorEmail() {
        Medico medico = this.medicoRepository.findByEmail(EMAIL_1);
        Assert.assertEquals(EMAIL_1, medico.getEmail());
    }
    
    @Test
    public void testBuscarMedicoPaginado() {
        PageRequest page = new PageRequest(0, 10);
        Page<Medico> medicos = this.medicoRepository.findAll(page);
        
        Assert.assertEquals(1, medicos.getTotalElements());
    }
        
}
