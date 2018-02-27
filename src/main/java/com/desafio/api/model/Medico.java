/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.model;


import com.desafio.api.enuns.EnumEspecialidade;
import com.desafio.api.enuns.EnumStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author deoprog
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties(value = {"getDataCriacao", "getDataAtualizacao", "getVersao"}, allowGetters = true)
public class Medico extends General implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "seq_medico", sequenceName = "seq_medico", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_medico")
    private Long id;
    
    @NotEmpty(message = "O nome não pode ser vazio.")
    @Length(min = 3, max = 200, message = "Nome deve conter entre 3 e 200 caracteres.")
    @NotNull(message = "O nome não pode ser tipo Nulo")
    private String nome;
    
    @NotEmpty(message = "O sobre-nome não pode ser vazio.")
    @Length(min = 3, max = 200, message = "Sobre-nome deve conter entre 3 e 200 caracteres.")
    @NotNull(message = "O sobre-nome não pode ser tipo Nulo")
    @Column(name = "sobre_nome")
    private String sobreNome;
    
    @Email(message = "E-mail informado invalido.")
    @NotNull
    private String email;
    
    private boolean ativo;
    
    @Enumerated(EnumType.STRING)
    private EnumStatus status;
    
    @Enumerated(EnumType.STRING)
    private EnumEspecialidade especialidade;
    
    private String cidade;
    
    private String uf;
    
    private Long cidadeId;
    
    private Long ufId;    
}
