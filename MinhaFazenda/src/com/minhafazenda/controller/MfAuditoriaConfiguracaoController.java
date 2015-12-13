/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.controller;

import com.minhafazenda.model.MfAuditoriaConfiguracao;
import com.minhafazenda.model.MfAuditoriaConfiguracaoModel;
import com.minhafazenda.model.MfAuditoriaView;
import com.minhafazenda.util.ComboBoxItemString;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
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
        setColunas(new String[]{"id", "tabela", "trigger_delete", "trigger_insert","trigger_update", "view_auditoria", "view_auditoria_item"});
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
    
    
    public Boolean deleteByTabela(String tabela) { 
        String msg = objModel.deleteByTabela(tabela);
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
    
    public ArrayList<String> findByAllTabela(){
        return objModel.findByAllTabela();
    }
    
    public void desativaAuditoria(String nomeTabela){
        objModel.desativaAuditoria(nomeTabela);
    }
    
    
    public void criaProcedureViewAuditoria(String nomeTabela){
        objModel.criaProcedureViewAuditoria(nomeTabela);
    }
    
    public List<MfAuditoriaView> findAUditoria(String nomeTabela){
        return objModel.findAUditoria(nomeTabela);
    }
    
    public static ComboBoxModel carregaComboTabela(){  
        ArrayList<String> lst = null;
        String obj = new String();
        ComboBoxModel bRetorno;  
        Vector v = new Vector();          
        
        lst = new MfAuditoriaConfiguracaoController().findByAllTabela();
        
        v.add(null);  
        
        for (Object item : lst) {  
            obj = (String)item;  
            v.add(new ComboBoxItemString(obj,obj));  
        }  
        
        bRetorno = new DefaultComboBoxModel(v);  
  
        return bRetorno;  
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
