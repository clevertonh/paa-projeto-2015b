/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.controller;

import com.minhafazenda.model.ViewVacinaVencimento;
import com.minhafazenda.model.ViewVacinaVencimentoModel;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cleverton
 */
public class ViewVacinaVencimentoController extends AbstractTableModel {

    private ViewVacinaVencimentoModel objModel;
    private ArrayList<ViewVacinaVencimento> lstVacina = null;    
    private String[] column = { "Descrição", 
                                "Modo de usar", 
                                "Data vencimento", 
                                "Dose", 
                                "Animal",
                                "Raça"};

    public ViewVacinaVencimentoController() {
        this.objModel = new ViewVacinaVencimentoModel();
//        setColunas(new String[]{"vacina_descricao", 
//                                "vacina_modo_usaro", 
//                                "vacina_data_vencimento", 
//                                "vacina_dose", 
//                                "animal_nome", 
//                                "animal_raca"});  
    }    
    
    public String getColumnName(int columnIndex) {
        return column[columnIndex];
    }
    
    public void setColunas(String[] colunas) {
        this.column = colunas;
    }
    
    public ArrayList<ViewVacinaVencimento> findByAll() {       
        this.lstVacina = (ArrayList<ViewVacinaVencimento>) objModel.findByAll();
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
        
        final ViewVacinaVencimento c = (ViewVacinaVencimento) lstVacina.get(linhaIndex);        
        
        switch (colunaIndex) {            
            case 0:                
                value = c.getVacina_descricao();
                break;            
            case 1:                
                value = c.getVacina_modo_usaro();                
                break;            
            case 2:                
                value = c.getVacina_data_vencimento();                
                break;            
            case 3:                
                value = c.getVacina_dose();                
                break;            
            case 4:                
                value = c.getAnimal_nome();                
                break;  
            case 5:                
                value = c.getAnimal_raca();                
                break;  
        }    
        return value;
    }
    
}
