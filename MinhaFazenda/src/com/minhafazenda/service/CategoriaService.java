/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.service;

import com.minhafazenda.model.Categoria;
import com.minhafazenda.util.MinhaFazendaHibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author cleverton
 */
public class CategoriaService {

    private SessionFactory objSessionFactory;
    //String para mensagem de erro
    String msg = "";
    
    public CategoriaService(){
        //Recebe o Session Factory do HIbernate
        this.objSessionFactory = MinhaFazendaHibernateUtil.getSessionFactory();    
    }
    
    public String insert(Categoria obj) {    
        //Abre um sessão
        Session objSession = this.objSessionFactory.openSession();    
        //Inicia uma transação dentro da sessão aberta
        Transaction objTransaction = objSession.beginTransaction();
        
        try {    
            //ADICIONA o objeto categoria, assim o hibernate persiste no bancoapagando o registro.
            objSession.save(obj);
            //Realiza um commit do INSERT
            objTransaction.commit();
        } catch (Exception e) {
            //Caso ocorrer algum erro, mostra uma mensagem
            this.msg = e.getMessage();
            //Realiza o Rollback, cancelando o INSERT no banco de dados.
            objTransaction.rollback();
        }
        
        //Fecha a sessão
        objSession.close();
        //Retorna a mensagem
        return this.msg;
    }
    
    public String update(Categoria obj) {
        //Abre um sessão
        Session objSession = this.objSessionFactory.openSession();    
        //Inicia uma transação dentro da sessão aberta
        Transaction objTransaction = objSession.beginTransaction();
        
        try {    
            //ATUALIZA o objeto categoria, assim o hibernate persiste no bancoapagando o registro.
            objSession.merge(obj);
            //Realiza um commit do UPDATE
            objTransaction.commit();
        } catch (Exception e) {
            //Caso ocorrer algum erro, mostra uma mensagem
            msg = e.getMessage();
            //Realiza o Rollback, cancelando o UPDATE no banco de dados.
            objTransaction.rollback();
        }
        
        //Fecha a sessão
        objSession.close();
        //Retorna a mensagem
        return msg;
    }
    
    public String delete(Categoria obj){
        //Abre um sessão
        Session objSession = this.objSessionFactory.openSession();    
        //Inicia uma transação dentro da sessão aberta
        Transaction objTransaction = objSession.beginTransaction();
        
        try {    
            //ATUALIZA o objeto categoria, assim o hibernate persiste no bancoapagando o registro.
            objSession.delete(obj);
            //Realiza um commit do UPDATE
            objTransaction.commit();
        } catch (Exception e) {
            //Caso ocorrer algum erro, mostra uma mensagem
            msg = e.getMessage();
            //Realiza o Rollback, cancelando o UPDATE no banco de dados.
            objTransaction.rollback();
        }
        
        //Fecha a sessão
        objSession.close();
        //Retorna a mensagem
        return msg;
    
    }
    
}
