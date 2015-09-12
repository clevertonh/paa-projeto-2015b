/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.conttroler;

import com.minhafazenda.model.Categoria;
import com.minhafazenda.model.CategoriaModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cleverton
 */
public final class CategoriaController extends AbstractTableModel {

    //Cria o objeto do Model

    private final CategoriaModel objModel;
    //Table model
    private ArrayList<Categoria> lstCategoria = null;    
    private String[] column = {"Código", "Descrição"};

    /*
     * Método construtor da classe
     */
    public CategoriaController() {
        //Inicia o objeto model
        this.objModel = new CategoriaModel();
        //Inicia a lista da lstColunas para o TableMOdel
        //setColunas(new String[]{"id", "descricao"});  
    }
    
    public String getColumnName(int columnIndex) {
        return column[columnIndex];
    }
    
    public void setColunas(String[] colunas) {
        this.column = colunas;
    }
    
    public Boolean insert(Categoria obj) {
        if (obj.getDescricao().equals("")) {
            JOptionPane.showMessageDialog(null, "A descrição da categoria não foi informada!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (obj.getDescricao().length() > 50) {
            JOptionPane.showMessageDialog(null, "Tamanho máximo do campo foi atingido, verifique!", "Verifique", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else {
            String msg = objModel.insert(obj);
            if (!msg.equals("")) {
                JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                return true;
            }
        }
    }
    
    public Boolean update(Categoria obj) {
        if (obj.getDescricao().equals("")) {
            JOptionPane.showMessageDialog(null, "A descrição da categoria não foi informada!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (obj.getDescricao().length() > 50) {
            JOptionPane.showMessageDialog(null, "Tamanho máximo do campo foi atingido, verifique!", "Verifique", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else {
            String msg = objModel.update(obj);
            if (!msg.equals("")) {
                JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                return true;
            }
        }
    }
    
    public Boolean delete(Categoria obj) {        
        String msg = objModel.insert(obj);
        if (!msg.equals("")) {
            JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
    
    public ArrayList<Categoria> findByAll() {        
        this.lstCategoria = objModel.findByAll();
        return this.lstCategoria;
    }    
    
    public Categoria findById(int id){
        return objModel.findById(id);
    }
    
    public ArrayList<Categoria> findByDescricao(String descricao) {        
        this.lstCategoria = objModel.findByDescricao(descricao);
        return this.lstCategoria;
    }

    //Métodos implementados pela classe AbstractTableModel
    @Override
    public int getRowCount() {
        return lstCategoria.size();
    }
    
    @Override
    public int getColumnCount() {
        return column.length;        
    }
    
    @Override
    public Object getValueAt(int linhaIndex, int colunaIndex) {
        
        Object value = null;        
        
        final Categoria c = (Categoria) lstCategoria.get(linhaIndex);        
        
        switch (colunaIndex) {            
            case 0:                
                value = c.getId();
                break;            
            case 1:                
                value = c.getDescricao();                
                break;            
        }
        
        return value;
    }
}
