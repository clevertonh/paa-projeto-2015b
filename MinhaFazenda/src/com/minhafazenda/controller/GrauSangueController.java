/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.controller;

import com.minhafazenda.model.GrauSangue;
import com.minhafazenda.model.GrauSangueModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author cleverton
 */
public final class GrauSangueController extends AbstractTableModel {

    //Cria o objeto do Model

    private final GrauSangueModel objModel;
    //Table model
    private ArrayList<GrauSangue> lstGrauSangue = null;    
    private String[] column = {"Código", "Descrição"};

    /*
     * Método construtor da classe
     */
    public GrauSangueController() {
        //Inicia o objeto model
        this.objModel = new GrauSangueModel();
        //Inicia a lista da lstColunas para o TableMOdel
        //setColunas(new String[]{"id", "descricao"});  
    }
    
    public String getColumnName(int columnIndex) {
        return column[columnIndex];
    }
    
    public void setColunas(String[] colunas) {
        this.column = colunas;
    }
    
    public Boolean insert(GrauSangue obj) {
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
    
    public Boolean update(GrauSangue obj) {
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
    
    public Boolean delete(GrauSangue obj) {        
        String msg = objModel.delete(obj);
        if (!msg.equals("")) {
            JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
    
    public ArrayList<GrauSangue> findByAll() {        
        this.lstGrauSangue = objModel.findByAll();
        return this.lstGrauSangue;
    }    
    
    public GrauSangue findById(int id){
        return objModel.findById(id);
    }
    
    public ArrayList<GrauSangue> findByDescricao(String descricao) {        
        this.lstGrauSangue = objModel.findByDescricao(descricao);
        return this.lstGrauSangue;
    }

    //Métodos implementados pela classe AbstractTableModel
    @Override
    public int getRowCount() {
        return lstGrauSangue.size();
    }
    
    @Override
    public int getColumnCount() {
        return column.length;        
    }
    
    @Override
    public Object getValueAt(int linhaIndex, int colunaIndex) {
        
        Object value = null;        
        
        final GrauSangue c = (GrauSangue) lstGrauSangue.get(linhaIndex);        
        
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
