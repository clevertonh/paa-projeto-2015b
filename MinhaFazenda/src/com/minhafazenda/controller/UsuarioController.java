/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.controller;

import com.minhafazenda.model.Usuario;
import com.minhafazenda.model.UsuarioModel;
import com.minhafazenda.model.UsuarioTipo;
import com.minhafazenda.model.UsuarioTipoModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cleverton
 */
public final class UsuarioController extends AbstractTableModel {

    //Cria o objeto do Model
    private final UsuarioModel objModel;
    //Table model
    private ArrayList<Usuario> lstUsuario = null;
    private Usuario usuariot = null;
    private String[] column = {"Código", "Descrição", "Tipo", "Descrição"};

    /*
     * Método construtor da classe
     */
    public UsuarioController() {
        //Inicia o objeto model
        this.objModel = new UsuarioModel();
        //Inicia a lista da lstColunas para o TableMOdel
        //setColunas(new String[]{"id", "descricao"});  
    }
    
    public String getColumnName(int columnIndex) {
        return column[columnIndex];
    }
    
    public void setColunas(String[] colunas) {
        this.column = colunas;
    }
    
    public Boolean insert(Usuario obj) {
        if (obj.getUsuario().equals("")) {
            JOptionPane.showMessageDialog(null, "A descrição não foi informada!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (obj.getUsuario().length() > 45) {
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
    
    public Boolean update(Usuario obj) {
        if (obj.getUsuario().equals("")) {
            JOptionPane.showMessageDialog(null, "A descrição não foi informada!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (obj.getUsuario().length() > 45) {
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
    
    public Boolean delete(Usuario obj) {        
        String msg = objModel.delete(obj);
        if (!msg.equals("")) {
            JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
    
    public ArrayList<Usuario> findByAll() {        
        this.lstUsuario = objModel.findByAll();
        return this.lstUsuario;
    }    
    
    public Usuario findById(int id){
        return objModel.findById(id);
    }
    
    public ArrayList<Usuario> findByUsuario(String usuario) {        
        this.lstUsuario = objModel.findByDescricao(usuario);
        return this.lstUsuario;
    }
    
    public ArrayList<Usuario> findByUsuario(String usuario, String senha) {        
        this.lstUsuario = objModel.findByValidarUsuario(usuario, senha);
        //Valida se a lista de usuário é maior que zero.
        if(this.lstUsuario.size()>0){
         return this.lstUsuario;   
        }else{
            return null;
        }
        
    }
    

    //Métodos implementados pela classe AbstractTableModel
    @Override
    public int getRowCount() {
        return lstUsuario.size();
    }
    
    @Override
    public int getColumnCount() {
        return column.length;        
    }
    
    @Override
    public Object getValueAt(int linhaIndex, int colunaIndex) {
        
        Object value = null;        
        
        final Usuario c = (Usuario) lstUsuario.get(linhaIndex);  
        final UsuarioTipo ut = c.getUsuarioTipo();
        
        switch (colunaIndex) {            
            case 0:                
                value = c.getId();
                break;            
            case 1:                
                value = c.getUsuario();                
                break;          
            case 2:
                value = ut.getId();
                break; 
            case 3:
                String teste ="teste";
                value = teste;
                break; 
            default:  
                return null;  
        }
        
        return value;
    }
}
