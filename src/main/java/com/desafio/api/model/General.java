/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.Version;

/**
 *
 * @author deoprog
 */
@MappedSuperclass
public class General implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Version
    private int versao;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name="data_criacao")
    private Date dataCriacao;
   
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name="data_atualizacao")
    private Date dataAtualizacao;

    public int getVersao() {
        return versao;
    }

    public void setVersao(int versao) {
        this.versao = versao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @PreUpdate
    public void preUpdate() {
        this.dataAtualizacao = new Date();
    }

    @PrePersist
    public void prePersit() {
        this.dataCriacao = new Date();
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.versao;
        hash = 53 * hash + Objects.hashCode(this.dataCriacao);
        hash = 53 * hash + Objects.hashCode(this.dataAtualizacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final General other = (General) obj;
        if (this.versao != other.versao) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        return Objects.equals(this.dataAtualizacao, other.dataAtualizacao);
    }

    @Override
    public String toString() {
        return "General{" + "versao=" + versao + ", dataCriacao=" + dataCriacao + ", dataAtualizacao=" + dataAtualizacao + '}';
    }
        
}
