package com.minhafazenda.model;
// Generated 13/08/2015 12:46:09 by Hibernate Tools 4.3.1



/**
 * Fotos generated by hbm2java
 */
public class Fotos  implements java.io.Serializable {


     private Integer id;
     private Animal animal;
     private String descricao;
     private String nomeArquivo;

    public Fotos() {
    }

    public Fotos(Animal animal, String descricao, String nomeArquivo) {
       this.animal = animal;
       this.descricao = descricao;
       this.nomeArquivo = nomeArquivo;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Animal getAnimal() {
        return this.animal;
    }
    
    public void setAnimal(Animal animal) {
        this.animal = animal;
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




}

