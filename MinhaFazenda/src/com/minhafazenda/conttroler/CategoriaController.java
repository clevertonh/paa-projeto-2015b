/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.conttroler;

import com.minhafazenda.model.Categoria;
import com.minhafazenda.model.CategoriaModel;
import javax.swing.JOptionPane;

/**
 *
 * @author cleverton
 */
public class CategoriaController {
    private CategoriaModel objModel;
    
    public CategoriaController(){
        this.objModel = new CategoriaModel();
    }
    
    public void insert(Categoria obj){
        if (obj.getDescricao().equals("")) {
            JOptionPane.showMessageDialog(null, "A descrição da categoria não foi informada!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            String msg = objModel.insert(obj);
            if(!msg.equals("")){
                JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
