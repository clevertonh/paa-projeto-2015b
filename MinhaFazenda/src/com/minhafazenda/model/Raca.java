package com.minhafazenda.model;
// Generated 22/11/2015 11:05:37 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Raca generated by hbm2java
 */
public class Raca  implements java.io.Serializable {


     private Integer id;
     private String descricao;
     private String nomeArquivo;
     private Integer idUsuarioAlterou;
     private Set animals = new HashSet(0);

    public Raca() {
    }

	
    public Raca(String descricao) {
        this.descricao = descricao;
    }
    public Raca(String descricao, String nomeArquivo, Integer idUsuarioAlterou, Set animals) {
       this.descricao = descricao;
       this.nomeArquivo = nomeArquivo;
       this.idUsuarioAlterou = idUsuarioAlterou;
       this.animals = animals;
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
    public String getNomeArquivo() {
        return this.nomeArquivo;
    }
    
    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }
    public Integer getIdUsuarioAlterou() {
        return this.idUsuarioAlterou;
    }
    
    public void setIdUsuarioAlterou(Integer idUsuarioAlterou) {
        this.idUsuarioAlterou = idUsuarioAlterou;
    }
    public Set getAnimals() {
        return this.animals;
    }
    
    public void setAnimals(Set animals) {
        this.animals = animals;
    }




}


