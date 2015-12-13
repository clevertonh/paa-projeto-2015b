/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.util;

/**
 *
 * @author cleverton
 */
public class UsuarioLogado {
    private static Integer id;
    private static Integer administrador;

    /**
     * @return the id
     */
    public static Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public static void setId(Integer id) {
        UsuarioLogado.id = id;
    }

    /**
     * @return the administrador
     */
    public static Integer getAdministrador() {
        return administrador;
    }

    /**
     * @param aAdministrador the administrador to set
     */
    public static void setAdministrador(Integer aAdministrador) {
        administrador = aAdministrador;
    }
    
    
    
    
}
