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
public class PropriedadeRuralModel {

    private final SessionFactory objSessionFactory;
    
    String msg = "";
    
    public PropriedadeRuralModel(){    
        this.objSessionFactory = MinhaFazendaHibernateUtil.getSessionFactory(); 
    }
    
    public String insert(PropriedadeRural obj) {
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
    
    public String update(PropriedadeRural obj) {
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
    
    public String delete(PropriedadeRural obj) {        
        Session objSession = this.objSessionFactory.openSession();    
        Transaction objTransaction = objSession.beginTransaction();
        
        try {    
            Query query = objSession.createQuery("delete PropriedadeRural where id = :id");
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

    public ArrayList<PropriedadeRural> findByAll() {  
        ArrayList<PropriedadeRural> lst = null;  
        Session objSession = this.objSessionFactory.openSession();    

        try {  
            Query objQuery = objSession.createQuery("from PropriedadeRural");
            lst = (ArrayList<PropriedadeRural>)objQuery.list();  
        } catch (ObjectNotFoundException e) {  
            return null;  
        }  
        
        objSession.close();
        return lst;  
    }
    
    public PropriedadeRural findById(int id) {  
        PropriedadeRural obj = null;  
        Session objSession = this.objSessionFactory.openSession();    

        try {  
            obj = (PropriedadeRural)objSession.load(PropriedadeRural.class, id);
        } catch (ObjectNotFoundException e) {  
            return null;  
        }  
        return obj;
    }    
    
    public ArrayList<PropriedadeRural> findByDescricao(String descricao) {  
        ArrayList<PropriedadeRural> lst = null;  
        Session objSession = this.objSessionFactory.openSession();    

        try {  
            Query objQuery = objSession.createQuery("from PropriedadeRural where descricao like '%" + descricao + "%'");
            lst = (ArrayList<PropriedadeRural>)objQuery.list();  
        } catch (ObjectNotFoundException e) {  
            return null;  
        }  
        
        objSession.close();
        return lst;  
    } 
}
