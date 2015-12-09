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
public class ComboBoxItemString {
    private final String id;
    private final String descricao;

    public ComboBoxItemString(String id, String description)
    {
        this.id = id;
        this.descricao = description;
    }

    public String getId()
    {
        return id;
    }

    public String getDescription()
    {
        return descricao;
    }

    public String toString()
    {
        return descricao;
    }   
}
