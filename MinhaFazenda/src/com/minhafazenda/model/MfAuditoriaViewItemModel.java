/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.model;

import com.minhafazenda.util.MinhaFazendaHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

/**
 *
 * @author cleverton
 */
public class MfAuditoriaViewItemModel {

    private final SessionFactory objSessionFactory;
    
    String msg = "";
    
    public MfAuditoriaViewItemModel(){    
        this.objSessionFactory = MinhaFazendaHibernateUtil.getSessionFactory(); 
    }
        
    public List<MfAuditoriaViewItem> findByDescricao(Integer idAuditoria, String nomeTabela, String descricao) {

        Session objSession = this.objSessionFactory.openSession();
        Query query = objSession.createSQLQuery(" SELECT id_auditoria_item, id, campo, valor_antigo, valor_novo "
                                                + " FROM " + nomeTabela + "_AUDITORIA_VIEW_item"
                                                + " WHERE id = " + idAuditoria + " AND (" 
                                                + "       campo like '%" + descricao + "%' OR "
                                                + "       valor_antigo like '%" + descricao + "%' OR "
                                                + "       valor_novo like '%" + descricao + "%')")
                .addScalar("id_auditoria_item", new IntegerType())
                .addScalar("id", new IntegerType())
                .addScalar("campo", new StringType())
                .addScalar("valor_antigo", new StringType())
                .addScalar("valor_novo", new StringType())
                .setResultTransformer(Transformers.aliasToBean(MfAuditoriaViewItem.class));
        
        return query.list();        
    }
    
    public List<MfAuditoriaViewItem> findAUditoria(Integer idAuditoria, String nomeTabela) {
        Session objSession = this.objSessionFactory.openSession();
        Query query = objSession.createSQLQuery("SELECT id_auditoria_item, id, campo, valor_antigo, valor_novo "
                                                + " FROM " + nomeTabela + "_AUDITORIA_VIEW_item"
                                                + " WHERE id = " + idAuditoria)
                .addScalar("id_auditoria_item", new IntegerType())
                .addScalar("id", new IntegerType())
                .addScalar("campo", new StringType())
                .addScalar("valor_antigo", new StringType())
                .addScalar("valor_novo", new StringType())
                .setResultTransformer(Transformers.aliasToBean(MfAuditoriaViewItem.class));
        
        return query.list();
    }    

}
