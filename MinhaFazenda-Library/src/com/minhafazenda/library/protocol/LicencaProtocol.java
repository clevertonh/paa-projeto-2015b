/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.library.protocol;

import java.io.Serializable;

/**
 *
 * @author cleverton
 */
public class LicencaProtocol implements Serializable{

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
    public enum StatusType {
        SOLICITA_LICENCA    /* Usuário está solicitando uma licença para abrir o sistema */
        ,LICENCA_FORNECIDA  /* Uma licenca foi fornecida para o usuario */
        ,SEM_LICENCA        /* Não existe uma licenca livre para o usuário */
        ,SISTEMA_BLOQUEADO  /* O sistema foi bloqueado pela Software House */
        ,LIBERAR_LICENCA    /* O usuário solicita a liberação da licenca */
        ,MANTEM_LICENCA
        ,LICENCA_RENOVADA
    }    
    
    private String ip;
    private String host;
    private Boolean liberadoAcesso;    
    private StatusType status;
    
    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the liberadoAcesso
     */
    public Boolean getLiberadoAcesso() {
        return liberadoAcesso;
    }

    /**
     * @param liberadoAcesso the liberadoAcesso to set
     */
    public void setLiberadoAcesso(Boolean liberadoAcesso) {
        this.liberadoAcesso = liberadoAcesso;
    }
    
}
