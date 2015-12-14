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
public final class AnimalController extends AbstractTableModel {

    //Cria o objeto do Model
    private final AnimalModel objModel;
    private Formatacao formatacao;
    //Table model
    private ArrayList<Animal> lstAnimal = null;
    private String[] column = {"Código", "Descrição", "Cód. Raça", "Raça", "Cód. Categoria","Categoria", "Sexo", 
                               "Cód. Grau Sangue","Grau de Sangue", "Data de Nascimento", "Botton", "Tipo de Registro",
                               "Código Propriedade", "Propriedade"};

    /*
     * Método construtor da classe
     */
    public AnimalController() {
        //Inicia o objeto model
        this.objModel = new AnimalModel();
        //Inicia a lista da lstColunas para o TableMOdel
        //setColunas(new String[]{"id", "descricao"});  
    }

    public String getColumnName(int columnIndex) {
        return column[columnIndex];
    }

    public void setColunas(String[] colunas) {
        this.column = colunas;
    }

    public Boolean insert(Animal obj) {
        if (obj.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "O nome não foi informado!", "Erro", JOptionPane.ERROR_MESSAGE);
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

    public Boolean update(Animal obj) {
        if (obj.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "O nome não foi informado!", "Erro", JOptionPane.ERROR_MESSAGE);
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

    public Boolean delete(Animal obj) {
        String msg = objModel.delete(obj);
        if (!msg.equals("")) {
            JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<Animal> findByAll() {
        this.lstAnimal = objModel.findByAll();
        return this.lstAnimal;
    }

    public Animal findById(int id) {
        return objModel.findById(id);
    }

    public ArrayList<Animal> findByDescricao(String descricao) {
        this.lstAnimal = objModel.findByDescricao(descricao);
        return this.lstAnimal;
    }

    //Métodos implementados pela classe AbstractTableModel
    @Override
    public int getRowCount() {
        return lstAnimal.size();
    }

    @Override
    public int getColumnCount() {
        return column.length;
    }

    @Override
    public Object getValueAt(int linhaIndex, int colunaIndex) {

        Object value = null;

        final Animal c = (Animal) lstAnimal.get(linhaIndex);
        final Raca ar = c.getRaca();
        final Categoria ac = c.getCategoria();        
        final GrauSangue ags = c.getGrauSangue();        
        final PropriedadeRural apr = c.getPropriedadeRural();       
//        final Integer idPai = c.getAnimalByIdPai().getId();
//        final Animal animalPai = new AnimalModel().findById(idPai);
        final AnimalModel aniModel = new AnimalModel();
        
        switch (colunaIndex) {
            case 0:
                value = c.getId();
                break;
            case 1:
                value = c.getNome();
                break;
            case 2:
                value = new RacaModel().findById(ar.getId()).getId();
                break;
            case 3:
                value = new RacaModel().findById(ar.getId()).getDescricao();
                break;
            case 4:                
                value = new CategoriaModel().findById(ac.getId()).getId(); 
                break;            
            case 5:                
                value = new CategoriaModel().findById(ac.getId()).getDescricao(); 
                break;            
            case 6:                
                value = c.getSexo();                
                break;            
            case 7:                
                value = new GrauSangueModel().findById(ags.getId()).getId();
                break;            
            case 8:                
                value = new GrauSangueModel().findById(ags.getId()).getDescricao();
                break;            
            case 9:
                value = c.getDataNascimento();                
                break;            
            case 10:                
                value = c.getNumeroBotton();                
                break;            
            case 11:                
                value = c.getTipoRegistro();                
                break;            
//            case 12:
////                value = aniModel.findById(c.getId()).getNome();
//                value = c.getAnimalByIdPai();
////                value = "Ajustar";
////               value = new AnimalModel().findById(c.getId()).getNome();                
//                break;            
//            case 13:                
//                value = c.getAnimalByIdMae();
////                value = "Ajustar";               
//                break;            
            case 12:                
                value = new PropriedadeRuralModel().findById(apr.getId()).getId();                
                break;            
            case 13:                
                value = new PropriedadeRuralModel().findById(apr.getId()).getDescricao();                
                break;            
        }
        return value;
    }
}
