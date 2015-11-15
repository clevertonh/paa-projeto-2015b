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
public class EstadoModel {

    private final SessionFactory objSessionFactory;
    
    String msg = "";
    
    public EstadoModel(){    
        this.objSessionFactory = MinhaFazendaHibernateUtil.getSessionFactory(); 
    }
    
    public String insert(Estado obj) {
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
    
    public String update(Estado obj) {
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
    
    public String delete(Estado obj) {        
        Session objSession = this.objSessionFactory.openSession();    
        Transaction objTransaction = objSession.beginTransaction();
        
        try {    
            Query query = objSession.createQuery("delete estado where id = :id");
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

    public ArrayList<Estado> findByAll() {  
        ArrayList<Estado> lst = null;  
        Session objSession = this.objSessionFactory.openSession();    

        try {  
            Query objQuery = objSession.createQuery("from Estado");
            lst = (ArrayList<Estado>)objQuery.list();  
        } catch (ObjectNotFoundException e) {  
            return null;  
        }  
        
        objSession.close();
        return lst;  
    }
    
    public Estado findById(int id) {  
        Estado obj = null;  
        Session objSession = this.objSessionFactory.openSession();    

        try {  
            obj = (Estado)objSession.load(Estado.class, id);
        } catch (ObjectNotFoundException e) {  
            return null;  
        }  
        return obj;
    }    
    
    public ArrayList<Estado> findByDescricao(String descricao) {  
        ArrayList<Estado> lst = null;  
        Session objSession = this.objSessionFactory.openSession();    

        try {  
            Query objQuery = objSession.createQuery("from Estado where descricao like '%" + descricao + "%'");
            lst = (ArrayList<Estado>)objQuery.list();  
        } catch (ObjectNotFoundException e) {  
            return null;  
        }  
        
        objSession.close();
        return lst;  
    } 
}
