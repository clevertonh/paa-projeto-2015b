/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.model;

import com.minhafazenda.controller.MfAuditoriaConfiguracaoController;
import com.minhafazenda.util.MinhaFazendaHibernateUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DateType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

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
    
    public String deleteByTabela(String tabela) {        
        Session objSession = this.objSessionFactory.openSession();    
        Transaction objTransaction = objSession.beginTransaction();
        
        try {    
            Query query = objSession.createQuery("delete MfAuditoriaConfiguracao where tabela = :tabela");
            query.setParameter("tabela",tabela);
            query.executeUpdate();
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
            Query objQuery = objSession.createQuery("from MfAuditoriaConfiguracao where tabela like '%" + descricao + "%' OR "
                    + " trigger_delete like '%" + descricao + "%' OR "
                    + " trigger_insert like '%" + descricao + "%' OR "
                    + " trigger_update like '%" + descricao + "%' OR "
                    + " view_auditoria like '%" + descricao + "%' OR "
                    + " view_auditoria_item like '%" + descricao + "%'");
       
            lst = (ArrayList<MfAuditoriaConfiguracao>)objQuery.list();  
        } catch (ObjectNotFoundException e) {  
            return null;  
        }  
        
        objSession.close();
        return lst;  
    }
    
    public ArrayList<String> findByAllTabela(){
        ArrayList<String> lst = null;
    
        Session objSession = this.objSessionFactory.openSession();
        
        Query query = objSession.createSQLQuery("   SELECT \n" +
                                                "	TABLE_NAME\n" +
                                                "   FROM \n" +
                                                "	information_schema.tables\n" +
                                                "   WHERE \n" +
                                                "	TABLE_SCHEMA = 'fazenda'\n" +
                                                "	AND TABLE_TYPE = 'BASE TABLE' \n" +
                                                "	AND TABLE_NAME NOT IN (SELECT tabela FROM fazenda.mf_auditoria_configuracao) \n" +
                                                "       AND TABLE_NAME NOT IN ('mf_auditoria_configuracao','mf_auditoria','mf_auditoria_item')" +
                                                "   ORDER BY \n" +
                                                "	TABLE_NAME");
        lst = (ArrayList<String>)query.list();
        
        return lst;
    }
    
    public void criaProcedureViewAuditoria(String nomeTabela){
        Configuration configuration = new Configuration();
        configuration.configure();
        
        String DBURL = configuration.getProperty("hibernate.connection.url");
        String DBDRIVER = configuration.getProperty("hibernate.connection.driver_class");
        String usuario = configuration.getProperty("hibernate.connection.username");
        String senha = configuration.getProperty("hibernate.connection.password");
        String database = configuration.getProperty("hibernate.connection.database");
        
        DBURL += "&user=" + usuario + "&password=" + senha;
        Statement stmt = null;
        
        try {
            try {
                Class.forName(DBDRIVER).newInstance();
                
                Connection connection = DriverManager.getConnection(DBURL);
                stmt = connection.createStatement();    
            } catch (InstantiationException | IllegalAccessException | SQLException ex) {
                Logger.getLogger(MfAuditoriaConfiguracaoModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MfAuditoriaConfiguracaoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Session objSession = this.objSessionFactory.openSession();
        
        Query query = objSession.createSQLQuery("CALL mf_auditoria_gerar_script(:nome_banco, :nome_tabela, @errors)")
                                .setParameter("nome_banco",database)
                                .setParameter("nome_tabela",nomeTabela);

        for (Object obj : query.list()) {
            try {
                stmt.execute(obj.toString());
            } catch (SQLException ex) {
                Logger.getLogger(MfAuditoriaConfiguracaoModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
        
    }
    
    public void desativaAuditoria(String nomeTabela){
        Session objSession = this.objSessionFactory.openSession();
        
        Query query = objSession.createSQLQuery("CALL mf_auditoria_remover(:nome_banco, :nome_tabela)")
                                .setParameter("nome_banco","fazenda")
                                .setParameter("nome_tabela",nomeTabela);
        
        for (Object obj : query.list()) {
            objSession.createSQLQuery(obj.toString()).executeUpdate();            
        }      
    }
    
    
    public List<MfAuditoriaView> findAUditoria(String nomeTabela) {
        Session objSession = this.objSessionFactory.openSession();
        Query query = objSession.createSQLQuery("SELECT id, usuario, chave_primaria_1, chave_primaria_2, acao, data_hora  FROM " + nomeTabela + "_AUDITORIA_VIEW")
                .addScalar("id", new IntegerType())
                .addScalar("usuario", new StringType())
                .addScalar("chave_primaria_1", new StringType())
                .addScalar("chave_primaria_2", new StringType())
                .addScalar("acao", new StringType())
                .addScalar("data_hora", new DateType())
                .setResultTransformer(Transformers.aliasToBean(MfAuditoriaView.class));
        
        return query.list();
    }    
    
    
}
