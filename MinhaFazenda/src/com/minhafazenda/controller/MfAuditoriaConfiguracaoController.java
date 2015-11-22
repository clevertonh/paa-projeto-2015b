/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.controller;

import com.minhafazenda.model.MfAuditoriaConfiguracao;
import com.minhafazenda.model.MfAuditoriaConfiguracaoModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cleverton
 */
public class MfAuditoriaConfiguracaoController extends AbstractTableModel {

    private final MfAuditoriaConfiguracaoModel objModel;
    private ArrayList<MfAuditoriaConfiguracao> lst = null;
    private String[] lstColunas = null;
    private String[] column = {"Código", "Tabela", "Trigger Delete", "Trigger Insert","Trigger Update", "View Auditoria", "View Auditoria Item"};

    public MfAuditoriaConfiguracaoController() {
        this.objModel = new MfAuditoriaConfiguracaoModel();
    }    
    
    public String getColumnName(int columnIndex) {
        return column[columnIndex];
    }

    public String[] getColunas() {
        return lstColunas;
    }

    public void setColunas(String[] colunas) {
        this.lstColunas = colunas;
    }
    
    public Boolean insert(MfAuditoriaConfiguracao obj) {
        String msg = objModel.insert(obj);
        if (!msg.equals("")) {
            JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }    
    
    public Boolean update(MfAuditoriaConfiguracao obj) {
        String msg = objModel.update(obj);
        if (!msg.equals("")) {
            JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }    
    
    public Boolean delete(MfAuditoriaConfiguracao obj) {
        String msg = objModel.delete(obj);
        if (!msg.equals("")) {
            JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }    
    
    public ArrayList<MfAuditoriaConfiguracao> findByAll() {
        this.lst = objModel.findByAll();
        return this.lst;
    }
    
    public MfAuditoriaConfiguracao findById(int id){
        return objModel.findById(id);
    }   
    
    public ArrayList<MfAuditoriaConfiguracao> findByDescricao(String descricao) {
        this.lst = objModel.findByDescricao(descricao);
        return this.lst;
    }    

    //Métodos implementados pela classe AbstractTableModel
    @Override
    public int getRowCount() {
        return lst.size();
    }

    @Override
    public int getColumnCount() {
        return getColunas().length;
    }

    @Override
    public Object getValueAt(int linhaIndex, int colunaIndex) {

        Object value = null;

        final MfAuditoriaConfiguracao c = (MfAuditoriaConfiguracao) lst.get(linhaIndex);

        switch (colunaIndex) {
            case 0:
                value = c.getId();
                break;
            case 1:
                value = c.getTabela();
                break;
            case 2:
                value = c.getTriggerDelete();
                break;
            case 3:
                value = c.getTriggerInsert();
                break;
            case 4:
                value = c.getTriggerUpdate();
                break;
            case 5:
                value = c.getViewAuditoria();
                break;
            case 6:
                value = c.getViewAuditoriaItem();
                break;
        }

        return value;
    }
}
