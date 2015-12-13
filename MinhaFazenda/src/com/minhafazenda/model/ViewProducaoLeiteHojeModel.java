package com.minhafazenda.model;

import com.minhafazenda.util.MinhaFazendaHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DateType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

/**
 * 
 * @author Cléverton Heming
 */
public class ViewProducaoLeiteHojeModel {
    private final SessionFactory objSessionFactory;

    public ViewProducaoLeiteHojeModel() {
        this.objSessionFactory = MinhaFazendaHibernateUtil.getSessionFactory();
    }    
    
    public List findByAll() {

        Session objSession = this.objSessionFactory.openSession();
        Query query = objSession.createSQLQuery("SELECT \n" +
                                                "	id\n" +
                                                "	,data_hora\n" +
                                                "	,animal_nome\n" +
                                                "	,animal_raca\n" +
                                                "	,animal_categoria\n" +
                                                "	,animal_grau_sangue\n" +
                                                "	,quantidade_ml\n" +
                                                "FROM \n" +
                                                "	view_producao_leite_hoje ")
                                .addScalar("id", new IntegerType())
                                .addScalar("data_hora", new DateType())
                                .addScalar("animal_nome", new StringType())
                                .addScalar("animal_raca", new StringType())
                                .addScalar("animal_categoria", new StringType())
                                .addScalar("animal_grau_sangue", new StringType())
                                .addScalar("quantidade_ml", new IntegerType())
                                .setResultTransformer(Transformers.aliasToBean(ViewProducaoLeiteHoje.class));
        
        return query.list();        
    }    
    
}
