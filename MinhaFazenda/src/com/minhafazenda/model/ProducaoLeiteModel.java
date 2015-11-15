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
public class ProducaoLeiteModel {

    private final SessionFactory objSessionFactory;
    
    String msg = "";
    
    public ProducaoLeiteModel(){    
        this.objSessionFactory = MinhaFazendaHibernateUtil.getSessionFactory(); 
    }
    
    public String insert(ProducaoLeite obj) {
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
    
    public String update(ProducaoLeite obj) {
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
    
    public String delete(ProducaoLeite obj) {        
        Session objSession = this.objSessionFactory.openSession();    
        Transaction objTransaction = objSession.beginTransaction();
        
        try {    
            Query query = objSession.createQuery("delete ProducaoLeite where id = :id");
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

    public ArrayList<ProducaoLeite> findByAll() {  
        ArrayList<ProducaoLeite> lst = null;  
        Session objSession = this.objSessionFactory.openSession();    

        try {  
            Query objQuery = objSession.createQuery("from ProducaoLeite");
            lst = (ArrayList<ProducaoLeite>)objQuery.list();  
        } catch (ObjectNotFoundException e) {  
            return null;  
        }  
        
        objSession.close();
        return lst;  
    }
    
    public ProducaoLeite findById(int id) {  
        ProducaoLeite obj = null;  
        Session objSession = this.objSessionFactory.openSession();    

        try {  
            obj = (ProducaoLeite)objSession.load(ProducaoLeite.class, id);
        } catch (ObjectNotFoundException e) {  
            return null;  
        }  
        return obj;
    }    
    
    public ArrayList<ProducaoLeite> findByDescricao(String descricao) {  
        ArrayList<ProducaoLeite> lst = null;  
        Session objSession = this.objSessionFactory.openSession();    

        try {  
            Query objQuery = objSession.createQuery("from ProducaoLeite where descricao like '%" + descricao + "%'");
            lst = (ArrayList<ProducaoLeite>)objQuery.list();  
        } catch (ObjectNotFoundException e) {  
            return null;  
        }  
        
        objSession.close();
        return lst;  
    } 
}
