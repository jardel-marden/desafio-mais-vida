/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.domain;


import com.desafio.api.enuns.EnumEspecialidade;
import com.desafio.api.enuns.EnumStatus;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
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
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author deoprog
 */
@Indexed
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect
@Entity
public class Medico extends General implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "seq_medico", sequenceName = "seq_medico", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_medico")
    private Long id;
    
    @NotBlank(message = "O nome não pode ser vazio.")
    @Size(min = 3, max = 200, message = "Nome deve conter entre 3 e 200 caracteres.")
    @NotNull(message = "O nome não pode ser tipo Nulo")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String nome;
    
    @NotBlank(message = "O sobrenome não pode ser vazio.")
    @Size(min = 3, max = 200, message = "Sobre-nome deve conter entre 3 e 200 caracteres.")
    @NotNull(message = "O sobrenome não pode ser tipo Nulo")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    @Column(name = "sobre_nome")
    private String sobrenome;
    
    @Email(message = "E-mail invalido.")
    @NotNull
    @Column(unique = true)
    private String email;
    
    private boolean ativo;
    
    @Enumerated(EnumType.STRING)
    @NotNull(message = "O status não foi atribuido")
    private EnumStatus status;
    
    @Enumerated(EnumType.STRING)
    @NotNull(message = "A especialidade não foi informada")
    private EnumEspecialidade especialidade;
    
    private String cidade;
    
    private String uf;
    
    private Long cidadeId;
    
    private Long ufId;    
}
