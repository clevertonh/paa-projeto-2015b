/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.library.protocol;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author cleverton
 */
public class LicencaProtocol implements Serializable{

    public boolean equals(LicencaProtocol obj) {
        if(obj.getChave() == getChave())
            return true;
        else
            return false;
    }
    
    public enum StatusType {
        SOLICITA_LICENCA    /* Usuário está solicitando uma licença para abrir o sistema */
        ,LICENCA_FORNECIDA  /* Uma licenca foi fornecida para o usuario */
        ,SEM_LICENCA        /* Não existe uma licenca livre para o usuário */
        ,SISTEMA_BLOQUEADO  /* O sistema foi bloqueado pela Software House */
        ,LIBERAR_LICENCA    /* O usuário solicita a liberação da licenca */
        ,MANTEM_LICENCA
        ,LICENCA_RENOVADA
    }    
    
    private Date dataHora;
    private StatusType status;
    private String chave;
    
    /**
     * @return the dataHora
     */
    public Date getDataHora() {
        return dataHora;
    }

    /**
     * @param dataHora the dataHora to set
     */
    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }    
    
    /**
     * @return the status
     */
    public StatusType getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(StatusType status) {
        this.status = status;
    }

    /**
     * @return the chave
     */
    public String getChave() {
        return chave;
    }

    /**
     * @param chave the chave to set
     */
    public void setChave(String chave) {
        this.chave = chave;
    }
    
    //http://stackoverflow.com/questions/8520808/how-to-remove-specific-object-from-arraylist
//    public boolean equals(Object obj) {
//    if (obj == null) return false;
//    if (obj == this) return true;
//    if (!(obj instance of LicencaProtocol)) return false;
//    ArrayTest o = (ArrayTest) obj;
//    return o.i == this.i;
//    }
}
