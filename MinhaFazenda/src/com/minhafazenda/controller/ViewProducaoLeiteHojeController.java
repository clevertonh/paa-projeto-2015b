/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.controller;

import com.minhafazenda.model.ViewProducaoLeiteHoje;
import com.minhafazenda.model.ViewProducaoLeiteHojeModel;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cleverton
 */
public class ViewProducaoLeiteHojeController extends AbstractTableModel {

    private ViewProducaoLeiteHojeModel objModel;
    private ArrayList<ViewProducaoLeiteHoje> lstVacina = null;    
    private String[] column = { "Código", 
                                "Data", 
                                "Animal", 
                                "Raça", 
                                "Categoria",
                                "Grau de sangue",
                                "Quantidade"};

    public ViewProducaoLeiteHojeController() {
        this.objModel = new ViewProducaoLeiteHojeModel();
        //setColunas(new String[]{"id", "data_hora", "animal_nome", "animal_raca", "animal_categoria", "animal_grau_sangue", "quantidade_ml"});  
    }    
    
    public String getColumnName(int columnIndex) {
        return column[columnIndex];
    }
    
    public void setColunas(String[] colunas) {
        this.column = colunas;
    }
    
    public ArrayList<ViewProducaoLeiteHoje> findByAll() {       
        this.lstVacina = (ArrayList<ViewProducaoLeiteHoje>) objModel.findByAll();
        return this.lstVacina;
    }        
    
    @Override
    public int getRowCount() {
        return lstVacina.size();
    }
    
    @Override
    public int getColumnCount() {
        return column.length;        
    }
    
    @Override
    public Object getValueAt(int linhaIndex, int colunaIndex) {
        
        Object value = null;        
        
        final ViewProducaoLeiteHoje c = (ViewProducaoLeiteHoje) lstVacina.get(linhaIndex);        
        
        switch (colunaIndex) {            
            case 0:                
                value = c.getId();
                break;            
            case 1:                
                value = c.getData_hora();                
                break;            
            case 2:                
                value = c.getAnimal_nome();                
                break;            
            case 3:                
                value = c.getAnimal_raca();                
                break;            
            case 4:                
                value = c.getAnimal_categoria();                
                break;  
            case 5:                
                value = c.getAnimal_grau_sangue();                
                break;  
            case 6:                
                value = c.getQuantidade_ml();                
                break;  
        }    
        return value;
    }
    
}
