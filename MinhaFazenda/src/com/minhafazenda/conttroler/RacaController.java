/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.conttroler;

import com.minhafazenda.model.Raca;
import com.minhafazenda.model.RacaModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cleverton
 */
public final class RacaController extends AbstractTableModel {

    //Cria o objeto do Model

    private final RacaModel objModel;
    //Table model
    private ArrayList<Raca> lstRaca = null;
    private String[] lstColunas = null;
    private String[] column = {"Código", "Descrição", "Nome Arquivo"};

    /*
     * Método construtor da classe
     */
    public RacaController() {
        //Inicia o objeto model
        this.objModel = new RacaModel();
        //Inicia a lista da lstColunas para o TableMOdel
        setColunas(new String[]{"id", "descricao", "nome_arquivo"});

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

    public Boolean insert(Raca obj) {
        if (obj.getDescricao().equals("")) {
            JOptionPane.showMessageDialog(null, "A descrição da raça não foi informada!", "Erro", JOptionPane.ERROR_MESSAGE);
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

    public Boolean update(Raca obj) {
        if (obj.getDescricao().equals("")) {
            JOptionPane.showMessageDialog(null, "A descrição da raça não foi informada!", "Erro", JOptionPane.ERROR_MESSAGE);
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

    public Boolean delete(Raca obj) {
        String msg = objModel.insert(obj);
        if (!msg.equals("")) {
            JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<Raca> findByAll() {
        this.lstRaca = objModel.findByAll();
        return this.lstRaca;
    }

    public ArrayList<Raca> findByAll(String condicao) {
        this.lstRaca = objModel.findByAll(condicao);
        return this.lstRaca;
    }

    //Métodos implementados pela classe AbstractTableModel
    @Override
    public int getRowCount() {
        return lstRaca.size();
    }

    @Override
    public int getColumnCount() {
        return getColunas().length;
    }

    @Override
    public Object getValueAt(int linhaIndex, int colunaIndex) {

        Object value = null;

        final Raca c = (Raca) lstRaca.get(linhaIndex);

        switch (colunaIndex) {
            case 0:
                value = c.getId();
                break;
            case 1:
                value = c.getDescricao();
                break;
            case 2:
                value = c.getNomeArquivo();
                break;
        }

        return value;
    }
}
