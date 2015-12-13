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
public class ViewVacinaVencimento implements java.io.Serializable {
    
    private String vacina_descricao;
    private String vacina_modo_usaro;
    private Date vacina_data_vencimento;
    private int vacina_dose;
    private String animal_nome;
    private String animal_raca;

    /**
     * @return the vacina_descricao
     */
    public String getVacina_descricao() {
        return vacina_descricao;
    }

    /**
     * @param vacina_descricao the vacina_descricao to set
     */
    public void setVacina_descricao(String vacina_descricao) {
        this.vacina_descricao = vacina_descricao;
    }

    /**
     * @return the vacina_modo_usaro
     */
    public String getVacina_modo_usaro() {
        return vacina_modo_usaro;
    }

    /**
     * @param vacina_modo_usaro the vacina_modo_usaro to set
     */
    public void setVacina_modo_usaro(String vacina_modo_usaro) {
        this.vacina_modo_usaro = vacina_modo_usaro;
    }

    /**
     * @return the vacina_data_vencimento
     */
    public Date getVacina_data_vencimento() {
        return vacina_data_vencimento;
    }

    /**
     * @param vacina_data_vencimento the vacina_data_vencimento to set
     */
    public void setVacina_data_vencimento(Date vacina_data_vencimento) {
        this.vacina_data_vencimento = vacina_data_vencimento;
    }

    /**
     * @return the vacina_dose
     */
    public int getVacina_dose() {
        return vacina_dose;
    }

    /**
     * @param vacina_dose the vacina_dose to set
     */
    public void setVacina_dose(int vacina_dose) {
        this.vacina_dose = vacina_dose;
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

    
    
    
}
