/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.controller;

import com.minhafazenda.model.Animal;
import com.minhafazenda.model.AnimalModel;
import com.minhafazenda.model.Categoria;
import com.minhafazenda.model.CategoriaModel;
import com.minhafazenda.model.GrauSangue;
import com.minhafazenda.model.GrauSangueModel;
import com.minhafazenda.model.ProducaoLeite;
import com.minhafazenda.model.ProducaoLeiteModel;
import com.minhafazenda.model.PropriedadeRural;
import com.minhafazenda.model.PropriedadeRuralModel;
import com.minhafazenda.model.Raca;
import com.minhafazenda.model.RacaModel;
import com.minhafazenda.util.Formatacao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cleverton
 */
public final class ProducaoLeiteController extends AbstractTableModel
{

    //Cria o objeto do Model
    private final ProducaoLeiteModel objModel;
    private Formatacao formatacao;
    //Table model
    private ArrayList<ProducaoLeite> lstProducaoLeite = null;
    private String[] column = {"Código", "Data", "Cód. Animal", "Animal", "Quantidade"};

    /*
     * Método construtor da classe
     */
    public ProducaoLeiteController()
    {
        //Inicia o objeto model
        this.objModel = new ProducaoLeiteModel();
        //Inicia a lista da lstColunas para o TableMOdel
        //setColunas(new String[]{"id", "descricao"});  
    }

    public String getColumnName(int columnIndex)
    {
        return column[columnIndex];
    }

    public void setColunas(String[] colunas)
    {
        this.column = colunas;
    }

    public Boolean insert(ProducaoLeite obj)
    {
        if (obj.getDataHora().equals("")) {
            JOptionPane.showMessageDialog(null, "O Data não foi informado!", "Erro", JOptionPane.ERROR_MESSAGE);
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

    public Boolean update(ProducaoLeite obj)
    {
        if (obj.getDataHora().equals("")) {
            JOptionPane.showMessageDialog(null, "O Data não foi informado!", "Erro", JOptionPane.ERROR_MESSAGE);
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

    public Boolean delete(ProducaoLeite obj)
    {
        String msg = objModel.delete(obj);
        if (!msg.equals("")) {
            JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<ProducaoLeite> findByAll()
    {
        this.lstProducaoLeite = objModel.findByAll();
        return this.lstProducaoLeite;
    }

    public ProducaoLeite findById(int id)
    {
        return objModel.findById(id);
    }

    public ArrayList<ProducaoLeite> findByDescricao(String descricao)
    {
        this.lstProducaoLeite = objModel.findByDescricao(descricao);
        return this.lstProducaoLeite;
    }

    //Métodos implementados pela classe AbstractTableModel
    @Override
    public int getRowCount()
    {
        return lstProducaoLeite.size();
    }

    @Override
    public int getColumnCount()
    {
        return column.length;
    }

    @Override
    public Object getValueAt(int linhaIndex, int colunaIndex)
    {

        Object value = null;

        final ProducaoLeite c = (ProducaoLeite) lstProducaoLeite.get(linhaIndex);
        final Animal a = c.getAnimal();

        switch (colunaIndex) {
            case 0:
                value = c.getId();
                break;
            case 1:
                value = c.getDataHora();
                break;
            case 2:
                value = new AnimalModel().findById(a.getId()).getId();
                break;
            case 3:
                value = new AnimalModel().findById(a.getId()).getNome();
                break;
            case 4:
                value = c.getQuantidadeMl();
                break;
        }
        return value;
    }
}
