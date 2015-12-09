/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.model;

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
public class MfAuditoriaViewModel {

    private final SessionFactory objSessionFactory;
    
    String msg = "";
    
    public MfAuditoriaViewModel(){    
        this.objSessionFactory = MinhaFazendaHibernateUtil.getSessionFactory(); 
    }
        
    public List<MfAuditoriaView> findByDescricao(String nomeTabela, String descricao) {

        Session objSession = this.objSessionFactory.openSession();
        Query query = objSession.createSQLQuery(" SELECT id, usuario, chave_primaria_1, chave_primaria_2, acao, data_hora  "
                                                + " FROM " + nomeTabela + "_AUDITORIA_VIEW"
                                                + " WHERE usuario like '%" + descricao + "%' OR "
                                                + "       chave_primaria_1 like '%" + descricao + "%' OR "
                                                + "       chave_primaria_2 like '%" + descricao + "%' OR "
                                                + "       acao like '%" + descricao + "%'")
                .addScalar("id", new IntegerType())
                .addScalar("usuario", new StringType())
                .addScalar("chave_primaria_1", new StringType())
                .addScalar("chave_primaria_2", new StringType())
                .addScalar("acao", new StringType())
                .addScalar("data_hora", new DateType())
                .setResultTransformer(Transformers.aliasToBean(MfAuditoriaView.class));
        
        return query.list();        
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

//        List<MfAuditoriaView> list = query.list();
//        for (MfAuditoriaView list_ : list) {
//            System.out.print(list_.getAcao());
//            System.out.print(list_.getChave_primaria_1());
//            System.out.println(list_.getId());
//            
//        }
        
        return query.list();
    }    
    
    
}
