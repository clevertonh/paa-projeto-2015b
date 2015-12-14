/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.controller;

import com.minhafazenda.model.Cidade;
import com.minhafazenda.model.CidadeModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author cleverton
 */
public final class CidadeController extends AbstractTableModel {

    //Cria o objeto do Model

    private final CidadeModel objModel;
    //Table model
    private ArrayList<Cidade> lstCidade = null;    
    private String[] column = {"Código", "Nome"};

    /*
     * Método construtor da classe
     */
    public CidadeController() {
        //Inicia o objeto model
        this.objModel = new CidadeModel();
        //Inicia a lista da lstColunas para o TableMOdel
        //setColunas(new String[]{"id", "descricao"});  
    }
    
    public String getColumnName(int columnIndex) {
        return column[columnIndex];
    }
    
    public void setColunas(String[] colunas) {
        this.column = colunas;
    }
    
    public Boolean insert(Cidade obj) {
        if (obj.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "A descrição da categoria não foi informada!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (obj.getNome().length() > 50) {
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
    
    public Boolean update(Cidade obj) {
        if (obj.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "A descrição da categoria não foi informada!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (obj.getNome().length() > 50) {
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
    
    public Boolean delete(Cidade obj) {        
        String msg = objModel.delete(obj);
        if (!msg.equals("")) {
            JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
    
    public ArrayList<Cidade> findByAll() {        
        this.lstCidade = objModel.findByAll();
        return this.lstCidade;
    }    
    
    public Cidade findById(int id){
        return objModel.findById(id);
    }
    
    public ArrayList<Cidade> findByDescricao(String descricao) {        
        this.lstCidade = objModel.findByDescricao(descricao);
        return this.lstCidade;
    }

    //Métodos implementados pela classe AbstractTableModel
    @Override
    public int getRowCount() {
        return lstCidade.size();
    }
    
    @Override
    public int getColumnCount() {
        return column.length;        
    }
    
    @Override
    public Object getValueAt(int linhaIndex, int colunaIndex) {
        
        Object value = null;        
        
        final Cidade c = (Cidade) lstCidade.get(linhaIndex);        
        
        switch (colunaIndex) {            
            case 0:                
                value = c.getId();
                break;            
            case 1:                
                value = c.getNome();                
                break;            
        }
        
        return value;
    }
}
