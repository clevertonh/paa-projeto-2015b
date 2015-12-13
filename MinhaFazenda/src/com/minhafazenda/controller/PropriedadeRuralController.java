/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.controller;

import com.minhafazenda.model.Cidade;
import com.minhafazenda.model.CidadeModel;
import com.minhafazenda.model.PropriedadeRural;
import com.minhafazenda.model.PropriedadeRuralModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author cleverton
 */
public final class PropriedadeRuralController extends AbstractTableModel {

    //Cria o objeto do Model

    private final PropriedadeRuralModel objModel;
    //Table model
    private ArrayList<PropriedadeRural> lstPropriedadeRural = null;    
    private String[] column = {"Código", "Descrição", "Endereço", "Tamanho", "CEP","Cidade"};

    /*
     * Método construtor da classe
     */
    public PropriedadeRuralController() {
        //Inicia o objeto model
        this.objModel = new PropriedadeRuralModel();
        //Inicia a lista da lstColunas para o TableMOdel
        //setColunas(new String[]{"id", "descricao"});  
    }
    
    public String getColumnName(int columnIndex) {
        return column[columnIndex];
    }
    
    public void setColunas(String[] colunas) {
        this.column = colunas;
    }
    
    public Boolean insert(PropriedadeRural obj) {
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
    
    public Boolean update(PropriedadeRural obj) {
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
    
    public Boolean delete(PropriedadeRural obj) {        
        String msg = objModel.delete(obj);
        if (!msg.equals("")) {
            JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
    
    public ArrayList<PropriedadeRural> findByAll() {        
        this.lstPropriedadeRural = objModel.findByAll();
        return this.lstPropriedadeRural;
    }    
    
    public PropriedadeRural findById(int id){
        return objModel.findById(id);
    }
    
    public ArrayList<PropriedadeRural> findByDescricao(String descricao) {        
        this.lstPropriedadeRural = objModel.findByDescricao(descricao);
        return this.lstPropriedadeRural;
    }

    //Métodos implementados pela classe AbstractTableModel
    @Override
    public int getRowCount() {
        return lstPropriedadeRural.size();
    }
    
    @Override
    public int getColumnCount() {
        return column.length;        
    }
    
    @Override
    public Object getValueAt(int linhaIndex, int colunaIndex) {
        
        Object value = null;        
        
        final PropriedadeRural c = (PropriedadeRural) lstPropriedadeRural.get(linhaIndex);        
        final Cidade cid = c.getCidade();
        
        switch (colunaIndex) {            
            case 0:                
                value = c.getId();
                break;            
            case 1:                
                value = c.getDescricao();                
                break;            
            case 2:                
                value = c.getEndereco();                
                break;            
            case 3:                
                value = c.getTamanho();                
                break;            
            case 4:                
                value = c.getCep();                
                break;            
            case 5:                
                value = new CidadeModel().findById(cid.getId()).getNome();
                break;            
        }
        
        return value;
    }
}
