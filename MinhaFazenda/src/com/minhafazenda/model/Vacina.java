package com.minhafazenda.model;
// Generated 13/08/2015 12:46:09 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Vacina generated by hbm2java
 */
public class Vacina  implements java.io.Serializable {


     private Integer id;
     private String descricao;
     private String modoUso;
     private String indicacoes;
     private String vacinacol;
     private Integer diasValidade;
     private Set vacinaAnimals = new HashSet(0);

    public Vacina() {
    }

    public Vacina(String descricao, String modoUso, String indicacoes, String vacinacol, Integer diasValidade, Set vacinaAnimals) {
       this.descricao = descricao;
       this.modoUso = modoUso;
       this.indicacoes = indicacoes;
       this.vacinacol = vacinacol;
       this.diasValidade = diasValidade;
       this.vacinaAnimals = vacinaAnimals;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getModoUso() {
        return this.modoUso;
    }
    
    public void setModoUso(String modoUso) {
        this.modoUso = modoUso;
    }
    public String getIndicacoes() {
        return this.indicacoes;
    }
    
    public void setIndicacoes(String indicacoes) {
        this.indicacoes = indicacoes;
    }
    public String getVacinacol() {
        return this.vacinacol;
    }
    
    public void setVacinacol(String vacinacol) {
        this.vacinacol = vacinacol;
    }
    public Integer getDiasValidade() {
        return this.diasValidade;
    }
    
    public void setDiasValidade(Integer diasValidade) {
        this.diasValidade = diasValidade;
    }
    public Set getVacinaAnimals() {
        return this.vacinaAnimals;
    }
    
    public void setVacinaAnimals(Set vacinaAnimals) {
        this.vacinaAnimals = vacinaAnimals;
    }




}


