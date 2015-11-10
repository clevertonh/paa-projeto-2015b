/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.controller;

import com.minhafazenda.model.UsuarioTipo;
import com.minhafazenda.model.UsuarioTipoModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author cleverton
 */
public final class UsuarioTipoController extends AbstractTableModel {

    //Cria o objeto do Model

    private final UsuarioTipoModel objModel;
    //Table model
    private ArrayList<UsuarioTipo> lstUsuarioTipo = null;    
    private String[] column = {"Código", "Descrição"};

    /*
     * Método construtor da classe
     */
    public UsuarioTipoController() {
        //Inicia o objeto model
        this.objModel = new UsuarioTipoModel();
        //Inicia a lista da lstColunas para o TableMOdel
        //setColunas(new String[]{"id", "descricao"});  
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return column[columnIndex];
    }
    
    public void setColunas(String[] colunas) {
        this.column = colunas;
    }
    
    public Boolean insert(UsuarioTipo obj) {
        if (obj.getDescricao().equals("")) {
            JOptionPane.showMessageDialog(null, "A descrição não foi informada!", "Erro", JOptionPane.ERROR_MESSAGE);
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
    
    public Boolean update(UsuarioTipo obj) {
        if (obj.getDescricao().equals("")) {
            JOptionPane.showMessageDialog(null, "A descrição não foi informada!", "Erro", JOptionPane.ERROR_MESSAGE);
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
    
    public Boolean delete(UsuarioTipo obj) {        
        String msg = objModel.delete(obj);
        if (!msg.equals("")) {
            JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
    
    public ArrayList<UsuarioTipo> findByAll() {        
        this.lstUsuarioTipo = objModel.findByAll();
        return this.lstUsuarioTipo;
    }    
    
    public UsuarioTipo findById(int id){
        return objModel.findById(id);
    }
    
    public ArrayList<UsuarioTipo> findByDescricao(String descricao) {        
        this.lstUsuarioTipo = objModel.findByDescricao(descricao);
        return this.lstUsuarioTipo;
    }

    //Métodos implementados pela classe AbstractTableModel
    @Override
    public int getRowCount() {
        return lstUsuarioTipo.size();
    }
    
    @Override
    public int getColumnCount() {
        return column.length;        
    }
    
    @Override
    public Object getValueAt(int linhaIndex, int colunaIndex) {
        
        Object value = null;        
        
        final UsuarioTipo ut = (UsuarioTipo) lstUsuarioTipo.get(linhaIndex);        
            
        switch (colunaIndex) {            
            case 0:                
                value = ut.getId();
                break;            
            case 1:                
                value = ut.getDescricao();                
                break;            
        }
        
        return value;
    }
}
