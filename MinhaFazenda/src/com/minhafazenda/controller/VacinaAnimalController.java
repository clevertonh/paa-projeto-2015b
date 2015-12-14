/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.controller;

import com.minhafazenda.model.Animal;
import com.minhafazenda.model.AnimalModel;
import com.minhafazenda.model.Usuario;
import com.minhafazenda.model.UsuarioModel;
import com.minhafazenda.model.Vacina;
import com.minhafazenda.model.VacinaAnimal;
import com.minhafazenda.model.VacinaAnimalModel;
import com.minhafazenda.model.VacinaModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cleverton
 */
public final class VacinaAnimalController extends AbstractTableModel
{

    //Cria o objeto do Model
    private final VacinaAnimalModel objModel;
    //Table model
    private ArrayList<VacinaAnimal> lstVacinaAnimal = null;
    private String[] column = {"Cód. Vacina", "Descrição", "Cód. Animal", "Nome", "Seq.", "Data Aplicação", "Data de Vencimento", "Cód. Usuário", "Usuário", "Dose"};

    /*
     * Método construtor da classe
     */
    public VacinaAnimalController()
    {
        //Inicia o objeto model
        this.objModel = new VacinaAnimalModel();
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

    public Boolean insert(VacinaAnimal obj)
    {
        if (obj.getAnimal().equals("")) {
            JOptionPane.showMessageDialog(null, "A descrição não foi informada!", "Erro", JOptionPane.ERROR_MESSAGE);
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

    public Boolean update(VacinaAnimal obj)
    {
        if (obj.getAnimal().equals("")) {
            JOptionPane.showMessageDialog(null, "A descrição não foi informada!", "Erro", JOptionPane.ERROR_MESSAGE);
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

    public Boolean delete(VacinaAnimal obj)
    {
        String msg = objModel.delete(obj);
        if (!msg.equals("")) {
            JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<VacinaAnimal> findByAll()
    {
        this.lstVacinaAnimal = objModel.findByAll();
        return this.lstVacinaAnimal;
    }

    public VacinaAnimal findById(int id)
    {
        return objModel.findById(id);
    }

    public ArrayList<VacinaAnimal> findByDescricao(String descricao)
    {
        this.lstVacinaAnimal = objModel.findByDescricao(descricao);
        return this.lstVacinaAnimal;
    }

    //Métodos implementados pela classe AbstractTableModel
    @Override
    public int getRowCount()
    {
        return lstVacinaAnimal.size();
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

        final VacinaAnimal va = (VacinaAnimal) lstVacinaAnimal.get(linhaIndex);
        final Vacina v = va.getVacina();
        final Animal a = va.getAnimal();
        final Usuario u = va.getUsuario();

        switch (colunaIndex) {
            case 0:
                value = new VacinaModel().findById(v.getId()).getId();
                break;
            case 1:
                value = new VacinaModel().findById(v.getId()).getDescricao();
                break;
            case 2:
                value = new AnimalModel().findById(a.getId()).getId();
                break;
            case 3:
                value = new AnimalModel().findById(a.getId()).getNome();
                break;
            case 4:
                value = null;
                break;
            case 5:
                value = va.getDataAplicacao();
                break;
            case 6:
                value = va.getDataVencimento();
                break;
            case 7:
                value = new UsuarioModel().findById(u.getId()).getId();
                break;
            case 8:
                value = new UsuarioModel().findById(u.getId()).getUsuario();
                break;
            case 9:
                value = va.getDose();
                break;
        }
        return value;
    }
}
