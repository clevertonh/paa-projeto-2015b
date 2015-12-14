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
public class CidadeModel {

    private final SessionFactory objSessionFactory;
    
    String msg = "";
    
    public CidadeModel(){    
        this.objSessionFactory = MinhaFazendaHibernateUtil.getSessionFactory(); 
    }
    
    public String insert(Cidade obj) {
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
    
    public String update(Cidade obj) {
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
    
    public String delete(Cidade obj) {        
        Session objSession = this.objSessionFactory.openSession();    
        Transaction objTransaction = objSession.beginTransaction();
        
        try {    
            Query query = objSession.createQuery("delete cidade where id = :id");
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

    public ArrayList<Cidade> findByAll() {  
        ArrayList<Cidade> lst = null;  
        Session objSession = this.objSessionFactory.openSession();    

        try {  
            Query objQuery = objSession.createQuery("from Cidade");
            lst = (ArrayList<Cidade>)objQuery.list();  
        } catch (ObjectNotFoundException e) {  
            return null;  
        }  
        
        objSession.close();
        return lst;  
    }
    
    public Cidade findById(int id) {  
        Cidade obj = null;  
        Session objSession = this.objSessionFactory.openSession();    

        try {  
            obj = (Cidade)objSession.load(Cidade.class, id);
        } catch (ObjectNotFoundException e) {  
            return null;  
        }  
        return obj;
    }    
    
    public ArrayList<Cidade> findByDescricao(String descricao) {  
        ArrayList<Cidade> lst = null;  
        Session objSession = this.objSessionFactory.openSession();    

        try {  
            Query objQuery = objSession.createQuery("from Cidade where nome like '%" + descricao + "%'");
            lst = (ArrayList<Cidade>)objQuery.list();  
        } catch (ObjectNotFoundException e) {  
            return null;  
        }  
        
        objSession.close();
        return lst;  
    } 
}
