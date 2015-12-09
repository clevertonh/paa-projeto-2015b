/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.controller;

import com.minhafazenda.model.MfAuditoriaViewItem;
import com.minhafazenda.model.MfAuditoriaViewItemModel;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cleverton
 */
public class MfAuditoriaConfiguracaoViewItemController extends AbstractTableModel {

    //private final MfAuditoriaConfiguracaoModel objModel;
    private final MfAuditoriaViewItemModel objModel;
    private ArrayList<MfAuditoriaViewItem> lst = null;
    private String[] lstColunas = null;
    private String[] column = {"Item", "Campo", "Valor Antigo", "Valor Novo"};
    
    public MfAuditoriaConfiguracaoViewItemController() {
        this.objModel = new MfAuditoriaViewItemModel();
        setColunas(new String[]{"id_auditoria_item", "campo", "valor_antigo","valor_novo"});
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
    
    public ArrayList<MfAuditoriaViewItem> findByAll(Integer idAutoria, String nomeTabela) {
        this.lst = (ArrayList<MfAuditoriaViewItem>) objModel.findAUditoria(idAutoria, nomeTabela);
        return this.lst;
    }
    
    public ArrayList<MfAuditoriaViewItem> findByDescricao(Integer idAutoria, String nomeTabela, String descricao) {
        this.lst = (ArrayList<MfAuditoriaViewItem>) objModel.findByDescricao(idAutoria, nomeTabela, descricao);
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

        final MfAuditoriaViewItem c = (MfAuditoriaViewItem) lst.get(linhaIndex);

        switch (colunaIndex) {
            case 0:
                value = c.getId_auditoria_item();
                break;
            case 1:
                value = c.getCampo();
                break;
            case 2:
                value = c.getValor_antigo();
                break;
            case 3:
                value = c.getValor_novo();
                break;
        }

        return value;
    }
    
}
