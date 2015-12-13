package com.minhafazenda.model;

import com.minhafazenda.util.MinhaFazendaHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DateType;
import org.hibernate.type.StringType;

/**
 * 
 * @author Cléverton Heming
 */
public class ViewVacinaVencimentoModel {
    private final SessionFactory objSessionFactory;

    public ViewVacinaVencimentoModel() {
        this.objSessionFactory = MinhaFazendaHibernateUtil.getSessionFactory();
    }    
    
    public List findByAll() {

        Session objSession = this.objSessionFactory.openSession();
        Query query = objSession.createSQLQuery("SELECT \n" +
                                                "	vacina_descricao\n" +
                                                "	,vacina_modo_usaro\n" +
                                                "	,vacina_data_vencimento\n" +
                                                "	,vacina_dose\n" +
                                                "	,animal_nome\n" +
                                                "	,animal_raca\n" +
                                                "FROM \n" +
                                                "	view_vacina_vencimento")
                                .addScalar("vacina_descricao", new StringType())
                                .addScalar("vacina_modo_usaro", new StringType())
                                .addScalar("vacina_data_vencimento", new DateType())
                                .addScalar("vacina_dose", new StringType())
                                .addScalar("animal_nome", new StringType())
                                .addScalar("animal_raca", new StringType())
                                .setResultTransformer(Transformers.aliasToBean(ViewVacinaVencimento.class));
        
        return query.list();        
    }    
   
}
