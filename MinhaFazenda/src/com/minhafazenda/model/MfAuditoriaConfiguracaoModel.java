/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.model;

import com.minhafazenda.util.MinhaFazendaHibernateUtil;
import java.util.ArrayList;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author cleverton
 */
public class MfAuditoriaConfiguracaoModel {

    private final SessionFactory objSessionFactory;
    
    String msg = "";
    
    public MfAuditoriaConfiguracaoModel(){    
        this.objSessionFactory = MinhaFazendaHibernateUtil.getSessionFactory(); 
    }
    
    public String insert(MfAuditoriaConfiguracao obj) {
        Session objSession = this.objSessionFactory.openSession();    
        Transaction objTransaction = objSession.beginTransaction();
        
        try {    
            objSession.save(obj);
            objTransaction.commit();
        } catch (Exception e) {
            this.msg = e.getMessage();
            objTransaction.rollback();
        }
        
        objSession.close();
        return this.msg;
    }
    
    public String update(MfAuditoriaConfiguracao obj) {
        Session objSession = this.objSessionFactory.openSession();    
        Transaction objTransaction = objSession.beginTransaction();
        
        try {    
            objSession.merge(obj);
            objTransaction.commit();
        } catch (Exception e) {
            msg = e.getMessage();
            objTransaction.rollback();
        }
        
        objSession.close();
        return msg;
    }
    
    public String delete(MfAuditoriaConfiguracao obj) {        
        Session objSession = this.objSessionFactory.openSession();    
        Transaction objTransaction = objSession.beginTransaction();
        
        try {    
            Query query = objSession.createQuery("delete MfAuditoriaConfiguracao where id = :id");
            query.setParameter("id", obj.getId());
            query.executeUpdate();
            objTransaction.commit();
        } catch (Exception e) {
            msg = e.getMessage();
            objTransaction.rollback();
        }
        
        objSession.close();
        return msg;
    }    
    
    public ArrayList<MfAuditoriaConfiguracao> findByAll() {  
        ArrayList<MfAuditoriaConfiguracao> lst = null;  
        Session objSession = this.objSessionFactory.openSession();    

        try {  
            Query objQuery = objSession.createQuery("from MfAuditoriaConfiguracao");
            lst = (ArrayList<MfAuditoriaConfiguracao>)objQuery.list();  
        } catch (ObjectNotFoundException e) {  
            return null;  
        }  
        
        objSession.close();
        return lst;  
    }    
    
    public MfAuditoriaConfiguracao findById(int id) {  
        MfAuditoriaConfiguracao obj = null;  
        Session objSession = this.objSessionFactory.openSession();    

        try {  
            obj = (MfAuditoriaConfiguracao)objSession.load(MfAuditoriaConfiguracao.class, id);
        } catch (ObjectNotFoundException e) {  
            return null;  
        }  
        return obj;
    }        
    
    public ArrayList<MfAuditoriaConfiguracao> findByDescricao(String descricao) {  
        ArrayList<MfAuditoriaConfiguracao> lst = null;  
        Session objSession = this.objSessionFactory.openSession();    

        try {  
            Query objQuery = objSession.createQuery("from MfAuditoriaConfiguracao where tabela like '%" + descricao + "%'");
            lst = (ArrayList<MfAuditoriaConfiguracao>)objQuery.list();  
        } catch (ObjectNotFoundException e) {  
            return null;  
        }  
        
        objSession.close();
        return lst;  
    }    
}
