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
public class MfAuditoriaView  implements java.io.Serializable {
    
    private Integer id;
    private String usuario;
    private String chave_primaria_1;
    private String chave_primaria_2;
    private String acao;
    private Date data_hora;
    
    public MfAuditoriaView() {}
    
    public MfAuditoriaView(String acao) {
        this.acao = acao;
    }    

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
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the chave_primaria_1
     */
    public String getChave_primaria_1() {
        return chave_primaria_1;
    }

    /**
     * @param chave_primaria_1 the chave_primaria_1 to set
     */
    public void setChave_primaria_1(String chave_primaria_1) {
        this.chave_primaria_1 = chave_primaria_1;
    }

    /**
     * @return the chave_primaria_2
     */
    public String getChave_primaria_2() {
        return chave_primaria_2;
    }

    /**
     * @param chave_primaria_2 the chave_primaria_2 to set
     */
    public void setChave_primaria_2(String chave_primaria_2) {
        this.chave_primaria_2 = chave_primaria_2;
    }

    /**
     * @return the acao
     */
    public String getAcao() {
        return acao;
    }

    /**
     * @param acao the acao to set
     */
    public void setAcao(String acao) {
        this.acao = acao;
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
    
    
}
