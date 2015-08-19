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
    
    public Boolean insert(Categoria obj){
        if (obj.getDescricao().equals("")) {
            JOptionPane.showMessageDialog(null, "A descrição da categoria não foi informada!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if(obj.getDescricao().length() > 50){
            JOptionPane.showMessageDialog(null, "Tamanho máximo do campo foi atingido, verifique!", "Verifique", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else {
            String msg = objModel.insert(obj);
            if(!msg.equals("")){
                JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }else{
                return true;
            }
        }
    }
    
    public Boolean update(Categoria obj){
        if (obj.getDescricao().equals("")) {
            JOptionPane.showMessageDialog(null, "A descrição da categoria não foi informada!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if(obj.getDescricao().length() > 50){
            JOptionPane.showMessageDialog(null, "Tamanho máximo do campo foi atingido, verifique!", "Verifique", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else {
            String msg = objModel.update(obj);
            if(!msg.equals("")){
                JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }else{
                return true;
            }
        }
    }
    
    public Boolean delete(Categoria obj){    
        String msg = objModel.insert(obj);
        if(!msg.equals("")){
            JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            return true;
        }
    }
}
