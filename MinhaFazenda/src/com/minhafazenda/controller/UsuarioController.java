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
import com.minhafazenda.util.ComboBoxItem;
import com.minhafazenda.util.MasterLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
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
    private String[] column = {"Código", "Descrição", "Tipo"};

    /*
     * Método construtor da classe
     */
    public UsuarioController(){
        //Inicia o objeto model
        this.objModel = new UsuarioModel();
    }
    
    public String getColumnName(int columnIndex) {
        return column[columnIndex];
    }
    
    public void setColunas(String[] colunas) {
        this.column = colunas;
    }
    
    public Boolean insert(Usuario obj){
        if (obj.getUsuario().equals("")) {
            String tmpMsg = "A descrição não foi informada!";
            //LOG
            MasterLog.addWarning(tmpMsg,UsuarioController.class);
            //Mensagem
            JOptionPane.showMessageDialog(null, tmpMsg, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (obj.getUsuario().length() > 45) {
            String tmpMsg = "Tamanho máximo do campo foi atingido, verifique!";
            //LOG
            MasterLog.addWarning(tmpMsg,UsuarioController.class);
            //Mensagem
            JOptionPane.showMessageDialog(null, tmpMsg, "Verifique", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else {
            String msg = objModel.insert(obj);
            if (!msg.equals("")) {
                //LOG
                MasterLog.addSevere(msg,UsuarioController.class);
                //Erro
                JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                //LOG
                MasterLog.addInfo("Usuário '" + obj.getUsuario() + "' ADICIONADO com sucesso",UsuarioController.class);
                return true;
            }
        }
    }
    
    public Boolean update(Usuario obj) {
        if (obj.getUsuario().equals("")) {
            String tmpMsg = "A descrição não foi informada!";
            //LOG
            MasterLog.addWarning(tmpMsg,UsuarioController.class);
            //Mensagem
            JOptionPane.showMessageDialog(null, tmpMsg, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (obj.getUsuario().length() > 45) {
            String tmpMsg = "Tamanho máximo do campo foi atingido, verifique!";
            //LOG
            MasterLog.addWarning(tmpMsg,UsuarioController.class);
            JOptionPane.showMessageDialog(null, tmpMsg, "Verifique", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else {
            String msg = objModel.update(obj);
            if (!msg.equals("")) {
                //LOG
                MasterLog.addSevere(msg,UsuarioController.class);
                //Erro
                JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                //LOG
                MasterLog.addInfo("Usuário '" + obj.getUsuario() + "' ATUALIZADO com sucesso",UsuarioController.class);
                return true;
            }
        }
    }
    
    public Boolean delete(Usuario obj) {        
        String msg = objModel.delete(obj);
        if (!msg.equals("")) {
            //LOG
            MasterLog.addSevere(msg,UsuarioController.class);
            JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            MasterLog.addSevere("Usuário EXCLUIDO com sucesso ",UsuarioController.class);
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
    
    public ArrayList<Usuario> findByTipoUsuario(Usuario usuario) {        
        this.lstUsuario = objModel.findByBuscarTipoUsuario(usuario);
        return this.lstUsuario;
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
        
        final Usuario c = (Usuario)lstUsuario.get(linhaIndex);  
        final UsuarioTipo ut = c.getUsuarioTipo();
        
        switch (colunaIndex) {            
            case 0:                
                value = c.getId();
                break;            
            case 1:                
                value = c.getUsuario();                
                break;          
            case 2:
                //UsuarioTipo objTipo = new UsuarioTipoModel().findById(ut.getId());
                //value = objTipo.getDescricao();
                //Pode ser usado direto conforme linha abaixo
                value = new UsuarioTipoModel().findById(ut.getId()).getDescricao();
                break; 
            default:  
                return null;  
        }
        
        return value;
    }
    
    public static ComboBoxModel carregaComboTipoUsuario(){  
        List lstUsuarioTipo = null;
        UsuarioTipo obj = new UsuarioTipo();
        ComboBoxModel bRetorno;  
        Vector v = new Vector();          
        
        UsuarioTipoController objTipo = new UsuarioTipoController();
        lstUsuarioTipo = objTipo.findByAll();
        
        v.add(null);  
        
        for (Object item : lstUsuarioTipo) {  
            //Lê cada item retornado pelo SELECT e adiciona o Nome do estado ao vector  
            obj = (UsuarioTipo)item;  
            v.add(new ComboBoxItem(obj.getId(),obj.getDescricao()));  
            //v.add(item);
        }  
        
        bRetorno = new DefaultComboBoxModel(v);  
  
        return bRetorno;  
    } 
}


