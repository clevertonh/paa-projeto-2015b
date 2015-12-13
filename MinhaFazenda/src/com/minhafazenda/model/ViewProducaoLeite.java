/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.model;

import java.util.Date;

/**
 *
 * @author cleverton
 */
public class ViewProducaoLeite implements java.io.Serializable {

    private Integer id;
    private Date data_hora;
    private String animal_nome;
    private String animal_raca;
    private String animal_categoria;
    private String animal_grau_sangue;
    private int quantidade_ml;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the data_hora
     */
    public Date getData_hora() {
        return data_hora;
    }

    /**
     * @param data_hora the data_hora to set
     */
    public void setData_hora(Date data_hora) {
        this.data_hora = data_hora;
    }

    /**
     * @return the animal_nome
     */
    public String getAnimal_nome() {
        return animal_nome;
    }

    /**
     * @param animal_nome the animal_nome to set
     */
    public void setAnimal_nome(String animal_nome) {
        this.animal_nome = animal_nome;
    }

    /**
     * @return the animal_raca
     */
    public String getAnimal_raca() {
        return animal_raca;
    }

    /**
     * @param animal_raca the animal_raca to set
     */
    public void setAnimal_raca(String animal_raca) {
        this.animal_raca = animal_raca;
    }

    /**
     * @return the animal_categoria
     */
    public String getAnimal_categoria() {
        return animal_categoria;
    }

    /**
     * @param animal_categoria the animal_categoria to set
     */
    public void setAnimal_categoria(String animal_categoria) {
        this.animal_categoria = animal_categoria;
    }

    /**
     * @return the animal_grau_sangue
     */
    public String getAnimal_grau_sangue() {
        return animal_grau_sangue;
    }

    /**
     * @param animal_grau_sangue the animal_grau_sangue to set
     */
    public void setAnimal_grau_sangue(String animal_grau_sangue) {
        this.animal_grau_sangue = animal_grau_sangue;
    }

    /**
     * @return the quantidade_ml
     */
    public int getQuantidade_ml() {
        return quantidade_ml;
    }

    /**
     * @param quantidade_ml the quantidade_ml to set
     */
    public void setQuantidade_ml(int quantidade_ml) {
        this.quantidade_ml = quantidade_ml;
    }
    
    
    
}
