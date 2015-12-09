/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.model;

/**
 *
 * @author cleverton
 */
public class MfAuditoriaViewItem  implements java.io.Serializable {
    
    private Integer id_auditoria_item;
    private Integer id;
    private String campo;
    private String valor_antigo;
    private String valor_novo;
    
    
    public MfAuditoriaViewItem() {}

    /**
     * @return the id_auditoria_item
     */
    public Integer getId_auditoria_item() {
        return id_auditoria_item;
    }

    /**
     * @param id_auditoria_item the id_auditoria_item to set
     */
    public void setId_auditoria_item(Integer id_auditoria_item) {
        this.id_auditoria_item = id_auditoria_item;
    }

    /**
     * @return the id_auditoria
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id_auditoria to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the campo
     */
    public String getCampo() {
        return campo;
    }

    /**
     * @param campo the campo to set
     */
    public void setCampo(String campo) {
        this.campo = campo;
    }

    /**
     * @return the valor_antigo
     */
    public String getValor_antigo() {
        return valor_antigo;
    }

    /**
     * @param valor_antigo the valor_antigo to set
     */
    public void setValor_antigo(String valor_antigo) {
        this.valor_antigo = valor_antigo;
    }

    /**
     * @return the valor_novo
     */
    public String getValor_novo() {
        return valor_novo;
    }

    /**
     * @param valor_novo the valor_novo to set
     */
    public void setValor_novo(String valor_novo) {
        this.valor_novo = valor_novo;
    }
}
