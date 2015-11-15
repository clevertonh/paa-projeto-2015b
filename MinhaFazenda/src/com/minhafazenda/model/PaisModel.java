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
public class PaisModel {

    private final SessionFactory objSessionFactory;
    
    String msg = "";
    
    public PaisModel(){    
        this.objSessionFactory = MinhaFazendaHibernateUtil.getSessionFactory(); 
    }
    
    public String insert(Pais obj) {
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
    
    public String update(Pais obj) {
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
    
    public String delete(Pais obj) {        
        Session objSession = this.objSessionFactory.openSession();    
        Transaction objTransaction = objSession.beginTransaction();
        
        try {    
            Query query = objSession.createQuery("delete pais where id = :id");
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

    public ArrayList<Pais> findByAll() {  
        ArrayList<Pais> lst = null;  
        Session objSession = this.objSessionFactory.openSession();    

        try {  
            Query objQuery = objSession.createQuery("from Pais");
            lst = (ArrayList<Pais>)objQuery.list();  
        } catch (ObjectNotFoundException e) {  
            return null;  
        }  
        
        objSession.close();
        return lst;  
    }
    
    public Pais findById(int id) {  
        Pais obj = null;  
        Session objSession = this.objSessionFactory.openSession();    

        try {  
            obj = (Pais)objSession.load(Pais.class, id);
        } catch (ObjectNotFoundException e) {  
            return null;  
        }  
        return obj;
    }    
    
    public ArrayList<Pais> findByDescricao(String descricao) {  
        ArrayList<Pais> lst = null;  
        Session objSession = this.objSessionFactory.openSession();    

        try {  
            Query objQuery = objSession.createQuery("from Pais where descricao like '%" + descricao + "%'");
            lst = (ArrayList<Pais>)objQuery.list();  
        } catch (ObjectNotFoundException e) {  
            return null;  
        }  
        
        objSession.close();
        return lst;  
    } 
}
