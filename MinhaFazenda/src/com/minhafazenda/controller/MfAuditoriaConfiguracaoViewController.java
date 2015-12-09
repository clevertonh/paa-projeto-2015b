/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.controller;

import com.minhafazenda.model.MfAuditoriaConfiguracaoModel;
import com.minhafazenda.model.MfAuditoriaView;
import com.minhafazenda.model.MfAuditoriaViewModel;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cleverton
 */
public class MfAuditoriaConfiguracaoViewController extends AbstractTableModel {

    //private final MfAuditoriaConfiguracaoModel objModel;
    private final MfAuditoriaViewModel objModel;
    private ArrayList<MfAuditoriaView> lst = null;
    private String[] lstColunas = null;
    private String[] column = {"Código", "Usuario", "Chave Primaria 1", "Chave Primaria 2","Ação", "Data"};
    
    public MfAuditoriaConfiguracaoViewController() {
        this.objModel = new MfAuditoriaViewModel();
        setColunas(new String[]{"id", "usuario", "chave_primaria_1", "chave_primaria_2","acao", "data_hora"});
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
    
    public ArrayList<MfAuditoriaView> findByAll(String nomeTabela) {
        this.lst = (ArrayList<MfAuditoriaView>) objModel.findAUditoria(nomeTabela);
        return this.lst;
    }
    
    public ArrayList<MfAuditoriaView> findByDescricao(String nomeTabela, String descricao) {
        this.lst = (ArrayList<MfAuditoriaView>) objModel.findByDescricao(nomeTabela, descricao);
        return this.lst;
    }        
    
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

        final MfAuditoriaView c = (MfAuditoriaView) lst.get(linhaIndex);

        switch (colunaIndex) {
            case 0:
                value = c.getId();
                break;
            case 1:
                value = c.getUsuario();
                break;
            case 2:
                value = c.getChave_primaria_1();
                break;
            case 3:
                value = c.getChave_primaria_2();
                break;
            case 4:
                value = c.getAcao();
                break;
            case 5:
                value = c.getData_hora();
                break;

        }

        return value;
    }
    
}
